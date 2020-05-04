package ro.jademy.contactlist.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUserService {


    // con.setAutoCommit(false)
    // TODO SET auto-commit OFF !!!!!!!!


    public static void main(String[] args) {

        Properties properties = getProperties();

        try {
            Connection conn = getConnection(properties);

            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery("select * from employees");

            while (result.next()) {
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                System.out.println(firstName + " " + lastName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    public static Connection getConnection(Properties props) throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", props.getProperty("db.user"));
        connectionProps.put("password", props.getProperty("db.password"));

        Connection conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        props.getProperty("db.url")
                        + ":" + props.getProperty("db.port") + "/" + props.getProperty("db.name"),
                connectionProps);
        return conn;
    }


    public static Properties getProperties() {
        Properties prop = new Properties();
        try(InputStream input = DBUserService.class.getResourceAsStream("/application.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}
