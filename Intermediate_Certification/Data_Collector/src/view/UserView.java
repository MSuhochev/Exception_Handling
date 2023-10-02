package view;

import java.awt.BorderLayout;
import java.text.ParseException;

import javax.swing.*;

import controller.Controller;

public class UserView extends JFrame {
    private JTextArea text;
    private JButton sendButton;
    private JLabel info;
    private Controller controller;

    public UserView(Controller controller) {
        this.controller = controller;
    }

    public void Init() {
        setSize(400, 300);
        text = new JTextArea();
        sendButton = new JButton("Send");
        info = new JLabel("<html> Добрый день, в поле ниже введите Ваши данные в одну строку:" +
                "<br> Фамилия Имя Отчество" +
                "<br> Датарождения - строка формата dd.mm.yyyy" +
                "<br> Номертелефона - целое беззнаковое число без форматирования" +
                "<br> Пол - символ латиницей f или m. </html>");
                
        // Добавляем поле ввода для текста
        add(text, BorderLayout.CENTER);

        // Добавляем кнопку отправить
        add(sendButton, BorderLayout.SOUTH);

        // Добавляем приветственный текст
        add(info, BorderLayout.NORTH);

        // Добавляем поведение кнопки отправить
        sendButton.addActionListener(e -> {
            String data = this.text.getText();
            info.setText("Вы ввели: " + data);
            //добавляем новый поток для параллельного выполнения
            Thread thread = new Thread(() -> {
                //делаем неактивной кнопку send на время выполнения потока
                sendButton.setEnabled(false);
                try {
                    //блок сообщений пользователю о корректности количества введённых данных
                    boolean dataCheck = controller.checkData(data);
                    String dataCheckMessage;
                    if (dataCheck == true) {
                        dataCheckMessage = "Данные приняты на проверку...";
                    } 
                    else {
                        dataCheckMessage = "Данные введены некорректно - пожалуйста повторите ввод.";
                    }
                    info.setText(dataCheckMessage);

                    //блок сообщений пользователю о корректности введённой даты
                    boolean dateCheck = controller.checkDate(data);
                    String dateCheckMessage;
                    if (dateCheck == true) {
                        dateCheckMessage = "Проверка данных...";
                    } 
                    else {
                        dateCheckMessage = "Дата введена некорректно - пожалуйста повторите ввод.";
                    }
                    info.setText(dateCheckMessage);

                    //блок сообщений пользователю о корректности введённого номера телефона
                    boolean phoneCheck = controller.checkPhone(data);
                    String phoneCheckMessage;
                    if (phoneCheck == true) {
                        phoneCheckMessage = "Данные приняты...";
                    } 
                    else {
                        phoneCheckMessage = "Телефон введён некорректно - пожалуйста повторите ввод.";
                    }
                    info.setText(phoneCheckMessage);

                    //блок сообщений пользователю о корректности введённого пола
                    boolean sexCheck = controller.checkSex(data);
                    String sexCheckMessage;
                    if (sexCheck == true) {
                        sexCheckMessage = "Данные приняты...";
                    } 
                    else {
                        sexCheckMessage = "Пол введён некорректно - пожалуйста повторите ввод.";
                    }
                    info.setText(sexCheckMessage);

                    //записываем в файл
                    boolean resultWrite = controller.writeFile(data);
                    String writeFileMessage;
                    if (resultWrite == true) {
                        writeFileMessage = "Данные записаны успешно...";
                    } 
                    else {
                        writeFileMessage = "Запись данных отклонена...";
                    }
                    info.setText(writeFileMessage);
                    
                    // делаем кнопку send снова активной 
                    sendButton.setEnabled(true);
                } catch (ParseException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            });
            thread.start();

        });

        setVisible(true);
    }
}
