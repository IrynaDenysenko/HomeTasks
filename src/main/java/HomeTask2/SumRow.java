package HomeTask2;

import java.util.Arrays;

public class SumRow {
    public static void main(String[] args) {
        int n = 21;
        int k=1;
        int sum=0;
        int arr[]= new int[n];
        for (int i=0; i<n;i++)
        {
            if (i % 2==0 )
            {
                arr[i]=k;
                k++;
            }
            else{
                arr[i]=-k;
                k++;

            }

        }
        System.out.println(Arrays.toString(arr));
        for (int i=0; i<arr.length; i++) {
            sum = sum + arr[i];
        }
System.out.println(sum);
    }
}
