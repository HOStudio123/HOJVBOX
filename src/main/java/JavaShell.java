import java.util.*;
import java.text.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaShell {
	public static void main(String[] args) {
		// Define color
		String reset = "\033[0m";
		String green = reset + "\033[92m";
		String yellow = reset + "\033[93m";
		String cyan = reset + "\033[96m";
        // Define command
        String command;
        // Define information
        String version = "0.0.1";
        String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String javaVersion = System.getProperty("java.version");
		// Date
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
		// Scanner
		Scanner scanner = new Scanner(System.in);
		// Header
		System.out.println(cyan + "WELCOME TO HOJVBOX\n" + green + "[USER:" + userName + "]" + "[RUN:" + ft.format(dNow) + "]\n" + reset + "HOJVBOX " + version + " (defalut, Aug 19 2024, 20:14:00) \n[Java " + javaVersion + "] on " + osName + "\nType \"help\", \"copyright\", \"version\", \"feedback\" or \"license\" for more information");
		// Main
		while (true) {
			System.out.print(yellow + "(HOJVBOX) " + reset);
			command = scanner.nextLine().trim();
			if (command.equalsIgnoreCase("exit")) {
				break;
			} else if (command.equalsIgnoreCase("clear")) {
			    System.out.println("\033c");
			    system("clear");
			} else if (command.equalsIgnoreCase("help")) {
				printHelp();
			} else if (command.equalsIgnoreCase("time")) {
				System.out.println(java.time.LocalTime.now());
			} else if (command.equalsIgnoreCase("date")) {
				System.out.println(java.time.LocalDate.now());
			} else if (command.equalsIgnoreCase("worklist")) {
				java.io.File dir = new java.io.File(".");
				java.io.File[] filesList = dir.listFiles();
				if (filesList != null) {
					for (java.io.File file : filesList) {
						System.out.println(file.getName());
					}
				} else {
					System.out.println("Unable to list files.");
				}
			} else {
				System.out.println("Unknown command: " + command);
			}
		}
		scanner.close();
	}
	private static void printHelp() {
		System.out.println("Available commands:");
		System.out.println("  help     - Show this help message");
		System.out.println("  time     - Display the current time");
		System.out.println("  date     - Display the current date");
		System.out.println("  worklist - List files in the current directory");
		System.out.println("  clear    - Clear the console");
		System.out.println("  exit     - Exit the shell");
	}
	
	private static void system(String command) {
	    try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
