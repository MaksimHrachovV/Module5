package goit.baseServices;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) throws IOException {
        Database database=Database.getInstance();
        try(
                Statement stConnect = database.getConnection().createStatement()){
            stConnect.executeUpdate(database.ReadFileAndCreat("sql/init_db.sql"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
