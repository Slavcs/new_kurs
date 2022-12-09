package clientcp;

import view.AdminMenu;
import view.Authorization;
import view.ErrowWND;
import view.RegUser;
import view.SalonReg;
import view.UserMenu;
import view.record.InsertRecordTable;
import view.salon.InsertSalonTable;
import view.service.InsertServiceTable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.System.exit;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JFrame;
import view.user.InsertUserTable;

public class ClientCP implements Serializable {
public static boolean logging;

    public static Socket clientSocket;
    public static ObjectOutputStream coos;
    public static ObjectInputStream cois;
    public static JFrame jf;
    public static JFrame errorframe;

    private static String serverMessage;
    public static Map<String, String> stringmap;
    
    public static void main(String[] args) {
        
        try {

            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("logging")) {
                    System.out.println("logging is on");
                    logging = true;
                }
            }

            System.out.println("Соединение с сервером....");
            clientSocket = new Socket("127.0.0.1", 4040);//установление
//соединения между локальной машиной и указанным портом узла
            System.out.println("Соединение установлено....");

            coos = new ObjectOutputStream(clientSocket.getOutputStream());//поток вывода
            cois = new ObjectInputStream(clientSocket.getInputStream());//поток ввода

            sendMessage("_can_start");
            serverMessage = receiveMessage();
            if (!serverMessage.equals("_allowed_to_start")) {
                System.out.println("Cant start! Server message:" + serverMessage);
                return;
            }

            do {
                serverMessage = receiveMessage();			//принимаем серверную команду

                if (serverMessage.equals("_insert_record_table")) {

                    jf = new InsertRecordTable();
                    jf.setVisible(true);
                    do {
                        serverMessage = receiveMessage();
                        if (serverMessage.equals("_update_components")) {
                            jf.setVisible(false);
                            jf = new InsertRecordTable();
                            jf.setVisible(true);
                            continue;
                        }
                        if (serverMessage.equals("_close_wnd")) {
                            jf.setVisible(false);
                            break;
                        }
                    } while (true);
                    continue;
                }
                if (serverMessage.equals("_insert_service_table")) {

                    jf = new InsertServiceTable();
                    jf.setVisible(true);
                    do {
                        serverMessage = receiveMessage();
                        if (serverMessage.equals("_update_components")) {
                            jf.setVisible(false);
                            jf = new InsertServiceTable();
                            jf.setVisible(true);
                            continue;
                        }
                        if (serverMessage.equals("_close_wnd")) {
                            jf.setVisible(false);
                            break;
                        }
                    } while (true);
                    continue;
                }

                if (serverMessage.equals("_insert_salon_table")) {

                    jf = new InsertSalonTable();
                    jf.setVisible(true);
                    do {
                        serverMessage = receiveMessage();
                        if (serverMessage.equals("_update_components")) {
                            jf.setVisible(false);
                            jf = new InsertSalonTable();
                            jf.setVisible(true);
                            continue;
                        }
                        if (serverMessage.equals("_close_wnd")) {
                            jf.setVisible(false);
                            break;
                        }
                    } while (true);
                    continue;
                }
                if (serverMessage.equals("_insert_user_table")) {

                    jf = new InsertUserTable();
                    jf.setVisible(true);
                    do {
                        serverMessage = receiveMessage();
                        if (serverMessage.equals("_update_components")) {
                            jf.setVisible(false);
                            jf = new InsertUserTable();
                            jf.setVisible(true);
                            continue;
                        }
                        if (serverMessage.equals("_close_wnd")) {
                            jf.setVisible(false);
                            break;
                        }
                    } while (true);
                    continue;
                }
                if (serverMessage.equals("_salon_reg")) {
                    jf = new SalonReg();
                    jf.setVisible(true);
                    continue;
                }

                if (serverMessage.equals("_user_reg")) {
                    jf = new RegUser();
                    jf.setVisible(true);
                    continue;
                }

                if (serverMessage.equals("_authorization")) {
                    jf = new Authorization();
                    jf.setVisible(true);
                    continue;
                }

                if (serverMessage.equals("_error_wnd")) {
                    errorframe = new ErrowWND();
                    errorframe.setVisible(true);
                    continue;
                }

                if (serverMessage.equals("_close_wnd")) {
                    jf.setVisible(false);
                    continue;
                }

                if (serverMessage.equals("_adminmenu")) {
                    jf = new AdminMenu();
                    jf.setVisible(true);
                    continue;
                }

                if (serverMessage.equals("_usermenu")) {
                    jf = new UserMenu();
                    jf.setVisible(true);
                    continue;
                }

                if (serverMessage.equals("_exit")) {
                    jf.setVisible(false);
                    return;
                }

            } while (true);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                coos.close();//закрытие потока вывода 
                cois.close();//закрытие потока ввода
                clientSocket.close();//закрытие сокета
                exit(0);
            } catch (IOException e) {
                e.printStackTrace();//вызывается метод исключения е
            }
        }
    }

    public static void sendMessage(String msg) {
        try {
            coos.writeObject(msg);

            if (logging) {
                System.out.println("message sended: " + msg);
            }
        } catch (IOException e) {
            System.out.println("sendObject = " + e);
        }
    }

    public static void sendObject(Object obj) {
        try {
            coos.writeObject(obj);

            if (logging) {
                System.out.println("object sended!");
            }
        } catch (IOException e) {
            System.out.println("sendObject = " + e);
        }
    }

    public static String receiveMessage() {
        String msg = new String("-no message-");
        try {
            msg = (String) cois.readObject();

            if (logging) {
                System.out.println("~server~: " + msg);
            }
        } catch (Exception e) {
            System.out.println("receiveMessage = " + e);
        }
        return msg;
    }

    public static ArrayList<String[]> receiveResultSet() {
        ArrayList<String[]> rs = null;
        try {
            rs = (ArrayList<String[]>) cois.readObject();

            if (logging) {
                System.out.println("resultSets received ");
            }
        } catch (Exception e) {
            System.out.println("receiveResultSet = " + e);
        }
        return rs;
    }
    
}

