package by.ecp.telephone.entity;

import lombok.*;
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
    private String alphabet;

    public Person(String firstName,
                  String lastName,
                  String numberMobil,
                  String numberShot,
                  String numberCity,
                  String alphabet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberMobil = numberMobil;
        this.numberShot = numberShot;
        this.numberCity = numberCity;
        this.alphabet = alphabet;
    }
}
