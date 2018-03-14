package terminalController;

public class MainController {

	private String command = null;
	private String[] args;

	private MainController(String[] args) {
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
		System.out.println("THIS IS HOW YOU DO:");
		System.out.println("help:     See this, duh.");
		System.out.println("add:      See this, duh.");
		System.out.println("list:     See this, duh.");
		System.out.println("connect:  See this, duh.");
	}

	private void add() {
		String usage = "Usage: add [workout/exercise/equipment/group] [data]";
		if (this.args.length == 1) {
			System.out.println("Error: Too few arguments");
			System.out.println(usage);
		} else {
			switch (this.args[1]) {
				case "workout":
					if (args.length <= 6) {
						System.out.println("Error: Too few arguments");
						usage = "Usage: add workout [date: YYYY:MM:DD] [start time: HH:MM:SS] [shape: 0-10] [note: \"text\"] ";
						System.out.println(usage);
					}
					System.out.println("Run addWorkout"); // TODO: 'addWorkout' function
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
		MainController mainController = new MainController(args);
	}
}
