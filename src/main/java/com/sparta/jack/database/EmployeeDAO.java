package com.sparta.jack.database;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import java.util.Properties;

public class EmployeeDAO {
    private final String URL = "jdbc:mysql://localhost:3306/jack_db?serverTimezone=GMT";
    private Connection connection;
    private Properties properties = new Properties();

    private final String insertNewRecord = "INSERT INTO Employees VALUES(?,?,?,?,?,?,?,?,?,?)";

    private Connection connectToDatabase() {
        try {
            properties.load(new FileReader("resources/login.properties"));
            connection = DriverManager.getConnection(URL, properties.getProperty("username"), properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public void InsertEmployee(EmployeeDTO employeeIn, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1, employeeIn.getEmpID());
            preparedStatement.setString(2, employeeIn.getNamePrefix());
            preparedStatement.setString(3, employeeIn.getFirstName());
            preparedStatement.setString(4, Character.toString(employeeIn.getMiddleInitial()));
            preparedStatement.setString(5, employeeIn.getLastName());
            preparedStatement.setString(6, Character.toString(employeeIn.getGender()));
            preparedStatement.setString(7, employeeIn.getEmail());
            preparedStatement.setDate(8, new java.sql.Date(employeeIn.getDateOfBirth().getTime()));
            preparedStatement.setDate(9, new java.sql.Date(employeeIn.getDateOfJoining().getTime()));
            preparedStatement.setString(10, Integer.toString(employeeIn.getSalary()));
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public PreparedStatement makePreparedStatement() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectToDatabase().prepareStatement(insertNewRecord);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return preparedStatement;
    }


}
