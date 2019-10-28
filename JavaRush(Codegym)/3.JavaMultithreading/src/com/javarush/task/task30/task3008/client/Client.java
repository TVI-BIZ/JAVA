package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread{
        protected  void processIncomingMessage(String message) throws IOException {
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " Connected to chat room.");
        }
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " Leave chat room.");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected){
                Client.this.clientConnected = clientConnected;
                synchronized (Client.this){
                    Client.this.notify();
                }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true){
                Message reply = connection.receive();
                if(reply.getType() == MessageType.NAME_REQUEST){
                    Message request_name = new Message(MessageType.USER_NAME,getUserName());
                    connection.send(request_name);
                } else if(reply.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
           while (true){
               Message newReply = connection.receive();
               if(newReply.getType() == MessageType.TEXT){
                   processIncomingMessage(newReply.getData());
               } else if(newReply.getType() == MessageType.USER_ADDED){
                   informAboutAddingNewUser(newReply.getData());
               } else if(newReply.getType() == MessageType.USER_REMOVED){
                   informAboutDeletingNewUser(newReply.getData());
               } else {
                   throw new IOException("Unexpected MessageType");
               }
           }
        }
        public void run(){
            try {
                Socket socket = new Socket(getServerAddress(),getServerPort());
                Connection connection = new Connection(socket);
                Client.this.connection = connection;
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                notifyConnectionStatusChanged(false);
            }


        }



    }
    protected String getServerAddress() throws IOException {
        return ConsoleHelper.readString();

    }
    protected int getServerPort() throws IOException {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException {
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text) throws IOException {

        try{
            Message newMessage = new Message(MessageType.TEXT,text);
            connection.send(newMessage);
        }catch (IOException io){
            clientConnected = false;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.run();
    }


    public void run() throws InterruptedException {

        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this){
            try{
                wait();
                if(clientConnected == true){
                    System.out.println("Соединение установлено. Для выхода наберите команду 'exit'.");
                    while (true){
                        String consoleMess = ConsoleHelper.readString();
                        if(consoleMess.equals("exit")||!clientConnected){
                            break;
                        } else {
                            if(shouldSendTextFromConsole() == true) {
                                sendTextMessage(consoleMess);
                            }
                        }
                    }
                } else {
                    System.out.println("Произошла ошибка во время работы клиента.");
                }

            } catch (Exception e){
                System.out.println("Error!");
                return;
            }


        }


        }


}
