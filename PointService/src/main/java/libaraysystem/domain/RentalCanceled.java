package libaraysystem.domain;

import java.util.*;
import libaraysystem.domain.*;
import libaraysystem.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class RentalCanceled extends AbstractEvent {

    private String userId;
}
