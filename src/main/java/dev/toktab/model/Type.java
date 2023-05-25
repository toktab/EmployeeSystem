package dev.toktab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "type")
@Data
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "creatorId")
    private int creatorId;
    @Column(name = "rank")
    private int rank;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    private List<User> userList;
}
