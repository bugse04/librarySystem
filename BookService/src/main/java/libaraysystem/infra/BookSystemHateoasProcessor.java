package libaraysystem.infra;

import libaraysystem.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class BookSystemHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<BookSystem>> {

    @Override
    public EntityModel<BookSystem> process(EntityModel<BookSystem> model) {
        return model;
    }
}
