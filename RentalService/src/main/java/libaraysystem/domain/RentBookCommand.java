package libaraysystem.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RentBookCommand {

    private String userId;
    private Long bookId;
}
