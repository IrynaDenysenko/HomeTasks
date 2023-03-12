package HomeWork3;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Human h1,h2;
        System.out.println("Please choose sex of first human");
        System.out.println("W - woman");
        System.out.println("M - man");
        String sex = scanner.nextLine();

        System.out.println("First name:");
        String firstname = scanner.nextLine();

        System.out.println("Last name:");
        String lastname = scanner.nextLine();

        System.out.println("Height:");
        float height = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Weight:");
        float weight = scanner.nextFloat();
        scanner.nextLine();

        if (sex.equals("W")){
            h1 = new Woman(firstname, lastname, height, weight);
        }
        else if(sex.equals("M")){
            h1 = new Man(firstname, lastname, height, weight);
        }
        else {
            System.out.println("Unknown sex");
            return;
        }

        System.out.println("Please choose sex of second human");
        System.out.println("W - woman");
        System.out.println("M - man");
        System.out.println("Sex2:");
        sex = scanner.nextLine();

        System.out.println("First name:");
        firstname = scanner.nextLine();

        System.out.println("Last name:");
        lastname = scanner.nextLine();

        System.out.println("Height:");
        height = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Weight:");
        weight = scanner.nextFloat();
        scanner.nextLine();

        if (sex.equals("W")){
            h2 = new Woman(firstname, lastname, height, weight);
        }
        else if(sex.equals("M")){
            h2 = new Man(firstname, lastname, height, weight);
        }
        else {
            System.out.println("Unknown sex");
            return;
        }


        Human child = h1.relationships(h2, scanner);
        if (child != null){
            System.out.println(child);
        }
        else{
            System.out.println("ничего не вышло и они разошлись");
        }

        scanner.close();
    }
}
