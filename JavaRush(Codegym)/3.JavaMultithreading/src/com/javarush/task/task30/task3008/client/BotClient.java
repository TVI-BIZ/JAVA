package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() throws IOException {
        int Xval = (int)(Math.random()*100);
        return "date_bot_"+Xval;
    }

    public static void main(String[] args) throws InterruptedException {
        BotClient botClient = new BotClient();
        botClient.run();
    }


    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            BotClient.this.sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) throws IOException {
            ConsoleHelper.writeMessage(message);
            String name= "";
            String messageText = "";

            if(message.contains(":")){
                String[] messages = message.split(": ");
                name = messages[0];
                messageText = messages[1];
            }


            String dat1 = "d.MM.YYYY";
            String dat2 = "d";
            String dat3 = "MMMM";
            String dat4 = "YYYY";
            String dat5 = "H:mm:ss";
            String dat6 = "H";
            String dat7 = "m";
            String dat8 = "s";

            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(dat1);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(dat2);
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(dat3);
            SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat(dat4);
            SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat(dat5);
            SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat(dat6);
            SimpleDateFormat simpleDateFormat7 = new SimpleDateFormat(dat7);
            SimpleDateFormat simpleDateFormat8 = new SimpleDateFormat(dat8);

            Calendar calendar = Calendar.getInstance();


            if(messageText.equals("дата")){
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat1.format(calendar.getTime())));
            } else if(messageText.equals("день")){
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat2.format(calendar.getTime())));
            }else if(messageText.equals("месяц")){
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat3.format(calendar.getTime())));
            }else if(messageText.equals("год")){
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat4.format(calendar.getTime())));
            }else if(messageText.equals("время")){
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat5.format(calendar.getTime())));
            }else if(messageText.equals("час")){
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat6.format(calendar.getTime())));
            }else if(messageText.equals("минуты")){
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat7.format(calendar.getTime())));
            }else if(messageText.equals("секунды")){
                sendTextMessage(String.format("Информация для %s: %s",name,simpleDateFormat8.format(calendar.getTime())));
            }

        }
    }

}
