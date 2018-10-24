package training.connector;

import training.entity.PersonalInfo;
import training.entity.User;

import java.sql.*;

public class Connector {
    private String host;
    private String schema;
    private String user;
    private String password;
    private Connection connection;
    private boolean isConnected = false;

    private final String READ_PERSONAL_INFO_BY_LOGIN = "select firstName, lastName, fatherName, phoneNumber, age " +
            "from festivals_db.userInfo ui inner join festivals_db.userAuthorization ua on " +
            "ui.userAuthorization_id = ua.id where ua.login = ?;";
    private final String INSERT_PERSONAL_INFO = "insert into festivals_db.userInfo (firstName, lastName, fatherName, phoneNumber, age, userAuthorization_id) " +
            "values (?,?,?,?,?,?,?,?)";

    public Connector(String host, String schema, String user, String password) {
        this.host = host;
        this.schema = schema;
        this.user = user;
        this.password = password;
    }

    public void openConnection() throws ClassNotFoundException, SQLException {
        if (isConnected)
            return;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + schema, user, password);
        isConnected = true;
    }

    public PersonalInfo readPersonalInfo(String login) throws SQLException {
        ResultSet resultSet = null;
        try {
            PreparedStatement findUserByLogin = connection.prepareStatement(READ_PERSONAL_INFO_BY_LOGIN);
            findUserByLogin.setString(1,login);
            resultSet = findUserByLogin.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String fatherName = resultSet.getString("fatherName");
                String phoneNumber = resultSet.getString("phoneNumber");
                int age = resultSet.getInt("age");
                return new PersonalInfo(firstName,lastName,fatherName,phoneNumber,age);
            }
            return null;
        }
        finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void writePersonalInfo(PersonalInfo personalInfo) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSONAL_INFO);

        preparedStatement.setString(1, personalInfo.getFirstName());
        preparedStatement.setString(2, personalInfo.getLastName());
        preparedStatement.setString(3, personalInfo.getFatherName());
        preparedStatement.setString(4, personalInfo.getPhoneNumber());
        preparedStatement.setInt(5, personalInfo.getAge());
        preparedStatement.setInt(6, personalInfo.getUserAuthorization().getId());
        preparedStatement.setInt(7, personalInfo.getUserStatus().ordinal());

        preparedStatement.executeUpdate();
        preparedStatement.close();

    }
}
