package libaraysystem.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import libaraysystem.PointServiceApplication;
import libaraysystem.domain.PointIncreased;
import lombok.Data;

@Entity
@Table(name = "PointSystem_table")
@Data
//<<< DDD / Aggregate Root
public class PointSystem {

    private Integer point;

    @Id
    private String userId;

    private String bookId;

    @PostUpdate
    public void onPostUpdate() {
        PointIncreased pointIncreased = new PointIncreased(this);
        pointIncreased.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static PointSystemRepository repository() {
        PointSystemRepository pointSystemRepository = PointServiceApplication.applicationContext.getBean(
            PointSystemRepository.class
        );
        return pointSystemRepository;
    }

    //<<< Clean Arch / Port Method
    public void decreasePoint(DecreasePointCommand decreasePointCommand) {
        //implement business logic here:

        PointDecreased pointDecreased = new PointDecreased(this);
        pointDecreased.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void increasePoint(ReviewRegistered reviewRegistered) {
        //implement business logic here:

        /** Example 1:  new item 
        PointSystem pointSystem = new PointSystem();
        repository().save(pointSystem);

        PointIncreased pointIncreased = new PointIncreased(pointSystem);
        pointIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reviewRegistered.get???()).ifPresent(pointSystem->{
            
            pointSystem // do something
            repository().save(pointSystem);

            PointIncreased pointIncreased = new PointIncreased(pointSystem);
            pointIncreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increasePoint(RentalCanceled rentalCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        PointSystem pointSystem = new PointSystem();
        repository().save(pointSystem);

        PointIncreased pointIncreased = new PointIncreased(pointSystem);
        pointIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(rentalCanceled.get???()).ifPresent(pointSystem->{
            
            pointSystem // do something
            repository().save(pointSystem);

            PointIncreased pointIncreased = new PointIncreased(pointSystem);
            pointIncreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
