import java.util.Scanner;

public class JavaShell {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("WELCOME TO HOJVBOX\nType 'help' for a list of commands");
        while (true) {
            System.out.print("(HOJVBOX) ");
            command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting JavaShell...");
                break;
            }
            else if (command.equalsIgnoreCase("help")) {
                printHelp();
            }
            else if (command.equalsIgnoreCase("time")) {
                System.out.println("Current time: " + java.time.LocalTime.now());
            }
            else if (command.equalsIgnoreCase("date")) {
                System.out.println("Current date: " + java.time.LocalDate.now());
            }
            else if (command.equalsIgnoreCase("ls")) {
                java.io.File dir = new java.io.File(".");
                java.io.File[] filesList = dir.listFiles();
                if (filesList != null) {
                    for (java.io.File file : filesList) {
                        System.out.println(file.getName());
                    }
                } else {
                    System.out.println("Unable to list files.");
                }
            }
            else if (command.startsWith("exec ")) {
                String sysCommand = command.substring(5);
                try {
                    Process process = Runtime.getRuntime().exec(sysCommand);
                    process.waitFor();
                    System.out.println("Command executed: " + sysCommand);
                } catch (Exception e) {
                    System.out.println("Error executing command: " + e.getMessage());
                }
            }
            else {
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
        System.out.println("  ls       - List files in the current directory");
        System.out.println("  exec CMD - Execute a system command CMD");
        System.out.println("  exit     - Exit the shell");
    }
}
