package HomeTask2;

public class ConsoleDemo {
    public static void main(String[] args) {
        System.out.println("Программе передано " + args.length + " аргумента командной строки.");
        System.out.println("Список агрументов: ");
        for (int v = 0; v < args.length; v++){
            System.out.println("arg[" + v + "]: " + args[v]);
        }
    }
}
