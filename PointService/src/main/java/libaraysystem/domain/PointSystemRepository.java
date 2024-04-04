package libaraysystem.domain;

import libaraysystem.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "pointSystems",
    path = "pointSystems"
)
public interface PointSystemRepository
    extends PagingAndSortingRepository<PointSystem, Long> {}
