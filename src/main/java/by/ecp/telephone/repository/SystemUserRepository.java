package by.ecp.telephone.repository;


import by.ecp.telephone.entity.SystemUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SystemUserRepository extends PagingAndSortingRepository<SystemUser, Long> {
}
