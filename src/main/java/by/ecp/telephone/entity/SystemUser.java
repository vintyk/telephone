package by.ecp.telephone.entity;


import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class SystemUser extends BaseEntity {
    @NotEmpty
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String passwordUser;

    @NotEmpty
    @Column(name = "privilege", nullable = false)
    private Long privilege;
}
