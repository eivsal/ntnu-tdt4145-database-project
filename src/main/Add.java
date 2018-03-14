package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add {
    private Connection conn;

    public Add (Connection conn) {
        try{
            this.conn = conn;
        } catch(Exception e){
            System.out.println("Failed to connect to database");
        }
    }

    public void addWorkout(String date, String startTime, int shape, String note){
        final String sql = "INSERT INTO workout(Date, StartTime, Shape, Note)"
                + " VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            setParameters(statement, date, startTime, shape, note);
            statement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addExercise(String name, String description){
        final String sql = "INSERT INTO exercise(name, description)"
                + " VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            setParameters(statement, name, description);
            statement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addEquipment(String description, String name){
        final String sql = "INSERT INTO equipment(description, name)"
                + " VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            setParameters(statement, name, description);
            statement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addExerciseGroup(String name){
        final String sql = "INSERT INTO exercisegroup(name)"
                + " VALUES (?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            setParameters(statement, name);
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

}
