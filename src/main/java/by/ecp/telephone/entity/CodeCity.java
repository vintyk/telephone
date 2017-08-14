package by.ecp.telephone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "code_city")
public class CodeCity extends BaseEntity {
    String name;
    Long code;

    public CodeCity(String name, Long code) {
        this.name = name;
        this.code = code;
    }
}
