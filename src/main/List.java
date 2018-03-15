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
        final String sql = "SELECT * FROM workout ORDER BY date DESC, startTime DESC LIMIT " + n;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for(int i = 1; i < columnsNumber; i++)
                    System.out.print(rs.getString(i) + " ");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void listExercises (String startDato, String stopDato, String startTime, String stopTime) {
        final String sql = "SELECT workout_has_exercise.duration, workout_has_exercise.performance "
                + "FROM ((workout_has_exercise INNER JOIN exercise ON workout_has_exercise.Exercise_id = "
                + "workout.id) INNER JOIN workout ON workout_has_exercise.Workout_id = workout.id)"
                + "WHERE ";
    }



    public static void main(String[] args){
        Connection conn = ConnectionConfiguration.getConnection();
        Add adder = new Add(conn);
        List lister = new List(conn);
        lister.listWorkouts(4);
    }

}
