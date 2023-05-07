package dev.toktab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "budget")
@Data
@NoArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;
}
