package by.ecp.telephone.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

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
    @NotEmpty(message = "Alphabet is required.")
    private String alphabet;
    @OneToOne
    @JoinColumn(name = "present_position_id", nullable = false)
    private PresentPosition presentPosition;

    public Person(String firstName,
                  String lastName,
                  String numberMobil,
                  String numberShot,
                  String numberCity,
                  String alphabet,
                  PresentPosition presentPosition){
        this.firstName = firstName;
        this.lastName = lastName;
        this.sName = sName;
        this.numberMobil = numberMobil;
        this.numberShot = numberShot;
        this.numberCity = numberCity;
        this.alphabet = alphabet;
        this.presentPosition = presentPosition;
    }
}
