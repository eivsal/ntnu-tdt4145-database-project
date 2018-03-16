package terminalController;

import com.util.ConnectionConfiguration;
import main.Add;
import main.Connect;

import java.sql.Connection;

public class MainController {

	private String command = null;
	private String[] args;
	Connection conn;


	private MainController(Connection conn, String[] args) {
		this.conn = conn;
		this.args = args;
		if (args.length == 0) {
			System.out.println("Error: No argument specified\n");
			help();
		} else {
			switch (args[0]) {
				case "add":
				case "--add":
				case "-a":
					add();
					break;

				case "list":
				case "--list":
				case "-l":
					System.out.println("TODO: 'List' function"); // TODO: 'List' function
					break;

				case "connect":
				case "--connect":
				case "-c":
					connect();
					break;

				case "help":
				case "--help":
				case "-h":
					help();
					break;

				default:
					System.out.println("Error: Unknown argument\n");
					help();
					break;
			}
		}
	}

	private void help() {
		System.out.println("Commands: help, add, list, connect");
		System.out.println("  help, -h, --help:       Display this message.");
		System.out.println("  list, -l, --list:       ");
		System.out.println("  add, -a, --add:         [help/workout/exercise/equipment/group] [data]");
		System.out.println("  connect, -c, --connect: [exercise/equipment/group] [data]");
	}

	private void connect() {
		String usage = "Usage: " + args[0] + " [workout/exercise/equipment/group] [data]";
		if (this.args.length == 1) {
			System.out.println("Error: Too few arguments\n");
			System.out.println(usage);
		} else {
			switch (this.args[1]) {
				case "help":
					// Example: --connect help
					System.out.println("Connect commands: exercise, equipment, group");
					System.out.println("  exercise:   " + args[0] + " exercise [workout ID] [exercise ID] [duration in minutes] [performance: 0-10]");
					System.out.println("  equipment:  " + args[0] + " equipment [exercise ID] [equipment ID] [kilos] [sets]");
					System.out.println("  group:      " + args[0] + " group [exercise ID] [group ID]");
					break;
				case "exercise":
					// Example: --connect exercise 3 3 40 3
					usage = "Usage: " + args[0] + " exercise [workout ID] [exercise ID] [duration in minutes] [performance: 0-10]";
					if (args.length < 6) {
						System.out.println("Error: Too few arguments");
						System.out.println(usage);
					} else if(args.length > 6) {
						System.out.println("Error: Too many arguments");
						System.out.println(usage);
					} else {
						Connect connector = new Connect(conn);
						connector.connectExerciseToWorkout(Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[4], Integer.parseInt(args[5]));
					}
					break;
				case "equipment":
					// Example: --connect equipment 1 1 10.2 4
					usage = "Usage: " + args[0] + " equipment [exercise ID] [equipment ID]  [kilos] [number of sets]";
					if (args.length < 6) {
						System.out.println("Error: Too few arguments");
						System.out.println(usage);
					} else if(args.length > 6) {
						System.out.println("Error: Too many arguments");
						System.out.println(usage);
					} else {
						Connect connector = new Connect(conn);
						connector.connectEquipmentToExercise(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Float.parseFloat(args[4]), Integer.parseInt(args[5]));
					}
					break;
				case "group":
					// Example: --connect group 1 1
					usage = "Usage: " + args[0] + " equipment [exercise ID] [group ID]";
					if (args.length < 4) {
						System.out.println("Error: Too few arguments");
						System.out.println(usage);
					} else if(args.length > 4) {
						System.out.println("Error: Too many arguments");
						System.out.println(usage);
					} else {
						Connect connector = new Connect(conn);
						connector.connectExerciseToExerciseGroup(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
					}
					break;
				default:
					System.out.println("Error: Unknown argument '" + this.args[1] + "'");
					System.out.println(usage);
					break;
			}
		}
	}

	private void add() {
		String usage = "Usage: " + args[0] + " [workout/exercise/equipment/group] [data]";
		if (this.args.length == 1) {
			System.out.println("Error: Too few arguments\n");
			System.out.println(usage);
		} else {
			switch (this.args[1]) {
				case "help":
					System.out.println("Add commands: workout, exercise, equipment, group");
					System.out.println("  workout:   " + args[0] + " workout [date: YYYY:MM:DD] [start time: HH:MM:SS] [shape: 0-10] [note: \"note about workout\"]");
					System.out.println("  exercise:  " + args[0] + " exercise [name] [description: \"description of exercise\"]");
					System.out.println("  equipment: " + args[0] + " equipment [name] [description: \"description of equipment\"]");
					System.out.println("  group:     " + args[0] + " group [name]");
					break;

				case "workout":
					usage = "Usage: " + args[0] + " workout [date: YYYY:MM:DD] [start time: HH:MM:SS] [shape: 0-10] [note: \"note about workout\"] ";
					if (args.length < 6) {
						System.out.println("Error: Too few arguments");
						System.out.println(usage);
					} else if(args.length > 6) {
						System.out.println("Error: Too many arguments");
						System.out.println(usage);
					} else {
						Add adder = new Add(this.conn);
						adder.addWorkout(args[2], args[3], Integer.parseInt(args[4]), args[5]);
					}
					break;

				case "exercise":
					usage = "Usage: " + args[0] + " exercise [name] [description: \"description of exercise\"] ";
					if (args.length < 4) {
						System.out.println("Error: Too few arguments");
						System.out.println(usage);
					} else if (args.length > 4) {
						System.out.println("Error: Too many arguments");
						System.out.println(usage);
					} else {
						Add adder = new Add(this.conn);
						adder.addExercise(args[2], args[3]);
					}
					break;

				case "equipment":
					usage = "Usage: " + args[0] + " equipment [name] [description: \"description of equipment\"] ";
					if (args.length < 4) {
						System.out.println("Error: Too few arguments");
						System.out.println(usage);
					} else if (args.length > 4) {
						System.out.println("Error: Too many arguments");
						System.out.println(usage);
					} else {
						Add adder = new Add(this.conn);
						adder.addEquipment(args[3], args[2]);
					}
					break;

				case "group":
					usage = "Usage: " + args[0] + " group [name]";
					if (args.length < 3) {
						System.out.println("Error: Too few arguments");
						System.out.println(usage);
					} else if (args.length > 3) {
						System.out.println("Error: Too many arguments");
						System.out.println(usage);
					} else {
						Add adder = new Add(this.conn);
						adder.addExerciseGroup(args[2]);
					}
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
		new MainController(conn, args);
	}
}
