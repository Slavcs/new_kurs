package servercp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.NORM_PRIORITY;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCP extends Thread {

    private static ServerSocket serverSocket;
    private final Socket clientAccepted;
    public static ObjectInputStream sois;
    public static ObjectOutputStream soos;

    private static int numOfClients;

    public static void main(String[] arg) {
        sois = null;
        soos = null;
        serverSocket = null; 
        try {
            ServerWork.maxClients = 10;

            System.out.println("server starting....");
            serverSocket = new ServerSocket(4040);//создание сокета сервера
            System.out.println("server is started");

            for (int i = 0; i < arg.length; i++) {
                if (arg[i].equals("max")) {
                    ServerWork.maxClients = Integer.parseInt(arg[i + 1]);
                }

                ServerWork.logging = true;
                if (arg[i].equals("logging")) {
                    System.out.println("logging is on");
                    ServerWork.logging = true;
                }
            }

            System.out.println("maxClients: " + ServerWork.maxClients);

            while (true) {
                ServerCP serverCP = new ServerCP(serverSocket.accept());
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("init error: " + e);
        } // вывод исключений
        finally {
            try {
                serverSocket.close();//закрытие сокета сервера
            } catch (IOException e) {
                //вызывается метод исключения е               
            }
        }
    }

    public ServerCP(Socket s) {
        // копируем данные
        this.clientAccepted = s;

        numOfClients++;
        System.out.println("client '" + numOfClients + "' is joined");

        // и запускаем новый вычислительный поток (см. ф-ю run())
        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    @Override
    public void run() {
        try {
            // из сокета клиента берём поток входящих данных
            sois = new ObjectInputStream(clientAccepted.getInputStream());
            // и оттуда же - поток данных от сервера к клиенту
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());
            ServerWork serverWork = new ServerWork(sois, soos, numOfClients);
            serverWork.runServerWork();
            System.out.println("client '" + numOfClients + "' disconnected");
            numOfClients--;
        } catch (IOException e) {
            System.out.println("init error: " + e);
        } 
    }

}
