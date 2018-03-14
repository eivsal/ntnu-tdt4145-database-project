package main.tests;

import com.util.ConnectionConfiguration;
import main.Add;

import java.sql.Connection;

public class AddTest {
    private Connection conn = ConnectionConfiguration.getConnection();
    private Add adder = new Add(conn);

    public void shouldAddExercise(){
        adder.clearDatabase();
        adder.addExercise("bølla", "buksevann");
    }

    public void shouldAddWorkout(){
        adder.clearDatabase();
        adder.addWorkout("1994-07-21", "01:52:12", 5, "Løp fort");
    }

    public void shouldAddEquipment(){
        adder.clearDatabase();
        adder.addEquipment("Bryst", "Pumpmeister2000");
    }

    public void shouldAddExerciseGroup(){
        adder.clearDatabase();
        adder.addExerciseGroup("Løping");
    }

    public static void main(String[] args){
        AddTest test = new AddTest();
        test.shouldAddExercise();
        test.shouldAddEquipment();
        test.shouldAddExerciseGroup();
        test.shouldAddWorkout();
    }

}
