package Home_Works.HW_1;
// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class fourth_task {
    public static void main(String[] args) {
        String userStr = getStr();
        System.out.println();
        System.out.println("Вы ввели: ");
        System.out.println(userStr);
    }

    static String getStr() {
        String str = "";
        System.out.println("Введите строку: ");
        InputStream UserInput = System.in;
        Reader inputReader = new InputStreamReader(UserInput);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        try {
            str = bufferedReader.readLine();
            if (str.isEmpty()) {
                System.out.println("Пустую строку вводить нельзя!");
                return getStr();
            }
        } catch (IOException e) {
            System.out.println("Что-то пошло не так...");
        }
        return str;
    }
}
