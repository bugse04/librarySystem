package libaraysystem.domain;

import libaraysystem.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "rentalSystems",
    path = "rentalSystems"
)
public interface RentalSystemRepository
    extends PagingAndSortingRepository<RentalSystem, Long> {}
