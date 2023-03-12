package HomeTask2;

public class SixArray {
    public static void main(String[] args) {
        int arr[][]= new int[6][6];

        int i, j, e=0, t;
        for (i=0;i< arr.length; i++){
            e++;
            for(j=0; j<arr.length ; j++){
                t=e;
                if (j==0 | (j%2==0)){
                    arr[i][j] = t;
                }
                else {
                    arr[i][j] = ++t;
                }


            }
            e++;
        }
        for (i=0; i<arr.length; i++){
            for(j=0; j<arr.length; j++)
                System.out.print(arr[i][j]+ " ");
            System.out.println();
        }
    }
}
