package by.ecp.telephone.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class PersonDto {
    private String firstName;
    private String lastName;
    private String sName;
    private String numberMobil;
    private String numberShot;
    private String numberCity;
    private String alphabet;
    private String presentPosition;
}
