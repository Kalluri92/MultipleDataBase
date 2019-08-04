package com.krishna.MultiDB.StudentDB.Entitys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    private String stundetId;

    @Column(name = "student_name")
    private String stundetName;
}
