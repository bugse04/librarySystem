package libaraysystem.domain;

import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class PointDecreased extends AbstractEvent {

    private Long id;
    private Integer point;
    private String userId;
}
