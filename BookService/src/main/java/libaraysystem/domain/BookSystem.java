package libaraysystem.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import libaraysystem.BookServiceApplication;
import libaraysystem.domain.BookStockDecreased;
import libaraysystem.domain.BookStockIncreased;
import libaraysystem.domain.OutOfBookStock;
import lombok.Data;

@Entity
@Table(name = "BookSystem_table")
@Data
//<<< DDD / Aggregate Root
public class BookSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private Integer bookStock;

    private String bookTitle;

    private String bookWriter;

    @PostUpdate
    public void onPostUpdate() {
        BookStockDecreased bookStockDecreased = new BookStockDecreased(this);
        bookStockDecreased.publishAfterCommit();

        BookStockIncreased bookStockIncreased = new BookStockIncreased(this);
        bookStockIncreased.publishAfterCommit();

        OutOfBookStock outOfBookStock = new OutOfBookStock(this);
        outOfBookStock.publishAfterCommit();
    }

    public static BookSystemRepository repository() {
        BookSystemRepository bookSystemRepository = BookServiceApplication.applicationContext.getBean(
            BookSystemRepository.class
        );
        return bookSystemRepository;
    }

    //<<< Clean Arch / Port Method
    public static void increaseBookStock(BookReturned bookReturned) {
        //implement business logic here:

        /** Example 1:  new item 
        BookSystem bookSystem = new BookSystem();
        repository().save(bookSystem);

        BookStockIncreased bookStockIncreased = new BookStockIncreased(bookSystem);
        bookStockIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(bookReturned.get???()).ifPresent(bookSystem->{
            
            bookSystem // do something
            repository().save(bookSystem);

            BookStockIncreased bookStockIncreased = new BookStockIncreased(bookSystem);
            bookStockIncreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void decreaseBookStock(PointDecreased pointDecreased) {
        //implement business logic here:

        /** Example 1:  new item 
        BookSystem bookSystem = new BookSystem();
        repository().save(bookSystem);

        BookStockDecreased bookStockDecreased = new BookStockDecreased(bookSystem);
        bookStockDecreased.publishAfterCommit();
        OutOfBookStock outOfBookStock = new OutOfBookStock(bookSystem);
        outOfBookStock.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(pointDecreased.get???()).ifPresent(bookSystem->{
            
            bookSystem // do something
            repository().save(bookSystem);

            BookStockDecreased bookStockDecreased = new BookStockDecreased(bookSystem);
            bookStockDecreased.publishAfterCommit();
            OutOfBookStock outOfBookStock = new OutOfBookStock(bookSystem);
            outOfBookStock.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
