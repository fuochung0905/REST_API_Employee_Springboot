package com.utc2.fuochung.jpa_mysql.Controller;

import com.utc2.fuochung.jpa_mysql.Model.employee;
import com.utc2.fuochung.jpa_mysql.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmployController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping( "/employee")
    public ResponseEntity<List<employee>>getEmployee(){
        return new ResponseEntity<List<employee>>(employeeService.getEmployee(),HttpStatus.OK) ;
    }
    @PostMapping("/employee")
    public ResponseEntity<employee>saveEmployee(@Valid @RequestBody employee E){
        return new ResponseEntity<employee>(employeeService.saveEmployee(E),HttpStatus.CREATED) ;
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<employee>upDateEmployee(@PathVariable Long id, @RequestBody employee e){
        e.setID(id);
        return new ResponseEntity<employee>(employeeService.updateEmployee(e),HttpStatus.OK);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<employee>getEmployee(@PathVariable Long id){
        return new ResponseEntity<employee>(employeeService.getString(id),HttpStatus.OK);
    }
    @DeleteMapping("/employee")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employee/filterByName")
    public ResponseEntity<List<employee>> getEmployeeByName(@RequestParam String name){
        return new ResponseEntity<List<employee>>(employeeService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employee/filterByNameAndDepartment")
    public ResponseEntity<List<employee>>getEmployeeByNameAndDepartment(@RequestParam String name, @RequestParam String department){
        return new ResponseEntity<List<employee>>(employeeService.getEmployeesByNameAndDepartment(name,department),HttpStatus.OK);
    }
    @GetMapping("/employee/filterByKeyword")
    public ResponseEntity<List<employee>>getEmployeeByKeyword(@RequestParam String name){
        return new ResponseEntity<List<employee>>(employeeService.getEmployeeByKeyword(name),HttpStatus.OK);
    }
    @GetMapping("/employee/{name}/{department}")
    public ResponseEntity<List<employee>>getEmployeeByNameOrDepartment(@PathVariable String name, @PathVariable String department){
        return new ResponseEntity<List<employee>>(employeeService.getEmployeesByNameOrDepartment(name, department),HttpStatus.OK);
    }
    @DeleteMapping("/employee/delete/{name}")
    public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name){
        return new ResponseEntity<String>(employeeService.deleteEmployeesByName(name)+"DELETE SUCCESS",HttpStatus.OK);
    }
}
