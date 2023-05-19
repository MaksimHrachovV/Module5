package goit.baseServices;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public class DatabasePopulateServicePreparedStatement {
    private static PreparedStatement populateWorker;
    private static PreparedStatement populateCLIENTID;
    private static PreparedStatement populateCLIENT;
    private static PreparedStatement populatePROJECT;
    private static PreparedStatement populatePROJECTWORKER;



    public static boolean saveWorker (String name, LocalDate birthday, String level,int salary) {
        try {
            populateWorker.setString(1,name);
            populateWorker.setString(2,birthday.toString());
            populateWorker.setString(3,level);
            populateWorker.setInt(4,salary);
            return populateWorker.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean saveCLIENTID(int id) {
        try {
            populateCLIENTID.setInt(1, id);
            return populateCLIENTID.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean saveCLIENT(int Client_ID, int NAME_ID) {
        try {
            populateCLIENT.setInt(1, Client_ID);
            populateCLIENT.setInt(2, NAME_ID);
            return populateCLIENT.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean savePROJECT(int CLIENT_ID, LocalDate START_DATE, LocalDate FINISH_DATE ) {
        try {
            populatePROJECT.setInt(1, CLIENT_ID);
            populatePROJECT.setString(2,START_DATE.toString());
            populatePROJECT.setString(3,FINISH_DATE.toString());
            return populatePROJECT.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean savePROJECTWORKER(int PROJECT_ID, int WORKER_ID) {
        try {
            populatePROJECTWORKER.setInt(1, PROJECT_ID);
            populatePROJECTWORKER.setInt(2, WORKER_ID);
            return populatePROJECTWORKER.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }





    public static void main(String[] args) throws SQLException {
        String workeSql="INSERT INTO worker (name, birthday, level, salary ) VALUES (?,?,?,?)";
        String clientIdSql="INSERT INTO CLIENTID (ID) VALUES (?)";
        String clientSql="INSERT INTO CLIENT (Client_ID, NAME_ID) VALUES (?,?)";
        String projectSql="INSERT INTO PROJECT (CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?,?,?)";
        String projectWorkerSql="INSERT INTO PROJECT_WORKER(PROJECT_ID, WORKER_ID) VALUES (?,?)";

        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        populateWorker = connection.prepareStatement(workeSql);
        populateCLIENTID = connection.prepareStatement(clientIdSql);
        populateCLIENT = connection.prepareStatement(clientSql);
        populatePROJECT = connection.prepareStatement(projectSql);
        populatePROJECTWORKER = connection.prepareStatement(projectWorkerSql);


        saveWorker("Max", LocalDate.parse("1982-12-19"), "Trainee", 1990);
        saveWorker("Gregor", LocalDate.parse("2000-01-01"), "Junior", 3900);
        saveWorker("Leon", LocalDate.parse("1982-12-19"), "Middle", 5000);
        saveWorker("Taras", LocalDate.parse("1992-01-01"), "Senior", 2000);
        saveWorker("Inna", LocalDate.parse("1990-10-01"), "Junior", 3600);
        saveWorker("Oleg", LocalDate.parse("1989-03-10"), "Middle", 6000);
        saveWorker("Anna", LocalDate.parse("1990-09-15"), "Senior", 20000);
        saveWorker("Georg", LocalDate.parse("1992-05-20"), "Middle", 4000);
        saveWorker("Sveta", LocalDate.parse("1990-01-01"), "Trainee", 1500);
        saveWorker("Ivan", LocalDate.parse("1982-12-19"), "Trainee", 1600);

        saveCLIENTID(1);
        saveCLIENTID(2);
        saveCLIENTID(3);
        saveCLIENTID(4);
        saveCLIENTID(5);

        saveCLIENT(1,1);
        saveCLIENT(1,2);
        saveCLIENT(1,3);
        saveCLIENT(2,4);
        saveCLIENT(2,5);
        saveCLIENT(2,6);
        saveCLIENT(3,7);
        saveCLIENT(3,8);
        saveCLIENT(4,9);
        saveCLIENT(5,10);

        savePROJECT(1, LocalDate.parse("2022-12-19"), LocalDate.parse("2023-12-19"));
        savePROJECT(1, LocalDate.parse("2022-01-01"), LocalDate.parse("2023-01-09"));
        savePROJECT(1, LocalDate.parse("2022-12-19"), LocalDate.parse("2023-10-18"));
        savePROJECT(3, LocalDate.parse("2021-01-01"), LocalDate.parse("2022-02-03"));
        savePROJECT(2, LocalDate.parse("2023-02-01"), LocalDate.parse("2024-12-10"));
        savePROJECT(4, LocalDate.parse("2020-03-10"), LocalDate.parse("2021-10-15"));
        savePROJECT(5, LocalDate.parse("2021-09-15"), LocalDate.parse("2022-12-30"));
        savePROJECT(3, LocalDate.parse("2021-05-20"), LocalDate.parse("2022-05-04"));
        savePROJECT(4, LocalDate.parse("2020-01-01"), LocalDate.parse("2022-02-11"));
        savePROJECT(2, LocalDate.parse("2020-01-01"), LocalDate.parse("2022-02-11"));

        savePROJECTWORKER(1,1);
        savePROJECTWORKER(1,2);
        savePROJECTWORKER(2,3);
        savePROJECTWORKER(2,4);
        savePROJECTWORKER(3,5);
        savePROJECTWORKER(3,6);
        savePROJECTWORKER(4,7);
        savePROJECTWORKER(5,8);
        savePROJECTWORKER(5,9);
        savePROJECTWORKER(6,3);
        savePROJECTWORKER(7,5);
        savePROJECTWORKER(8,5);
        savePROJECTWORKER(9,1);
        savePROJECTWORKER(10,1);
        savePROJECTWORKER(10,10);
    }
}
