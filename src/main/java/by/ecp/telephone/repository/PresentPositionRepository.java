package by.ecp.telephone.repository;


import by.ecp.telephone.entity.PresentPosition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PresentPositionRepository extends CrudRepository<PresentPosition, Long> {
    Iterable<PresentPosition> findAllByNameIsNotNullOrderByName();
}
