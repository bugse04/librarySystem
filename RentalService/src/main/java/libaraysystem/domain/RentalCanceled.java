package libaraysystem.domain;

import java.time.LocalDate;
import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RentalCanceled extends AbstractEvent {

    private String userId;

    public RentalCanceled(RentalSystem aggregate) {
        super(aggregate);
    }

    public RentalCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
