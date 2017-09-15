package by.ecp.telephone.repository;


import by.ecp.telephone.entity.Person;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.entity.Tree;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface PresentPositionRepository extends CrudRepository<PresentPosition, Long> {
    Iterable<PresentPosition> findAllByNameIsNotNullOrderByName();

    @Query(value = "select * from present_position where id in (select distinct(t.present_position_1_id) from tree t where t.branch_id = ?1)", nativeQuery = true)
    List<PresentPosition> findNativeByPresentPosition_1(String branch_id);
}
