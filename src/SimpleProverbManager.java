import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class SimpleProverbManager {
    private List<Proverb> proverbList;
    private static Scanner scanner;

    public SimpleProverbManager() {
        proverbList = new ArrayList<>();
        scanner = new Scanner(System.in);
        this.readProverbsFromFile();
    }

    public void readProverbsFromFile() {
        try {
            File file = new File("proverbs.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] proverbData = line.split("-");

                if (proverbData.length == 3) {
                    String fullTxt = proverbData[0].trim();
                    String promptTxt = proverbData[1].trim();
                    String origin = proverbData[2].trim();

                    Proverb proverb = new Proverb(fullTxt, promptTxt, origin);
                    proverbList.add(proverb);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void addProverb() {

        System.out.print("Enter proverb: ");
        String proverb = scanner.nextLine();
        System.out.print("Enter promt: ");
        String prompt = scanner.nextLine();
        System.out.print("Enter origin: ");
        String origin = scanner.nextLine();

        if (!origin.equalsIgnoreCase("Turkish") && !origin.equalsIgnoreCase("Chinese")) {
            System.out.println("Invalid origin. Origin must be either Turkish or Chinese.");
            return;
        }

        Proverb newProverb = null;
        if (origin.equalsIgnoreCase("Turkish")) {
            newProverb = new TurkishProverb(proverb, prompt);
        } else if(origin.equalsIgnoreCase("Chinese")) {
            newProverb = new ChineseProverb(proverb, prompt);
        } else {
            System.out.println("Unknown origin..");
        }

        if (proverbList.contains(newProverb)) {
            System.out.println("Proverb already exists in the list.");
            return;
        }

        proverbList.add(newProverb);
        System.out.println("Proverb added..");
        saveProverbsToFile();
        System.out.println();
    }
    private void saveProverbsToFile() {
        try {
            FileWriter writer = new FileWriter("proverbs.txt", true);

            Proverb lastProverb = proverbList.get(proverbList.size() - 1);
            String proverbData = lastProverb.getFullText() + " - " + lastProverb.getPromptText() + " - " + lastProverb.getOrigin();
            writer.write(proverbData);
            writer.write(System.lineSeparator());

            writer.close();
        } catch (IOException e) {
            System.out.println("Error occurred while saving proverbs to file.");
            e.printStackTrace();
        }
    }

    public void shuffleList() {
        Collections.shuffle(proverbList);
    }

    public List<Proverb> getProverbList() {
        return proverbList;
    }
}