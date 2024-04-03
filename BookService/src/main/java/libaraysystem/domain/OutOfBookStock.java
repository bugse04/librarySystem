package libaraysystem.domain;

import java.time.LocalDate;
import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OutOfBookStock extends AbstractEvent {

    private Long bookId;
    private Integer bookStock;
    private Long rentId;

    public OutOfBookStock(BookSystem aggregate) {
        super(aggregate);
    }

    public OutOfBookStock() {
        super();
    }
}
//>>> DDD / Domain Event
