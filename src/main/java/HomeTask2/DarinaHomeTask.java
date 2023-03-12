package HomeTask2;

import java.util.Scanner;

public class DarinaHomeTask {

    public static void main(String[] args) {

        System.out.println("Insert number");
        Scanner scanner = new Scanner(System.in);
        int ticket = scanner.nextInt();

        int r = 0;
        int l = 0;
        int N = ticket;


        for (int k = 0; k < 6; k++) {

            if (k <= 2) {
                l += N % 10;
            } else {
                r += N % 10;
            }
            N = N / 10;
        }
        System.out.println("Left part is equal to " +l);
        System.out.println("Right part is equal to " +r);
        if (l == r) {
            System.out.println("It is your lucky " +ticket);
        }
        else {
            System.out.println(ticket+ " is not lucky ticket");

        }
    }
}
