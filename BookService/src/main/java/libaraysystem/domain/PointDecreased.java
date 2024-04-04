package libaraysystem.domain;

import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class PointDecreased extends AbstractEvent {

    private String userId;
    private Integer point;
    private Long bookId;
    private Long rentId;
}
