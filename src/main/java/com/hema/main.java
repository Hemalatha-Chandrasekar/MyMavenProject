package com.hema;

import service.EmployeeService;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EmployeeService employeeService = new EmployeeService();
       // employeeService.getAllEmployees();
        //employeeService.getEmplyoeeById();
        //employeeService.getEmplyoeeByIdandName();
        //employeeService.insertEmployee();
       // employeeService.updateEmployee();
        employeeService.useSQLQueries();

    }

}
