package by.ecp.telephone.repository;


import by.ecp.telephone.entity.SystemUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface SystemUserRepository extends PagingAndSortingRepository<SystemUser, Long> {
}
