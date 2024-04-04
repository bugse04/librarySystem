package libaraysystem.infra;

import libaraysystem.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PointSystemHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PointSystem>> {

    @Override
    public EntityModel<PointSystem> process(EntityModel<PointSystem> model) {
        return model;
    }
}
