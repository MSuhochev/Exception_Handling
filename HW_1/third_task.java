// Дан следующий код, исправьте его там, где требуется 
// (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

package Home_Works.HW_1;

import java.io.IOException;

public class third_task {
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (ArithmeticException ex) { // Меняем (Throwable ex) на (ArithmeticExeption)
            System.out.println("Что-то пошло не так...");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }

    // Вместо `FileNotFoundException` используем `IOException`.
    public static void printSum(Integer a, Integer b) throws IOException {
        System.out.println(a + b);
    }

}
