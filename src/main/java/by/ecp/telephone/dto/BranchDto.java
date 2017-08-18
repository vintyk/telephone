package by.ecp.telephone.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class BranchDto {

    private Long id;
    private String name;

    public BranchDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
