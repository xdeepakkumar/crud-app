package com.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudapp.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
