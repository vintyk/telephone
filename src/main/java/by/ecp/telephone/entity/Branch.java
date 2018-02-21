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
    private Long fff;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        if (name != null ? !name.equals(branch.name) : branch.name != null) return false;
        return fff != null ? fff.equals(branch.fff) : branch.fff == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (fff != null ? fff.hashCode() : 0);
        return result;
    }
}
