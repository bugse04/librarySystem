package libaraysystem.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import libaraysystem.config.kafka.KafkaProcessor;
import libaraysystem.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookRented_then_CREATE_1(@Payload BookRented bookRented) {
        try {
            if (!bookRented.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setRentId(bookRented.getRentId());
            myPage.setUserId(bookRented.getUserId());
            myPage.setBookId(bookRented.getBookId());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPointIncreased_then_UPDATE_1(
        @Payload PointIncreased pointIncreased
    ) {
        try {
            if (!pointIncreased.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByUserId(
                pointIncreased.getUserId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setPoint(pointIncreased.getPoint());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPointDecreased_then_UPDATE_2(
        @Payload PointDecreased pointDecreased
    ) {
        try {
            if (!pointDecreased.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByUserId(
                pointDecreased.getUserId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setPoint(pointDecreased.getPoint());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
