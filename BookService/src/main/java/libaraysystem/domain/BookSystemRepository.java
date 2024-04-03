package libaraysystem.domain;

import libaraysystem.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "bookSystems",
    path = "bookSystems"
)
public interface BookSystemRepository
    extends PagingAndSortingRepository<BookSystem, Long> {}
