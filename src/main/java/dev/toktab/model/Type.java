package dev.toktab.model;

import dev.toktab.model.interfaces.IEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "type")
@Data
@NoArgsConstructor
public class Type implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "creatorId")
    private int creatorId;
    @Column(name = "rank")
    private int rank;

    @Override
    public void memberWiseUpdate(IEntity entity) {
        Type newEntity = (Type) entity;

        this.setCreatorId(newEntity.getCreatorId());
        this.setRank(newEntity.getRank());
    }
}
