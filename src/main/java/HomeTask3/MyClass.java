package HomeTask3;

public class MyClass {
    private int alpha; // access only in this class
    public int beta;

    int gamma;//default access only in this package

    public void setAlpha(int a) {
        alpha = a;
    }

    public int getAlpha() {
        return alpha;
    }
}
