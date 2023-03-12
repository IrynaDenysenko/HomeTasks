package HomeTask2;

public class ScopeDemo {
    public static void main(String[] args) {
        int x; //Эта переменная доступна для всего кода в методе main
        x = 10;
        if (x == 10){ // Начало новой области действия
            int y = 20; // Эта переменная доступна только в данном блоке
            // Обе переменные, "x" и "y", доступны в данном блоке кода
            System.out.println("x и y:" +x+y); x = y * 2;
        }
// y = 100; // Ошибка! В этом месте переменная y недоступна
// А переменная х по-прежнему доступна
        System.out.println("x - это " + x); }
}
