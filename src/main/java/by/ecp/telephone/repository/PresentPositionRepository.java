package by.ecp.telephone.repository;


import by.ecp.telephone.entity.PresentPosition;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentPositionRepository extends PagingAndSortingRepository<PresentPosition, Long> {
}
