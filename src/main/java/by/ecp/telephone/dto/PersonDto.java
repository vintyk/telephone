package by.ecp.telephone.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class PersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String sName;
    private String numberMobil;
    private String numberShot;
    private String numberCity;
    private String alphabet;
    private String presentPosition;

    public PersonDto(Long id,
                     String firstName,
                     String lastName,
                     String sName,
                     String numberMobil,
                     String numberShot,
                     String numberCity,
                     String alphabet,
                     String presentPosition) {
        this.id = id;
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
