package dev.toktab.model;

import dev.toktab.model.interfaces.IEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "funding")
@Data
@NoArgsConstructor
public class Funding implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="from")
    private User fromUser;
    @ManyToOne
    @JoinColumn(name="to")
    private User toUser;

    @Override
    public void memberWiseUpdate(IEntity entity) {
        Funding newEntity = (Funding) entity;

        this.setAmount(newEntity.getAmount());
        this.setFromUser(newEntity.getFromUser());
        this.setToUser(newEntity.getToUser());
        this.setDate(newEntity.getDate());
    }
}
