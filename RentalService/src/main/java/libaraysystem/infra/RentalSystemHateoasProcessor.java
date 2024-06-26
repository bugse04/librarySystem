package libaraysystem.infra;

import libaraysystem.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RentalSystemHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<RentalSystem>> {

    @Override
    public EntityModel<RentalSystem> process(EntityModel<RentalSystem> model) {
        return model;
    }
}
