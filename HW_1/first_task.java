package Home_Works.HW_1;

import java.util.Scanner;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

public class first_task {
    public static void main(String[] args) {
        returnFloat();
    }

    public static void returnFloat() {
        try (Scanner scan = new Scanner(System.in)) {

            System.out.print("Введите число типа Float: ");
            if (!scan.hasNextFloat()) {
                System.out.println("Вы ввели не число!");
                System.out.println("Разеление дробной части осуществляется при помощи запятой, пример - 23,123");
                System.out.println("Повторите ввод: ");
                returnFloat();
            } else if (scan.hasNextInt()) {
                System.out.println("Вы ввели не дробное число!");
                System.out.println("Разеление дробной части осуществляется при помощи запятой, пример - 23,123");
                System.out.println("Повторите ввод: ");
                returnFloat();
            } else {
                float value = scan.nextFloat();
                System.out.println(value);
            }
        } catch (NumberFormatException e) {
        }
    }
}
