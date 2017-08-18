package by.ecp.telephone.repository;


import by.ecp.telephone.entity.Tree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TreeRepository extends CrudRepository<Tree, Long> {
}
