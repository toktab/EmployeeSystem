package dev.toktab.model;

import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "from")
    private int from;
    @Column(name = "to")
    private int to;
    @Column(name = "msg")
    private String message;
}
