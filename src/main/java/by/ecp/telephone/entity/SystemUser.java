package by.ecp.telephone.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
@NoArgsConstructor
@ToString
public class SystemUser extends BaseEntity{
    @NotEmpty
    @Getter
    @Setter
    @Column(name = "email", nullable=false)
    private String email;

    @NotEmpty
    @Getter
    @Setter
    @Column(name = "password", nullable=false)
    private String passwordUser;

    @NotEmpty
    @Getter
    @Setter
    @Column(name = "privilege", nullable=false)
    private Long privilege;


}
