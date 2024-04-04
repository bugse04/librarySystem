package libaraysystem.infra;

import java.util.List;
import libaraysystem.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "dashBoards",
    path = "dashBoards"
)
public interface DashBoardRepository
    extends PagingAndSortingRepository<DashBoard, Long> {
    List<DashBoard> findByUserId(String userId);
}
