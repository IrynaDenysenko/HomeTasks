package HomeTask2;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] arr = new int []{ 2,-10,-3,-10,6};

        System.out.println(Arrays.toString(arr));

        for (int a = 0; a < arr.length; a++ ) {
            for (int b = a + 1; b < arr.length; b++)
                if (arr[a] > arr[b]) {
                    int t = arr[a];
                    arr[a] = arr[b];
                    arr[b] = t;

                }
        }
        System.out.println(Arrays.toString(arr));
        }

    }

