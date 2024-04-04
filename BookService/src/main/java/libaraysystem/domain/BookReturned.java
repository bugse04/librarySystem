package libaraysystem.domain;

import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class BookReturned extends AbstractEvent {

    private Long rentId;
    private String userId;
    private Long bookId;
    private String bookTitle;
}
