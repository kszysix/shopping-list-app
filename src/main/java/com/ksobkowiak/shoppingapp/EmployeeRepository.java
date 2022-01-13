package com.ksobkowiak.shoppingapp;

import com.ksobkowiak.shoppingapp.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
