package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data {
    // метод проверки на количество введённых параметров(данных)
    public String[] getDataString(String data) throws ParseException {

        try {
            TimeUnit.SECONDS.sleep(1); // засыпаем на 2 секунды для выполнения кода
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String[] subStr;
        String delimeter = " "; // Разделитель
        subStr = data.split(delimeter); // Разделения строки str с помощью метода split()

        return subStr;

    }

    // метод проверки на корректность даты
    public boolean dateExeption(String[] subStr) throws ParseException {
        try {
            String birthday = subStr[3];
            LocalDate.parse(birthday,
                    DateTimeFormatter
                            .ofPattern("dd.MM.uuuu")
                            .withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // метод проверки на корректность вводимого номера телефона
    public boolean phoneExeption(String[] subStr) throws NumberFormatException {

        try {
            String phoneNumber = subStr[4];
            Pattern pattern = Pattern.compile("^(\\d{10})$");
            Matcher matcher = pattern.matcher(phoneNumber);
            if (!matcher.matches()) {
                return false;
            } else
                return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return true;

    }

    // метод проверки на корректность вводимого пола
    public boolean sexExeption(String[] subStr) {

        try {
            String sexChar = subStr[5];
            if (!sexChar.toLowerCase().equals("m") && !sexChar.toLowerCase().equals("f")) {
                return false;
            } else
                return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return true;

    }

    public void toFileWrite(String[] subStr) throws FileSystemException {
        String fileName = /* "files\\" + */subStr[0].toLowerCase() + ".txt";
        File file = new File(fileName);
        try(FileWriter fileWriter = new FileWriter(file, true)) {
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", subStr[0], subStr[1], subStr[2], subStr[3], subStr[4], subStr[5]));
        }catch (IOException e){
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }
    }

}
