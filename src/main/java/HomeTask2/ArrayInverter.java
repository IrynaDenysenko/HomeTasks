package HomeTask2;

import java.util.Arrays;

public class ArrayInverter {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,};
        for (int k = 0; k < arr.length / 2; k++) {
            int tmp = arr[k];
            arr[k] = arr[arr.length - k - 1];
            arr[arr.length - k - 1] = tmp;
            System.out.println(Arrays.toString(arr));
        }
    }
}
