package com.springbootworld.emsystem.repository;

import com.springbootworld.emsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//All SimpleJpaRepository class are @Repository & @Transactional so need to explicitly annotate this interface as Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> { //Generic <T, ID> ID: is Primary key
    //It helps to perform CRUD Operations
}
