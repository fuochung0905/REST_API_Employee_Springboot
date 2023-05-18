package com.utc2.fuochung.jpa_mysql.service;

import com.utc2.fuochung.jpa_mysql.Model.employee;
import com.utc2.fuochung.jpa_mysql.Repository.EmployeeRepository;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImple implements EmployeeService{
   @Autowired
   private EmployeeRepository employeeREPOSITORY;
    @Override
    public List<employee> getEmployee() {
        return employeeREPOSITORY.findAll();
    }

    @Override
    public employee saveEmployee(employee E) {
        return employeeREPOSITORY.save(E);
    }
    @Override
    public employee getString(Long id) {
        Optional<employee> employee= employeeREPOSITORY.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw  new RuntimeException("Employee is not found for the id");
    }
    @Override
    public void deleteEmployee(Long id) {
        employeeREPOSITORY.deleteById(id);
    }
    @Override
    public employee updateEmployee(employee e) {
        return employeeREPOSITORY.save(e);
    }
    @Override
    public List<employee> getEmployeesByName(String name) {
        return employeeREPOSITORY.findByName(name);
    }
    @Override
    public List<employee> getEmployeesByNameAndDepartment(String name, String department) {
        return employeeREPOSITORY.findByNameAndDepartment(name,department);
    }
    @Override
    public List<employee> getEmployeeByKeyword(String name) {
        Sort sort= Sort.by(Sort.Direction.DESC,"id");
        return employeeREPOSITORY.findByNameContaining(name,sort);
    }

    @Override
    public List<employee> getEmployeesByNameOrDepartment(String name, String department) {
        return employeeREPOSITORY.getEmployeeByNameOrDepartment(name,department);
    }

    @Override
    public Integer deleteEmployeesByName(String name) {
        return employeeREPOSITORY.deleteemployeesByName(name) ;
    }


}
