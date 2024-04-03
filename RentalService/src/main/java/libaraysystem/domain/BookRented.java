package libaraysystem.domain;

import java.time.LocalDate;
import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookRented extends AbstractEvent {

    private Long rentId;
    private String userId;
    private Long bookId;
    private String bookTitle;

    public BookRented(RentalSystem aggregate) {
        super(aggregate);
    }

    public BookRented() {
        super();
    }
}
//>>> DDD / Domain Event
