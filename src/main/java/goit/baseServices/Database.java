package goit.baseServices;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database STARTBASE =new Database();
    private Connection connection;
    private Database(){
        String connectUrl = "jdbc:h2:./start";
        try { connection = DriverManager.getConnection(connectUrl);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Database getInstance(){
        return STARTBASE;
    }


    public String ReadFileAndCreat (String pathSql){
        String fileName = pathSql;
        String content = null;
        try {
            content = Files.readAllLines(Paths.get(fileName)).stream().reduce("",String::concat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(content);
        return content;
    }


    public Connection getConnection(){
        return connection;
    }

}


