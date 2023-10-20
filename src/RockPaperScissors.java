import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissors {
    private Scores scores = new Scores();

    private final Random RANDOM = new Random();

    private String playerName = "";
    private Boolean working = true;
    private String[] options = {"rock", "paper", "scissors"};
    private ArrayList<String> losingGames = new ArrayList<>();

    RockPaperScissors(String options, String playerName) {
        setOptions(options);
        this.playerName = playerName;

        System.out.println("Okay, let's start");

        scores.getScores().putIfAbsent(playerName, 0);
    }

    public Boolean isWorking() {
        return working;
    }

    private void setOptions(String newOptions) {
        if (!newOptions.trim().isBlank()) options = newOptions.trim().split(",");
    }

    public void setLosingGames(String userChoice) {
        losingGames.removeAll(losingGames);

        int targetIndex = -1;
        int optLength = options.length;

        for (int i = 0; i < optLength; i++) {
            if (options[i].equals(userChoice)) {
                targetIndex = i;
                break;
            }
        }

        int halfOfCompetingOptions = (optLength - 1) / 2;

        for (int i = 0; i < halfOfCompetingOptions; i++) {
            losingGames.add(options[(targetIndex + 1 + i) % optLength]);
        }
    }

    public void save() {
        scores.updateFile();
    }

    public void play(String input) {
        switch (input) {
            case "!exit":
                System.out.println("Bye!");
                working = false;
                return;
            case "!rating":
                System.out.println("Your rating: " + scores.getScores().get(playerName));
                return;
            default:
                if (input.matches(String.join("|", options))) {
                    round(playerName, input);
                } else {
                    System.out.println("Invalid input");
                }
        }
    }

    private void round(String name, String playerChoice) {
        String computerChoice = options[RANDOM.nextInt(options.length)];
        int result = battle(playerChoice, computerChoice);

        switch (result) {
            case 0:
                System.out.println("There is a draw (" + computerChoice + ")");
                scores.getScores().put(name, scores.getScores().get(name) + 50);
                break;
            case 1:
                System.out.println("Well done. The computer chose " + computerChoice + " and failed");
                scores.getScores().put(name, scores.getScores().get(name) + 100);
                break;
            default:
                System.out.println("Sorry, but the computer chose " + computerChoice);
        }
    }

    public int battle(String playerChoice, String computerChoice) {
        setLosingGames(playerChoice);
        if (playerChoice.equals(computerChoice)) {
            return 0;
        } else if (losingGames.contains(computerChoice)) {
            return -1;
        }
        return 1;
    }
}
