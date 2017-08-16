package by.ecp.telephone.service.interfaces;

import by.ecp.telephone.dto.PresentPositionDto;
import by.ecp.telephone.entity.PresentPosition;

import java.util.Optional;

public interface PresentPositionService {

    Iterable<PresentPosition> listAllPresentPosition();

    Optional<PresentPosition> getPresentPositionById(Long id);

    PresentPosition savePresentPosition(PresentPositionDto presentPositionDto);

    void deletePresentPosition(Long id);

    long count();
}
