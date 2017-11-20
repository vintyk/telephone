package by.ecp.telephone.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class PresentPositionDto {

    private Long id;
    private String name;
    private Long isPresentPositionFlag;

    public PresentPositionDto(Long id, String name, Long isPresentPositionFlag) {
        this.id = id;
        this.name = name;
        this.isPresentPositionFlag = isPresentPositionFlag;
    }
}
