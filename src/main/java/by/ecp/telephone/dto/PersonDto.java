package by.ecp.telephone.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class PersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String sName;
    private String numberMobil;
    private String numberShot;
    private String numberCity;
    private String alphabet;
    private Long presentPosition;
    private String presentPositionS;
    private Long treeId;

    public PersonDto(Long id,
                      String firstName,
                      String lastName,
                      String sName,
                      String numberMobil,
                      String numberShot,
                      String numberCity,
                      String alphabet,
                      Long presentPosition,
                      Long treeId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sName = sName;
        this.numberMobil = numberMobil;
        this.numberShot = numberShot;
        this.numberCity = numberCity;
        this.alphabet = alphabet;
        this.presentPosition = presentPosition;
        this.treeId = treeId;
    }
    public PersonDto(Long id,
                     String firstName,
                     String lastName,
                     String sName,
                     String numberMobil,
                     String numberShot,
                     String numberCity,
                     String alphabet,
                     String presentPositionS,
                     Long treeId
                     ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sName = sName;
        this.numberMobil = numberMobil;
        this.numberShot = numberShot;
        this.numberCity = numberCity;
        this.alphabet = alphabet;
        this.presentPositionS = presentPositionS;
        this.treeId = treeId;
    }
}
