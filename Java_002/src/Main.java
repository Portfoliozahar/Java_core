import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Выберите задачу:");
            System.out.println("1. Метод, возвращающий количество чётных элементов массива.");
            System.out.println("2. Функция, возвращающую разницу между самым большим и самым ма- леньким элементами переданного не пустого массива.");
            System.out.println("3. Функция, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.");

            choice = scanner.nextInt();

        } while (choice < 1 || choice > 3);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
//
//        если мы введём элементов больше чем длинна массива то последние элементы будут не засчитанны
//                например
//        Выберите задачу:
//        1. Метод, возвращающий количество чётных элементов массива.
//        2. Функция, возвращающую разницу между самым большим и самым ма- леньким элементами переданного не пустого массива.
//        3. Функция, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
//        3
//        Введите размер массива: 4
//        Введите элементы массива:
//        2 3 2 3 0 0
//        Наличие двух соседних элементов со значением 0: false

//        ответ false так как два 0 не входят в масссив из 4 элементов


        switch (choice) {
            case 1:
                int evenCount = Even(array);
                System.out.println("Количество четных элементов: " + evenCount);
                break;
            case 2:
                int difference = MaxMin(array);
                System.out.println("Разница между максимальным и минимальным элементами: " + difference);
                break;
            case 3:
                boolean hasZeroNeighbours = ZeroTogether(array);
                System.out.println("Наличие двух соседних элементов со значением 0: " + hasZeroNeighbours);
                break;
            default:
                System.out.println("Ошибка.");
                break;
        }
    }

    public static int Even(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int MaxMin(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max - min;
    }

    public static boolean ZeroTogether(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }
}
