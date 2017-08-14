package by.ecp.telephone.dto;

import by.ecp.telephone.entity.BaseEntity;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
