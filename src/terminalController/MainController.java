package terminalController;

public class MainController {

	private String command = null;

	private MainController(String[] args) {
		if (args.length == 0) {
			System.out.println("No argument specified, see 'help' for usage instructions.");
		} else {
			boolean isFunc = testForFunc(args[0]);
			if (isFunc) {
				if (this.command.equals("add")) {
					System.out.println("TODO: 'Add' function"); // TODO: 'Add' function
				} else if (this.command.equals("list")) {
					System.out.println("TODO: 'List' function"); // TODO: 'List' function
				} else if (this.command.equals("connect")) {
					System.out.println("TODO: 'Connect' function"); // TODO: 'Connect' function
				} else if (this.command.equals("help")) {
					printHelp();
				}
			} else {
				System.out.println("Unknown argument, see 'help' for usage instructions.");
			}
		}
	}

	private boolean testForFunc(String arg) {
		if (arg.equals("help")) {
//			printHelp();
			this.command = "help";
			return true;
		} else if (arg.equals("add")) {
			this.command = "add";
			return true;
		}
		return false;
	}

	private void printHelp() {
		System.out.println("THIS IS HOW YOU DO:");
		System.out.println("help:     See this, duh.");
		System.out.println("add:      See this, duh.");
		System.out.println("list:     See this, duh.");
		System.out.println("connect:  See this, duh.");
	}

	public static void main(String[] args) {
		MainController mainController = new MainController(args);
	}
}
