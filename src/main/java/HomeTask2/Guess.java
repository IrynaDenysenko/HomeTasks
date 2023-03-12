package HomeTask2;
import java.io.IOException;
public class Guess {
    public static void main(String[] args) throws IOException {
        char ch, answer='K';
        System.out.println("It was conceived letter from range A-Z.");
        System.out.println("Try to guess.");

        ch= (char) System.in.read();

        if (ch==answer) System.out.println("You win");
        else System.out.println("Try one more time");





    }
}
