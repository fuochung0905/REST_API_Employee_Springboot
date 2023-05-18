package com.utc2.fuochung.jpa_mysql.Repository;

import com.utc2.fuochung.jpa_mysql.Model.employee;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<employee, Long> {

List<employee> findByName (String name);
List<employee> findByNameAndDepartment(String name, String department);
List<employee> findByNameContaining(String keyword, Sort sort);

@Query("FROM employee where name= :name OR department= :department")
List<employee> getEmployeeByNameOrDepartment(String name, String department);

@Transactional
@Modifying
@Query(" delete from employee where name= :name")
    Integer deleteemployeesByName(String name);
}
