package com.learning.springboot.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EmployeeContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int phoneNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    Employee employee;
}
