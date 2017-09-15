package by.ecp.telephone.repository;


import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.entity.Tree;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TreeRepository extends CrudRepository<Tree, Long> {
}
