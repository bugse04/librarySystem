package libaraysystem.domain;

import java.time.LocalDate;
import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookStockIncreased extends AbstractEvent {

    private Long bookId;
    private Integer bookStock;

    public BookStockIncreased(BookSystem aggregate) {
        super(aggregate);
    }

    public BookStockIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
