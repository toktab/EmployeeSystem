package dev.toktab.model;

import dev.toktab.model.interfaces.IEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "budget")
@Data
@NoArgsConstructor
public class Budget implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;

    @Override
    public void memberWiseUpdate(IEntity entity) {
        Budget newEntity = (Budget) entity;

        this.setAmount(newEntity.getAmount());
        this.setUser(newEntity.getUser());
        this.setDescription(newEntity.getDescription());
        this.setDate(newEntity.getDate());
    }
}
