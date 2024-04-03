package libaraysystem.domain;

import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class OutOfBookStock extends AbstractEvent {

    private Long bookId;
    private Integer bookStock;
    private Long rentId;
}
