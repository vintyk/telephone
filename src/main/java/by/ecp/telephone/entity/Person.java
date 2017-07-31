package by.ecp.telephone.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person extends BaseEntity {
    private String firstName;
    @NotEmpty(message = "Last Name is required.")
    private String lastName;
    private String numberMobil;
    private String numberShot;
    private String numberCity;

    public Person(
            String firstName,
            String lastName,
            String numberMobil,
            String numberShot,
            String numberCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberMobil = numberMobil;
        this.numberMobil = numberShot;
        this.numberMobil = numberCity;
    }
}
