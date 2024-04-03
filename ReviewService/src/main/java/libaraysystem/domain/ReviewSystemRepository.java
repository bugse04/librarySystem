package libaraysystem.domain;

import libaraysystem.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "reviewSystems",
    path = "reviewSystems"
)
public interface ReviewSystemRepository
    extends PagingAndSortingRepository<ReviewSystem, Long> {}
