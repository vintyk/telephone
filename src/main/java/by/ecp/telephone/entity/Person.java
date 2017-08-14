package by.ecp.telephone.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person extends BaseEntity {
    private String firstName;
    @NotEmpty(message = "Last Name is required.")
    private String lastName;
    @Column(name = "s_name")
    private String sName;
    private String numberMobil;
    private String numberShot;
    private String numberCity;
    private String alphabet;
    private String presentPosition;

    public Person(String firstName,
                  String lastName,
                  String numberMobil,
                  String numberShot,
                  String numberCity,
                  String alphabet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sName = sName;
        this.numberMobil = numberMobil;
        this.numberShot = numberShot;
        this.numberCity = numberCity;
        this.alphabet = alphabet;
    }
}
