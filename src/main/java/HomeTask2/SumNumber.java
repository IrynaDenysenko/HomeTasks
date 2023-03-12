package HomeTask2;
import java.util.Scanner;

public class SumNumber {
    public static void main(String[] args) {
        System.out.println("Insert number");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum=0;
        while(n != 0){
            //Суммирование цифр числа
            sum += (n % 10);
            n/=10;
        }
        System.out.println(sum + " ");
    }
}
