package by.ecp.telephone.service.interfaces;


import by.ecp.telephone.entity.SystemUser;

public interface SystemUserService {

    SystemUser findSystemUserByEmailSystemUser(String email);
}
