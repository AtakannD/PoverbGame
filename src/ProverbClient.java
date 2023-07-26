import java.util.List;
import java.util.Scanner;

public class ProverbClient {
    private SimpleProverbManager proverbManager;
    private static Scanner scanner;
    private static int count;

    public ProverbClient(SimpleProverbManager proverbManager) {
        this.proverbManager = proverbManager;
        scanner = new Scanner(System.in);
    }

    public void playGame() {
        List<Proverb> proverbs = proverbManager.getProverbList();

        count = 0;

        if (proverbs.isEmpty()) {
            System.out.println("There are no proverbs available. Please add proverbs first.");
            return;
        }

        for (Proverb proverb : proverbs) {
            String prompt = proverb.getPromptText();
            String fullText = proverb.getFullText();
            String origin = proverb.getOrigin();

            System.out.println("There is an old " + origin + " proverb: " + prompt);
            System.out.println("Guess?: ");
            String guess = scanner.nextLine();
            if (guess.equalsIgnoreCase(fullText)) {
                System.out.println("Correct.. +1 point");
                count ++;
            } else {
                System.out.println("Incorrect.. Next question.");
            }
        }
        System.out.println("Game is over.. Your score is: " + count);
    }
}
