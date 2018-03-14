package terminalController;

import com.util.ConnectionConfiguration;
import main.Add;

import java.sql.Connection;

public class MainController {

	private String command = null;
	private String[] args;
	Connection conn;


	private MainController(Connection conn, String[] args) {
		this.conn = conn;
		this.args = args;
		if (args.length == 0) {
			System.out.println("Error: No argument specified, see 'help' for usage instructions.");
		} else {
			boolean isFunc = testForFunc(args[0]);
			if (isFunc) {
				switch (this.command) {
					case "add":
						add();
						break;
					case "list":
						System.out.println("TODO: 'List' function"); // TODO: 'List' function
						break;
					case "connect":
						System.out.println("TODO: 'Connect' function"); // TODO: 'Connect' function
						break;
					case "help":
						help();
						break;
				}
			} else {
				System.out.println("Error: Unknown argument, see 'help' for usage instructions.");
			}
		}
	}

	private boolean testForFunc(String arg) {
		if (arg.equals("help")) {
			this.command = "help";
			return true;
		} else if (arg.equals("add")) {
			this.command = "add";
			return true;
		}
		return false;
	}

	private void help() {
		System.out.println(":");
		System.out.println("help:     Display this message.");
		System.out.println("add:      [workout/exercise/equipment/group] [data]");
		System.out.println("list:     ");
		System.out.println("connect:  ");
	}

	private void add() {
		String usage = "Usage: add [workout/exercise/equipment/group] [data]";
		if (this.args.length == 1) {
			System.out.println("Error: Too few arguments");
			System.out.println(usage);
		} else {
			switch (this.args[1]) {
				case "workout":
					if (args.length < 6) {
						System.out.println("Error: Too few arguments");
						usage = "Usage: add workout [date: YYYY:MM:DD] [start time: HH:MM:SS] [shape: 0-10] [note: \"text\"] ";
						System.out.println(usage);
					}
					System.out.println("Run addWorkout"); // TODO: 'addWorkout' function
					Add adder = new Add(this.conn);
//					System.out.println(args[2] + args[3] + args[4] + args[5]);
					adder.addWorkout(args[2], args[3], Integer.parseInt(args[4]), args[5]);
//					adder.addWorkout("1994-07-21", "01:52:12", 5, "Løpfort");
					break;
				case "exercise":
					System.out.println("Run addExercise"); // TODO: 'addExercise' function
					break;
				case "equipment":
					System.out.println("Run addEquipment"); // TODO: 'addEquipment' function
					break;
				case "group":
					System.out.println("Run addGroup"); // TODO: 'addGroup' function

					break;
				default:
					System.out.println("Error: Unknown argument '" + this.args[1] + "'");
					System.out.println(usage);
					break;
			}
		}
	}

	public static void main(String[] args) {
		Connection conn = ConnectionConfiguration.getConnection();
		MainController mainController = new MainController(conn, args);
	}
}
