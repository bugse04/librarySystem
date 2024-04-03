package libaraysystem.domain;

import java.time.LocalDate;
import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewRegistered extends AbstractEvent {

    private Long reviewId;
    private String reviewConts;
    private Date createDate;
    private String userId;

    public ReviewRegistered(ReviewSystem aggregate) {
        super(aggregate);
    }

    public ReviewRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
