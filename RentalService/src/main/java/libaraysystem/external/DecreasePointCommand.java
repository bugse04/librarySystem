package libaraysystem.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class DecreasePointCommand {

    @Id
    private String userId;
}
