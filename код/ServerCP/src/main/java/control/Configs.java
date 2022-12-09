package control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Configs {
    protected String dbHost; //= "localhost"
    protected String dbPort; //= "3306"
    protected String dbUser; //= "root"
    protected String dbPass; //= "rfyfhtqrf"
    protected String dbName; //= "salon"
    
    /**
     *
     */
    protected void getConfigs() throws FileNotFoundException, IOException {
        FileReader reader = new FileReader("D:\\код\\ServerCP\\src\\main\\java\\control\\config.txt");
        Scanner scanner = new Scanner(reader);
        this.dbHost = scanner.nextLine();
        this.dbPort = scanner.nextLine();
        this.dbUser = scanner.nextLine();
        this.dbPass = scanner.nextLine();
        this.dbName = scanner.nextLine();
        reader.close();
    }
}
