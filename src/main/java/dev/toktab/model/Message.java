package dev.toktab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
public class Message {
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
}
