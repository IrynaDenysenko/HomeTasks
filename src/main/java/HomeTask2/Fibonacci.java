package HomeTask2;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
     int ser[] = new int[20];
     for (int s = 0; s < ser.length; s++){
         ser[s] = s <= 1
             ? 1
             : ser[s-2] + ser[s-1];

     }
        System.out.println(Arrays.toString(ser));

    }
}
