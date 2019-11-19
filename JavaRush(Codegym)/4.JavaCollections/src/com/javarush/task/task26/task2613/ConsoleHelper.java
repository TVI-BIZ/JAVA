package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));;
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString()  {
        String newString="";
        try {
            newString = bis.readLine();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return newString;
    }

    public static String askCurrencyCode(){
        writeMessage("Enter Currency Code");
        String enteredCurrencyCode = "";
        while (true){
            enteredCurrencyCode = readString();
            if(enteredCurrencyCode.length()!=3){
                writeMessage("Not Correct Currency.");
            } else {
                break;
            }
        }
        return enteredCurrencyCode.toUpperCase();
    }
   public static String[] getValidTwoDigits(String currencyCode){
       writeMessage("Enter Two Positive numbers.Nominal bills_count");
       String[] resString = {};
       String enteredString = "";
       enteredString = readString();

       while(true){
           if ((enteredString != null)&&enteredString.matches("^[+]?[1-9]\\d*[ ][+]?[1-9]\\d*")){
               break;
           } else {
               writeMessage("Enter Two Positive numbers.Nominal bills_count");
               enteredString = readString();
           }
       }

       resString = enteredString.split(" ");

        return resString;
   }

    public static Operation askOperation(){
        writeMessage("Choose Operation.Enter Digit from 1 to 4");
        String enteredString = readString();
        while(true){
            if ((enteredString != null)
                    &&enteredString.matches("\\d+")
                    &&Integer.valueOf(enteredString)>0
                    &&Integer.valueOf(enteredString)<5) {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(enteredString));
            } else {
                writeMessage("Enter correct number!");
                enteredString = readString();
            }
        }

//        int operations = Integer.parseInt(readString());
//        if(operations==1){
//            return Operation.getAllowableOperationByOrdinal(1);
//        }else if(operations==2){
//            return Operation.getAllowableOperationByOrdinal(2);
//        }else if(operations==3){
//            return Operation.getAllowableOperationByOrdinal(3);
//        }else if(operations==4){
//            return Operation.getAllowableOperationByOrdinal(4);
//        } else {
            //throw new IllegalArgumentException();
        //}
    }
}
