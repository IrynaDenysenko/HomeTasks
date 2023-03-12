package HomeTask2;

public class BiggestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{3,345,-1,-345, 979, 999};
        int a, b;
        int t=arr[0];

        for (a = 0; a < arr.length; a++){
                if (t < arr[a]) {
                    t = arr[a];
                }
            }
        System.out.println(t);

        }

    }



