package libaraysystem.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import libaraysystem.ReviewServiceApplication;
import libaraysystem.domain.ReviewRegistered;
import lombok.Data;

@Entity
@Table(name = "ReviewSystem_table")
@Data
//<<< DDD / Aggregate Root
public class ReviewSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;

    private String reviewConts;

    private Date createDate;

    private String userId;

    @PostPersist
    public void onPostPersist() {
        ReviewRegistered reviewRegistered = new ReviewRegistered(this);
        reviewRegistered.publishAfterCommit();
    }

    public static ReviewSystemRepository repository() {
        ReviewSystemRepository reviewSystemRepository = ReviewServiceApplication.applicationContext.getBean(
            ReviewSystemRepository.class
        );
        return reviewSystemRepository;
    }
}
//>>> DDD / Aggregate Root
