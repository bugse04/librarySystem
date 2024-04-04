package libaraysystem.domain;

import java.time.LocalDate;
import java.util.*;
import libaraysystem.infra.AbstractEvent;
import lombok.Data;

@Data
public class PointDecreased extends AbstractEvent {

    private String userId;
    private Integer point;
}
