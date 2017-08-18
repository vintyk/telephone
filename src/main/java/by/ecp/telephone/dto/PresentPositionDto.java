package by.ecp.telephone.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class PresentPositionDto {

    private Long id;
    private String name;

    public PresentPositionDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
