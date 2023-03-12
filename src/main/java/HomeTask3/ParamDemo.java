package HomeTask3;

public class ParamDemo {
    public static void main(String[] args) {
        ChkNum chknum = new ChkNum();

        if(chknum.isEven(10)) System.out.println("10 -- четное число");
        if(chknum.isEven(9)) System.out.println("9 -- четное число");
        if(chknum.isEven(8)) System.out.println("8 -- четное число");
    }
}
