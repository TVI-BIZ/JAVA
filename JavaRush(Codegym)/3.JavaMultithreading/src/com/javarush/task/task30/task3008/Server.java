package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    public static void main(String[] args) throws IOException {
       int port =  ConsoleHelper.readInt();
       ServerSocket serverSocket = null;
        ConsoleHelper.writeMessage("Server run");
        while (true){
            serverSocket = new ServerSocket(port);
            try{
                 new Handler(serverSocket.accept()).start();
            } catch  (Exception e){
                ConsoleHelper.writeMessage("Error!");
                serverSocket.close();
                return;
            }
        }
    }
    private static class Handler extends Thread {
        private Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message request = new Message(MessageType.NAME_REQUEST);
            Message response;
            String name;

            do {
                connection.send(request);
                response = connection.receive();
                name = response.getData();
            } while (response.getType() != MessageType.USER_NAME || name.isEmpty() || connectionMap.containsKey(name));

             connectionMap.put(name, connection);
             connection.send(new Message(MessageType.NAME_ACCEPTED));
            
            return name;

        }
        public void run(){
            ConsoleHelper.writeMessage("Connection established with server: "+socket.getRemoteSocketAddress());
            try {
                Connection connection = new Connection(socket);
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                notifyUsers(connection,userName);
                serverMainLoop(connection,userName);
                if(userName != null){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }



        private void notifyUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String,Connection> element: connectionMap.entrySet()){
                String name = element.getKey();
                if(!name.equals(userName)){
                    Message newmessage = new Message(MessageType.USER_ADDED,name);
                    connection.send(newmessage);
                }
            }

        }


        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message reply = connection.receive();
                String newmessage;
                if (reply.getType()==MessageType.TEXT){
                    newmessage = userName + ":" + " " + reply.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT,newmessage));
                } else {
                    ConsoleHelper.writeMessage("Error!");
                }
            }
        }

    }


    public static void sendBroadcastMessage(Message message) throws IOException {
        for(Map.Entry<String,Connection> elem: connectionMap.entrySet()){
            try{
                elem.getValue().send(message);
            } catch (Exception e){
                ConsoleHelper.writeMessage("Unable to send message!");
            }
        }
    }


}
