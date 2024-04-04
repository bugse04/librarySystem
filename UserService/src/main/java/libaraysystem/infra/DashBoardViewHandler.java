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
public class DashBoardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DashBoardRepository dashBoardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookRented_then_CREATE_1(@Payload BookRented bookRented) {
        try {
            if (!bookRented.validate()) return;

            // view 객체 생성
            DashBoard dashBoard = new DashBoard();
            // view 객체에 이벤트의 Value 를 set 함
            dashBoard.setRentId(bookRented.getRentId());
            dashBoard.setUserId(bookRented.getUserId());
            dashBoard.setBookId(bookRented.getBookId());
            // view 레파지 토리에 save
            dashBoardRepository.save(dashBoard);
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

            List<DashBoard> dashBoardList = dashBoardRepository.findByUserId(
                pointIncreased.getUserId()
            );
            for (DashBoard dashBoard : dashBoardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
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

            List<DashBoard> dashBoardList = dashBoardRepository.findByUserId(
                pointDecreased.getUserId()
            );
            for (DashBoard dashBoard : dashBoardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashBoard.setPoint(pointDecreased.getPoint());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
