package controller;

import java.nio.file.FileSystemException;
import java.text.ParseException;

import data.Data;

public class Controller {
    private Data data;

    public Controller(Data data){
            this.data = data;
        }

    // метод проверки на количество введённых параметров(данных)
    public boolean checkData(String datas) throws ParseException {
        if(data.getDataString(datas).length != 6){
            return false;
        }
        return true;

    }

    // метод проверки на корректность даты
    public boolean checkDate(String datas) throws ParseException{
        
        if(data.dateExeption(data.getDataString(datas)) == false){
            return false;
        }
        return true;
    }

    // метод проверки на корректность вводимого номера телефона
    public boolean checkPhone(String datas) throws ParseException{
        
        if(data.phoneExeption(data.getDataString(datas)) == false){
            return false;
        }
        return true;
    }

    // метод проверки на корректность вводимого пола
    public boolean checkSex(String datas) throws ParseException{
        
        if(data.sexExeption(data.getDataString(datas)) == false){
            return false;
        }
        return true;
    }

    //Запись в файл
    public boolean writeFile(String datas){
        boolean result = false;
        try {
            if (checkData(datas) && checkDate(datas) && checkPhone(datas) && checkSex(datas) == true){
                data.toFileWrite(data.getDataString(datas));
                result = true; 
            } else {
                return result;
            }
            
        } catch (ParseException | FileSystemException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
        
    }


    
}
