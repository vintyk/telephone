package by.ecp.telephone.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "tree")
@NoArgsConstructor
@Data
public class Tree extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branchId;

    @OneToOne
    @JoinColumn(name = "chief_executive_id")
    private PresentPosition chiefExecutiveId;

    @OneToOne
    @JoinColumn(name = "present_position_1_id")
    private PresentPosition presentPosition1Id;

    @OneToOne
    @JoinColumn(name = "present_position_2_id")
    private PresentPosition presentPosition2Id;

    @OneToOne
    @JoinColumn(name = "present_position_3_id")
    private PresentPosition presentPosition3Id;

    @OneToOne
    @JoinColumn(name = "present_position_4_id")
    private PresentPosition presentPosition4Id;

    @OneToOne
    @JoinColumn(name = "present_position_5_id")
    private PresentPosition presentPosition5Id;

}
