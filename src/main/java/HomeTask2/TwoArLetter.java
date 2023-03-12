package HomeTask2;

public class TwoArLetter {
    public static void main(String[] args) {
        char twoD[][]= new char [2][8];

        int i, j;

        for (i=0;i<2; i++){
            for(j=0; j<8 ; j++){
                if ( (i==0)| (i%2==0)){
                    if ((i==j)| (j%2==0)){
                        twoD[i][j]='A';
                    }
                    else{
                        twoD[i][j]='B';
                    }
                }
                else {
                    if ((j == 0) | (j % 2 == 0)) {
                        twoD[i][j] = 'B';
                    } else {
                        twoD[i][j] = 'A';
                    }
                }

            }
        }
        for (i=0; i<2; i++){
            for(j=0; j<8 ; j++)
                System.out.print(twoD[i][j]+ " ");
            System.out.println();
        }

    }
}
