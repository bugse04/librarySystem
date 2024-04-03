package libaraysystem.domain;

import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class ReviewRegistered extends AbstractEvent {

    private Long reviewId;
    private String reviewConts;
    private Date createDate;
    private String userId;
}
