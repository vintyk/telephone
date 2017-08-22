package by.ecp.telephone.service.interfaces.impl;

import by.ecp.telephone.entity.SystemUser;
import by.ecp.telephone.repository.SystemUserRepository;
import by.ecp.telephone.service.interfaces.SystemUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class SystemUserServiceImpl implements SystemUserService {

    private SystemUserRepository systemUserRepository;

    public SystemUserServiceImpl(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Transactional
    @Override
    public SystemUser findSystemUserByEmailSystemUser(String email) {
        return null;
    }
}
