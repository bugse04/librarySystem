package libaraysystem.infra;

import libaraysystem.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ReviewSystemHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ReviewSystem>> {

    @Override
    public EntityModel<ReviewSystem> process(EntityModel<ReviewSystem> model) {
        return model;
    }
}
