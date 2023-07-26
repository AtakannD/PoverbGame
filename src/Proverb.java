public class Proverb {
    private String fullTxt;
    private String promptTxt;
    private String origin;

    public Proverb(String fullTxt, String promptTxt, String origin) {
        this.fullTxt = fullTxt;
        this.promptTxt = promptTxt;
        this.origin = origin;
    }

    public String getFullText() {
        return fullTxt;
    }

    public String getPromptText() {
        return promptTxt;
    }

    public String getOrigin() {
        return origin;
    }
}