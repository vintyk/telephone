package by.ecp.telephone.service.interfaces.impl;

import by.ecp.telephone.entity.Person;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.repository.PresentPositionRepository;
import by.ecp.telephone.service.interfaces.PresentPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentPositionServiceImpl implements PresentPositionService {

    private PresentPositionRepository presentPositionRepository;

    @Autowired
    public PresentPositionServiceImpl(PresentPositionRepository presentPositionRepository) {
        this.presentPositionRepository = presentPositionRepository;
    }

    @Override
    public Iterable<PresentPosition> getAllPresentPosition() {
        return  this.presentPositionRepository.findAll();
    }

}
