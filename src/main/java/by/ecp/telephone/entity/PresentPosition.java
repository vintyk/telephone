package by.ecp.telephone.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "present_position")
@ToString
@NoArgsConstructor
public class PresentPosition extends BaseEntity {
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
}
