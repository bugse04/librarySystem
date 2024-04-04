package libaraysystem.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import libaraysystem.RentalServiceApplication;
import libaraysystem.domain.RentalCanceled;
import lombok.Data;

@Entity
@Table(name = "RentalSystem_table")
@Data
//<<< DDD / Aggregate Root
public class RentalSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rentId;

    private String userId;

    private Long bookId;

    private String bookTitle;

    @PostPersist
    public void onPostPersist() {
        RentalCanceled rentalCanceled = new RentalCanceled(this);
        rentalCanceled.publishAfterCommit();
    }

    public static RentalSystemRepository repository() {
        RentalSystemRepository rentalSystemRepository = RentalServiceApplication.applicationContext.getBean(
            RentalSystemRepository.class
        );
        return rentalSystemRepository;
    }

    //<<< Clean Arch / Port Method
    public void rentBook(RentBookCommand rentBookCommand) {
        //implement business logic here:

        BookRented bookRented = new BookRented(this);
        bookRented.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        libaraysystem.external.PointSystem pointSystem = new libaraysystem.external.PointSystem();
        // mappings goes here
        RentalServiceApplication.applicationContext
            .getBean(libaraysystem.external.PointSystemService.class)
            .decreasePoint(pointSystem);
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void returnBook(ReturnBookCommand returnBookCommand) {
        //implement business logic here:

        BookReturned bookReturned = new BookReturned(this);
        bookReturned.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void rentalCanceled(OutOfBookStock outOfBookStock) {
        //implement business logic here:

        /** Example 1:  new item 
        RentalSystem rentalSystem = new RentalSystem();
        repository().save(rentalSystem);

        */

        /** Example 2:  finding and process
        
        repository().findById(outOfBookStock.get???()).ifPresent(rentalSystem->{
            
            rentalSystem // do something
            repository().save(rentalSystem);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
