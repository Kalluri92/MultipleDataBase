package com.krishna.MultiDB.Controllers;


import com.krishna.MultiDB.StudentDB.Entitys.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManagerFactory;

@RestController
public class StudentController {

    @Autowired
    @Qualifier("stundetDBEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") String id) {
        return entityManagerFactory.createEntityManager().find(Student.class, id);
    }
}
