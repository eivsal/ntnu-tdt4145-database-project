package main;

import com.util.ConnectionConfiguration;

import java.sql.Connection;

public class AddTest {

    public static void main(String[] args){
        Connection conn = ConnectionConfiguration.getConnection();
        Add adder = new Add(conn);
        //adder.addWorkout("1994-07-21", "01:52:12", 5, "Løp fort");
        //adder.addExercise("bølla", "buksevann");
    }


}
