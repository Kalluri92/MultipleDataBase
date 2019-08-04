package com.krishna.MultiDB.Controllers;

import com.krishna.MultiDB.EmployeeDB.Entitys.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManagerFactory;

@RestController
public class EmployeeController {

    @Autowired
    @Qualifier("employeeDBEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") String id) {
        return entityManagerFactory.createEntityManager().find(Employee.class, id);
    }
}
