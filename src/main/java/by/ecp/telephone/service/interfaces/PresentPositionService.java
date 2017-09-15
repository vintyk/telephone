package by.ecp.telephone.service.interfaces;

import by.ecp.telephone.dto.PresentPositionDto;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.entity.Tree;

import java.util.List;
import java.util.Optional;

public interface PresentPositionService {

    Iterable<PresentPosition> listAllPresentPosition();

    Optional<PresentPosition> getPresentPositionById(Long id);

    PresentPosition savePresentPosition(PresentPositionDto presentPositionDto);

    List<PresentPosition> findNativeByBranchId(String branchId);

    void deletePresentPosition(Long id);

    long count();

}
