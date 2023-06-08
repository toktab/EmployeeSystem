package dev.toktab.model;

import dev.toktab.model.interfaces.IEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "salary")
    private double salary;
    @Column(name = "budget")
    private double budget;
    @Column(name = "date")
    private Date date;
    @Column(name = "fired")
    private int fired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="type_id", nullable=false)
    private Type type;
    @OneToMany(mappedBy = "user")
    private List<SalaryHistory> salaryHistoryList;
    @OneToMany(mappedBy = "user")
    private List<Budget> budgetList;
    @OneToMany(mappedBy = "toUser")
    private List<Funding> receivedFundsList;
    @OneToMany(mappedBy = "fromUser")
    private List<Funding> sendFundsList;
    @OneToMany(mappedBy = "toUser")
    private List<Message> receivedMessageList;
    @OneToMany(mappedBy = "fromUser")
    private List<Message> sendMessageList;

    @Override
    public void memberWiseUpdate(IEntity entity) {
        User newEntity = (User) entity;

        this.setName(newEntity.getName());
        this.setPassword(newEntity.getPassword());
        this.setType(newEntity.getType());
        this.setBudget(newEntity.getBudget());
        this.setFired(newEntity.getFired());
        this.setSalary(newEntity.getSalary());
    }
}