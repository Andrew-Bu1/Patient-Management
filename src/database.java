package src;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {

    public static Connection connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientdata", "root",
                    "123456");
            return connect;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
