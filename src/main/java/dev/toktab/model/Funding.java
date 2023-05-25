package dev.toktab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "funding")
@Data
@NoArgsConstructor
public class Funding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
}
