package HomeTask2;

public class Bubble2 {
    public static void main(String[] args) {
        int nums[] = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
        int size;
        size = nums.length; // 10
//отображение исходного массива
        System.out.println("Исходный массив:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();
//реализация алгоритма пузырьковой сортировки

        for (int a = 1; a < size; a++){
            for (int b = size - 1; b >= a; b--){
                if (nums[b-1] > nums[b]) {
                    int t = nums[b-1];
                    nums[b-1] = nums[b];
                    nums[b] = t;
                }
            }
        }
//отображение отсортированного массива
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();
    }
}
