package by.ecp.telephone.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class BranchDto {

    private Long id;
    private String name;

    public BranchDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
