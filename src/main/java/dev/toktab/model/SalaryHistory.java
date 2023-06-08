package dev.toktab.model;

import dev.toktab.model.interfaces.IEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "salaryhistory")
@Data
@NoArgsConstructor
public class SalaryHistory implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fromDate")
    private Date fromDate;
    @Column(name = "toDate")
    private Date toDate;
    @Column(name = "salary")
    private double salary;

    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;

    @Override
    public void memberWiseUpdate(IEntity entity) {
        SalaryHistory newEntity = (SalaryHistory) entity;

        this.setFromDate(newEntity.getFromDate());
        this.setToDate(newEntity.getToDate());
        this.setSalary(newEntity.getSalary());
    }
}
