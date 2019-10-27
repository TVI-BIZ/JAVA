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
       private String serverHandshake(Connection connection) throws IOException,ClassNotFoundException {
            Message reply=null;
           Message reqMessage = new Message(MessageType.NAME_REQUEST);
           Message acceptMessage = new Message(MessageType.NAME_ACCEPTED);

//           while (true){
//
//
//           }

           connection.send(reqMessage);
           while ((reply=connection.receive()).getType() != MessageType.USER_NAME ){
               connection.send(new Message(MessageType.NAME_REQUEST));
           }

//           if(reply.getData().isEmpty()){
//               connection.send(new Message(MessageType.NAME_REQUEST));
//           }



           if (reply.getType() == MessageType.USER_NAME &&
                   !reply.getData().isEmpty() &&
                   !connectionMap.containsKey(reply.getData())){
               connectionMap.put(reply.getData(),connection);
               connection.send(acceptMessage);
           } else {
               connection.send(reqMessage);
           }



//                reply = connection.receive();
//                while (connection.receive().getType() != MessageType.USER_NAME){
//                    connection.send(reqMessage);
//                }

//                    if(!reply.getData().isEmpty() && !connectionMap.containsKey(reply.getData())){
//                        connectionMap.put(reply.getData(),connection);
//                        } else {
//                            connection.send(reqMessage);
//                    }

                //connection.send(acceptMessage);

            return reply.getData();





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
