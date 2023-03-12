package HomeTask2;
import java.util.Arrays;
public class Average {
    public static void main(String args[]) {
        double[] numb = new double[] {1.1, 1.2, 12.3, 13.4, 14.5};
        double result = 0;
        int a = 0;
        int i;
        for(i = 0, a=0; i < 5; i++, a++)
            result = result + numb[a];
        System.out.println("Average is " + result / 5);
    }
}
