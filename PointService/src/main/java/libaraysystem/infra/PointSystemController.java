package libaraysystem.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import libaraysystem.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/pointSystems")
@Transactional
public class PointSystemController {

    @Autowired
    PointSystemRepository pointSystemRepository;

    @RequestMapping(
        value = "pointSystems/{id}/decreasepoint",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public PointSystem decreasePoint(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /pointSystem/decreasePoint  called #####");
        Optional<PointSystem> optionalPointSystem = pointSystemRepository.findById(
            id
        );

        optionalPointSystem.orElseThrow(() -> new Exception("No Entity Found"));
        PointSystem pointSystem = optionalPointSystem.get();
        pointSystem.decreasePoint();

        pointSystemRepository.save(pointSystem);
        return pointSystem;
    }
}
//>>> Clean Arch / Inbound Adaptor
