package data;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MysqlClient {
    private Connection connection;
    Map<Integer, String> country = new HashMap<>();

    //    @Inject
//    Database db;
    public MysqlClient() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task3", "root", "Welcome@123");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM countries");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            country.put(id, name);
        }


    }

    public Connection getConnection() {
        return connection;
    }

    public Map<Integer, String> getCountry() {
        return country;
    }

}