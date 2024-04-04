package libaraysystem.domain;

import java.time.LocalDate;
import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PointIncreased extends AbstractEvent {

    private Long id;
    private Integer point;
    private String userId;

    public PointIncreased(PointSystem aggregate) {
        super(aggregate);
    }

    public PointIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
