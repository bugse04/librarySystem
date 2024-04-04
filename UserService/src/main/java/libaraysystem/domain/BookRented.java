package libaraysystem.domain;

import java.time.LocalDate;
import java.util.*;
import libaraysystem.infra.AbstractEvent;
import lombok.Data;

@Data
public class BookRented extends AbstractEvent {

    private Long rentId;
    private String userId;
    private Long bookId;
    private String bookTitle;
}
