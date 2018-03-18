package main;

import com.util.ConnectionConfiguration;

import java.sql.*;

public class List {

    private Connection conn;

    public List (Connection conn) {
        try{
            this.conn = conn;
        } catch(Exception e){
            System.out.println("Failed to connect to database");
        }
    }

    public void listWorkouts (int n){
        System.out.println("Her er de " + n +" siste treningsøktene:");
        System.out.println("    Dato    |    Start    | Form |   Notat            | Id");
        final String sql = "SELECT * FROM workout ORDER BY date DESC, startTime DESC LIMIT " + n;
        pstatement(sql);
    }

    public void listExercises (String startDato, String stopDato) {
        System.out.println("Her er resultat fra treningsøvelsene i tidsperioden " + startDato + "  -  " + stopDato + " :");
        System.out.println("   Varighet    |   Ytelse     ");
        final String sql = "SELECT workout_has_exercise.duration, workout_has_exercise.performance, workout_has_exercise.Workout_id FROM ((workout_has_exercise INNER JOIN exercise ON workout_has_exercise.Exercise_id = exercise.id) INNER JOIN workout ON workout_has_exercise.Workout_id = workout.id) WHERE " +startDato+ "< workout.date < "+stopDato;
        pstatement(sql);
    }

    public void  listExercisesInGroup(String name){
        System.out.println("Her er alle treningsøvelsene i gruppen " + name + " :");
        System.out.println("   Id   |    Navn    |     Beskrivelse     ");
        final String sql = "SELECT exercise.id, exercise.name, exercise.description FROM ((exercise INNER JOIN exercise_has_exercisegroup ON exercise.id = exercise_has_exercisegroup.Exercise_id) INNER JOIN exercisegroup ON exercisegroup.id = exercise_has_exercisegroup.ExerciseGroup_id) WHERE exercisegroup.name = '" +name+"'";
        pstatement(sql);
    }

    public void listExerciseswithEquipment(String startDato, String stopDato){
        System.out.println("Her er alle treningsøvelsene for hvert treningsapparat i tidsperioden " + startDato + "  -  " + stopDato + " :");
        System.out.println("  Id  |    Navn    |      Beskrivelse      ");
        final String sql = "SELECT exercise.id, exercise.name, exercise.description FROM ((exercise INNER JOIN (exercise_has_equipment INNER JOIN equipment ON exercise_has_equipment.Equipment_id = equipment.id) ON exercise.id = exercise_has_equipment.Exercise_id) INNER JOIN (workout INNER JOIN workout_has_exercise ON workout.id = workout_has_exercise.Workout_id) ON workout_has_exercise.Exercise_id = exercise.id) WHERE "+startDato+ "< workout.date < "+stopDato ;
        pstatement(sql);
    }

    public void pstatement (String sql){
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for(int i = 1; i < columnsNumber + 1; i++) {
                	if (i == columnsNumber) {
		                System.out.print(rs.getString(i));
	                } else {
                		System.out.print(rs.getString(i) + "  |   ");
	                }
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }




    public static void main(String[] args){
        Connection conn = ConnectionConfiguration.getConnection();
        Add adder = new Add(conn);
        List lister = new List(conn);


    }


}
