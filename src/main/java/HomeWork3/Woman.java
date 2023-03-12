package HomeWork3;
import java.util.Scanner;

public class Woman extends Human{
    Woman() {
        this.setSex(false);
    }

    Woman (
        String firstname,
        String lastname,
        float height,
        float weight)

    {
        super(
            false,
            firstname,
            lastname,
            height,
            weight
        );
    }
    public Human givebirth(Man man, Scanner scanner) {
        boolean isBoy = Math.random() < 0.5;

        System.out.println("Enter name for a " + (isBoy ? "boy" : "girl") + ":");
        String firstname = scanner.nextLine();
        System.out.println("You entered: " + firstname);

        String lastname = man.getLastname();

        if (isBoy){
            float height = man.getHeight() + (float)(0.1 * (this.getHeight() - man.getHeight()));
            float weight = man.getWeight() + (float)(0.1 * (this.getWeight() - man.getWeight()));
            return new Man(firstname, lastname, height, weight);
        }
        else{
            float height = this.getHeight() + (float)(0.1 * (man.getHeight() - this.getHeight()));
            float weight = this.getWeight() + (float)(0.1 * (man.getWeight() - this.getWeight()));
            return new Woman(firstname, lastname, height, weight);
        }

    }
}
