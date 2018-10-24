import training.connector.Connector;
import training.entity.PersonalInfo;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connector connector = new Connector("127.0.0.1", "festivals", "root", "root");
        try {
            connector.openConnection();
            System.out.println("Connected successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PersonalInfo personalInfo = null;
        try {
            personalInfo = connector.readPersonalInfo("johndoe");
            System.out.println(personalInfo.getAge());
        } catch (SQLException e) {
            System.out.println("Error in statement execution " + e.getMessage());
        }
    }
}
