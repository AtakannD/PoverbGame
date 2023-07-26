import java.util.Scanner;

public class ProverbArrayListClient {

    private static Scanner scanner;
    private static final SimpleProverbManager proverbManager = new SimpleProverbManager();
    private static final ProverbClient proverbClient = new ProverbClient(proverbManager);

    public ProverbArrayListClient() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ProverbArrayListClient system = new ProverbArrayListClient();
        system.run();
    }

    private void run() {
        System.out.println("Welcome to the Proverb Game!");

        while (true) {
            displayMenu();
            String choiceStr = scanner.nextLine();

            if (!choiceStr.matches("[0-3]")) {
                System.out.println("Please enter a valid choice.");
                continue;
            }

            int choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1:
                    addProverb();
                    break;
                case 2:
                    shuffleList();
                    break;
                case 3:
                    playGame();
                    break;
                case 0:
                    exitGame();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add a new proverb.");
        System.out.println("2. Shuffle proverb list.");
        System.out.println("3. Guess proverb.");
        System.out.println("0. Quit");
        System.out.print("Enter your choice: ");
    }

    private static void addProverb() {
        System.out.println("Adding a new proverb:");
        proverbManager.addProverb();
    }

    private static void shuffleList() {
        System.out.println("Shuffling proverb list..");
        proverbManager.shuffleList();
    }

    private static void playGame() {
        System.out.println("Game is starting");
        proverbClient.playGame();
    }

    private static void exitGame() {
        System.out.println("Exiting game... We hope you have fun!");
        scanner.close();
        System.exit(0);
    }
}