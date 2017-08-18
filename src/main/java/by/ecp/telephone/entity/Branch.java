package by.ecp.telephone.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "branch")
@ToString
@NoArgsConstructor
public class Branch extends BaseEntity {
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
}
