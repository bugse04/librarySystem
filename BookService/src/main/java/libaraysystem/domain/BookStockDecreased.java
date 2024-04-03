package libaraysystem.domain;

import java.time.LocalDate;
import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookStockDecreased extends AbstractEvent {

    private Long bookId;
    private Integer bookStock;

    public BookStockDecreased(BookSystem aggregate) {
        super(aggregate);
    }

    public BookStockDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
