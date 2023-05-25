package dev.toktab.model;

import jakarta.persistence.*;

@Entity
@Table(name = "message")
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
