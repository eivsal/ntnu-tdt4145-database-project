package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Connect {
    private Connection conn;

    public Connect (Connection conn) {
        try{
            this.conn = conn;
        } catch(Exception e){
            System.out.println("Failed to connect to database");
        }
    }

    public void connectExerciseToWorkout(int workout_id, int exrcise_id, String duration, int performance){
        final String sql = "INSERT INTO workout_has_exercise(workout_id, exercise_id, duration, performance)"
                + " VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            setParameters(statement, workout_id, exrcise_id, duration, performance);
            statement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void connectExerciseToExerciseGroup(int exercise_id, int exerciseGroup_id){
        final String sql = "INSERT INTO exercise_has_exercisegroup(exercise_id, exerciseGroup_id)"
                + " VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            setParameters(statement, exercise_id, exerciseGroup_id);
            statement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void connectEquipmentToExercise(int exrcise_id, int equipment_id, float kilos, int sets){
        final String sql = "INSERT INTO exercise_has_equipment(exercise_id, equipment_id, kilos, sets)"
                + " VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            setParameters(statement, exrcise_id, equipment_id, kilos, sets);
            statement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void setParameters(PreparedStatement statement, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            // Parameters are 1-indexed
            statement.setObject(i + 1, parameters[i]);
        }
    }

    public void clearDatabase(){
        String[] list = {"equipment", "exercise", "workout", "exercisegroup"};
        for(int i = 0; i < list.length; i++){
            String sql = "DELETE FROM " + list[i];
            try (PreparedStatement statement = conn.prepareStatement(sql)){
                statement.execute();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
