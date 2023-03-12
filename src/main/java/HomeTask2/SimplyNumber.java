package HomeTask2;

public class SimplyNumber {
    public static void main(String[] args) {
        int x = 121;
        int t = 0;
        for (int i = 1; i < x; i++) {
            if ((x % i) == 0) {
                t = i;
            }
        }
        if ((t == x | t == 1) & x== 2) {
            System.out.println(x + " is a simply number");
        } else {
            System.out.println(x + " is not a simply number because of dividing " +t );
        }
    }
}
