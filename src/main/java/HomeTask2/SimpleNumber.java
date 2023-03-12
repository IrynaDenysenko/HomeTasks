package HomeTask2;

import java.util.Arrays;

public class SimpleNumber {
    public static void main(String[] args) {
        int sim[] = new int[100];
        int currentIdx = 0;
        int N = -1;
        while(currentIdx < sim.length-1) {
            Boolean isPrime = true;
            if(currentIdx == 0) {
                N = 2;
            }
            else {
                for (int i = 0; i < currentIdx; i++) {
                    if (N % sim[i] == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime==true) {
                sim[currentIdx] = N;
                currentIdx++;
            }
            N++;
        }

        System.out.println(Arrays.toString(sim));
    }
}