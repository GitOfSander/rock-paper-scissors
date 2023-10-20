import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        RockPaperScissors rockPaperScissors = new RockPaperScissors(scanner.nextLine(), name);
        while (rockPaperScissors.isWorking()) {
            rockPaperScissors.play(scanner.nextLine());
        }
        rockPaperScissors.save();

        scanner.close();
    }
}


