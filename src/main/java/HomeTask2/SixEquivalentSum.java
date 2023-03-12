package HomeTask2;

import java.util.Scanner;

public class SixEquivalentSum
{
    public static void main(String[] args) {
        int counter = 0;
        /*
        for(int i1 = 1; i1 <= 9; i1++) {
            for(int i2 = 0; i2 <= 9; i2++) {
                for(int i3 = 0; i3 <= 9; i3++) {
                    for(int i4 = 0; i4 <= 9; i4++) {
                        for(int i5 = 0; i5 <= 9; i5++) {
                            for(int i6 = 0; i6 <= 9; i6++) {
                                if(i1+i2+i3 == i4+i5+i6){
                                    counter++;
                                }
                            }
                        }
                    }
                }
            }
        }
        */

        for(int i = 100000; i <= 999999; i++){
            int N = i;
            int right = 0;
            int left = 0;
            for(int k = 0; k < 6; k++){
                if(k <= 2) {
                    left += N % 10;
                } else {
                    right += N % 10;
                }
                N = N / 10;
            }

            if( left == right ){
                counter++;
            }
        }



        System.out.println(counter);


        int c=0;
        for (int n=100000; n<=999999; n++){
            int sum1=0;
            int sum2=0;
            int N = n;
            for(int q=1; q<=3;q++){
                sum1=sum1 +(N%10);
                N=N/10;
            }

            for (int w=1; w<=3; w++){
                //n=n/1000;
                sum2=sum2 +(N%10);
                N=N/10;
            }
           // System.out.println(sum2);
            if (sum1==sum2){
                c++;
            }
        }
        System.out.println(c);

    }
}
