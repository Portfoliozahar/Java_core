import java.util.Scanner;

import convert. Decimal ;
import convert. Binary ;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите операцию:");
        System.out.println("1. Конвертация из двоичного в десятичное");
        System.out.println("2. Конвертация из десятичного в двоичное");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Введите двоичное число: ");
            String binary = scanner.next();

            Decimal converter = new Decimal();
            int decimal = converter.ToDecimal(binary);

            System.out.println("Десятичное число: " + decimal);
        } else if (choice == 2) {
            System.out.print("Введите десятичное число: ");
            int decimal = scanner.nextInt();

            Binary  converter = new Binary ();
            String binary = converter.ToBinary(decimal);

            System.out.println("Двоичное число: " + binary);
        } else {
            System.out.println("Ошибка.");
        }

        scanner.close();
    }
}