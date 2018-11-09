package by.ecp.telephone.repository;


import by.ecp.telephone.entity.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {

    Iterable<Branch> findAllByNameIsNotNullOrderByNameAsc();
}
