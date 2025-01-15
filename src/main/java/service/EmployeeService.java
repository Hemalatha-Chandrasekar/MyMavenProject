package service;

import utility.DBConnection;

import java.sql.*;


public class EmployeeService {
    public void getAllEmployees() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection();
        System.out.println("-----mysql JDBC Connection Established------");
        String SelectSQL = "Select * FROM employees";
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(SelectSQL);
        while (resultSet.next()) {
            String employeeID = resultSet.getString("employeeNumber");
            String fName = resultSet.getString("firstName");
            String lName = resultSet.getString("lastName");
            System.out.println(employeeID + "| " + fName + "| " + lName);
        }
        connection.close();
    }

    public void getEmplyoeeById() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection();
        String SelectSQL = "select * from employees where employeeNumber = ?";
        PreparedStatement ps = connection.prepareStatement(SelectSQL);
        ps.setInt(1, 1088);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
           // String employeeID = resultSet.getString("employeeNumber");
           String fName = resultSet.getString("firstName");
            String email = resultSet.getString("email");
            System.out.println(fName+ "| " + email);
        }
        connection.close();
    }
    public void getEmplyoeeByIdandName() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection();
        String SelectSQL = "select * from employees where employeeNumber = ? and lastName = ?";

        PreparedStatement ps = connection.prepareStatement(SelectSQL);

        ps.setInt(1, 1165);// for first placeholder "?",
        ps.setString(2, "Jennings");/// for second placeholder "?",
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            // String employeeID = resultSet.getString("employeeNumber");
            String fName = resultSet.getString("firstName");
            String email = resultSet.getString("email");
            System.out.println(fName+ "| " + email);
        }
        connection.close();
    }
    public void insertEmployee() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection();

        String SelectSQL = "INSERT INTO EMPLOYEES (officeCode, firstName, lastName, email, extension, reportsTo, VactionHours, employeeNumber, jobTitle)"+ "VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(SelectSQL);
        ps.setInt(1, 6);
        ps.setString(2, "Jane");
        ps.setString(3, "Doe");
        ps.setString(4, "marrysmith@gamil.com");
        ps.setString(5, "x7071");
        ps.setInt(6, 1002);
        ps.setInt(7, 35);
        ps.setInt(8, 1051);
        ps.setString(9, "Administrator");

        int affectedRows = ps.executeUpdate();
        System.out.println(affectedRows+" rows was affected");
        connection.close();
    }
    public void updateEmployee() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection();
        String SelectSQL = "update employees set firstName=? , lastName=? where employeeNumber=?";
        PreparedStatement mystmt = connection.prepareStatement(SelectSQL);
        mystmt.setString(1, "Gary");
        mystmt.setString(2, "Larson");
        mystmt.setLong (3, 1002);
        mystmt.executeUpdate();
        connection.close();
    }
    public void useSQLQueries() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDBConnection();
        PreparedStatement ps = connection.prepareStatement(SQLQueries.GetEmployees);
        ps.setInt(1, 1176);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            String employeeID = resultSet.getString("employeeNumber");
            String fName = resultSet.getString("firstName");
            String email = resultSet.getString("email");
            System.out.println( fName + "| " +email);
        }
    }
}

