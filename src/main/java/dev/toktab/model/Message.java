package dev.toktab.model;

import dev.toktab.model.interfaces.IEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
public class Message implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "msg")
    private String message;

    @ManyToOne
    @JoinColumn(name="from")
    private User fromUser;
    @ManyToOne
    @JoinColumn(name="to")
    private User toUser;

    @Override
    public void memberWiseUpdate(IEntity entity) {
        Message newEntity = (Message) entity;

        this.setMessage(newEntity.getMessage());
        this.setFromUser(newEntity.getFromUser());
        this.setToUser(newEntity.getToUser());
    }
}
