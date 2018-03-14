package main.tests;

import com.util.ConnectionConfiguration;
import main.Add;
import main.Connect;

import java.sql.Connection;

public class ConnectTest {
    private Connection conn = ConnectionConfiguration.getConnection();
    private Connect connector = new Connect(conn);
    private Add adder = new Add(conn);

    public void shouldConnectEquipmentToExercise(){
        connector.clearDatabase();
        adder.addExercise("bølla", "buksevann");
        adder.addEquipment("Trene ben", "");
        //connector.connectEquipmentToExercise(1,1,120.5f,4);
    }

    /*public void shouldAddWorkout(){
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
    */
    public static void main(String[] args) {
        ConnectTest test = new ConnectTest();
        //test.shouldConnectEquipmentToExercise();
        //connector.connectExerciseToExerciseGroup(1,1);
        //connector.connectExerciseToWorkout(1,2,"00:50:00", 10);
    }
}
