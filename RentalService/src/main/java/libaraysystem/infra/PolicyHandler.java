package libaraysystem.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import libaraysystem.config.kafka.KafkaProcessor;
import libaraysystem.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RentalSystemRepository rentalSystemRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OutOfBookStock'"
    )
    public void wheneverOutOfBookStock_RentalCanceled(
        @Payload OutOfBookStock outOfBookStock
    ) {
        OutOfBookStock event = outOfBookStock;
        System.out.println(
            "\n\n##### listener RentalCanceled : " + outOfBookStock + "\n\n"
        );

        // Sample Logic //
        RentalSystem.rentalCanceled(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
