package dev.toktab.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "salaryhistory")
public class SalaryHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "fromDate")
    private Date fromDate;
    @Column(name = "toDate")
    private Date toDate;
    @Column(name = "salary")
    private double salary;
}
