package by.ecp.telephone.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TreeDto {
    private Long id;
    private Long branchId;
    private Long chiefExecutiveId;
    private Long presentPosition1Id;
    private Long presentPosition2Id;
    private Long presentPosition3Id;
    private Long presentPosition4Id;
    private Long presentPosition5Id;

    public TreeDto(Long id,
                   Long branchId,
                   Long chiefExecutiveId,
                   Long presentPosition1Id,
                   Long presentPosition2Id,
                   Long presentPosition3Id,
                   Long presentPosition4Id,
                   Long presentPosition5Id) {
        this.id = id;
        this.branchId = branchId;
        this.chiefExecutiveId = chiefExecutiveId;
        this.presentPosition1Id = presentPosition1Id;
        this.presentPosition2Id = presentPosition2Id;
        this.presentPosition3Id = presentPosition3Id;
        this.presentPosition4Id = presentPosition4Id;
        this.presentPosition5Id = presentPosition5Id;
    }
}
