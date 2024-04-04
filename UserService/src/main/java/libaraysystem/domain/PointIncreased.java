package libaraysystem.domain;

import java.time.LocalDate;
import java.util.*;
import libaraysystem.infra.AbstractEvent;
import lombok.Data;

@Data
public class PointIncreased extends AbstractEvent {

    private String userId;
    private Integer point;
    private Long rentId;
    private Long bookId;
}
