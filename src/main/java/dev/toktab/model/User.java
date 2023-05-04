package dev.toktab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "typeId")
    private int typeId;
    @Column(name = "salary")
    private double salary;
    @Column(name = "budget")
    private double budget;
    @Column(name = "date")
    private Date date;
    @Column(name = "fired")
    private int fired;
}