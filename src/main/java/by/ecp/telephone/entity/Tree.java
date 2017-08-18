package by.ecp.telephone.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tree")
@NoArgsConstructor
@Data
public class Tree extends BaseEntity {
    @NotEmpty(message = "branchId is required.")
    @Column(name = "branch_id")
    private Branch branchId;

    @Column(name = "chief_executive_id")
    private PresentPosition chiefExecutiveId;

    @Column(name = "present_position_1_id")
    private PresentPosition presentPosition1Id;

    @Column(name = "present_position_2_id")
    private PresentPosition presentPosition2Id;

    @Column(name = "present_position_3_id")
    private PresentPosition presentPosition3Id;

    @Column(name = "present_position_4_id")
    private PresentPosition presentPosition4Id;

    @Column(name = "present_position_5_id")
    private PresentPosition presentPosition5Id;

}
