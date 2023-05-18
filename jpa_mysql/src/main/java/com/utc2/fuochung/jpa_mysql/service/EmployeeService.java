package com.utc2.fuochung.jpa_mysql.service;

import com.utc2.fuochung.jpa_mysql.Model.employee;

import java.util.List;

public interface EmployeeService {
    List<employee> getEmployee();
    employee saveEmployee(employee E);
    employee getString(Long id);
    void deleteEmployee(Long id);
    employee updateEmployee(employee e);
    List<employee>getEmployeesByName(String name);
    List<employee>getEmployeesByNameAndDepartment(String name , String department);
    List<employee>getEmployeeByKeyword(String name);
    List<employee>getEmployeesByNameOrDepartment(String name ,String department);
    Integer deleteEmployeesByName(String name);

}
