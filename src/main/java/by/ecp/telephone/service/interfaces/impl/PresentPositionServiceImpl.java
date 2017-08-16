package by.ecp.telephone.service.interfaces.impl;

import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.repository.PersonRepository;
import by.ecp.telephone.repository.PresentPositionRepository;
import by.ecp.telephone.service.interfaces.PresentPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class PresentPositionServiceImpl implements PresentPositionService {

    private PresentPositionRepository presentPositionRepository;

    @Autowired
    public PresentPositionServiceImpl(PresentPositionRepository presentPositionRepository) {
        this.presentPositionRepository = presentPositionRepository;
    }

    @Override
    public Iterable<PresentPosition> listAllPresentPosition() {
        return presentPositionRepository.findAll();
    }

    @Override
    public Optional<PresentPosition> getPresentPositionById(Long id) {
        return presentPositionRepository.findById(id);
    }

    @Override
    public PresentPosition savePresentPosition(PresentPosition presentPosition) {
        return presentPositionRepository.save(presentPosition);
    }

    @Override
    public void deletePresentPosition(Long id)
    {
        presentPositionRepository.deleteById(id);
    }

    @Override
    public long count() {
        return presentPositionRepository.count();
    }


}
