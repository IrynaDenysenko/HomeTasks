package HomeTask2;

public class Pascal {
    public static void main(String[] args) {
        int arr [][]= new int[10][];
        arr[0] = new int[1];
        arr[0][0]=1;
        arr[1] = new int[2];
        arr[1][0]=1;
        arr[1][1]=1;
        arr[2] = new int[3];
        arr[3] = new int[4];
        arr[4] = new int[5];
        arr[5] = new int[6];
        arr[6] = new int[7];
        arr[7] = new int[8];
        arr[8] = new int[9];
        arr[9] = new int[10];

        for (int i=2; i < 10 ; i++){
            arr[i][0]=1;
            for (int j=1; j<i; j++){
                arr [i][j+1]=1;
                arr[i][j]=arr[i-1][j-1]+arr[i-1][j];

            }

        }
       for (int i=0; i<10; i++) {
            for (int j = 0; j <=i; j++)
                System.out.print(arr[i][j] + " ");
           System.out.println();
       }
    }
}

