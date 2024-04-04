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
// @RequestMapping(value="/rentalSystems")
@Transactional
public class RentalSystemController {

    @Autowired
    RentalSystemRepository rentalSystemRepository;

    @RequestMapping(
        value = "rentalSystems/",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public RentalSystem rentBook(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RentalSystem rentalSystem
    ) throws Exception {
        System.out.println("##### /rentalSystem/rentBook  called #####");
        rentalSystem.rentBook(rentBookcommand);
        rentalSystemRepository.save(rentalSystem);
        return rentalSystem;
    }

    @RequestMapping(
        value = "rentalSystems/",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public RentalSystem returnBook(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RentalSystem rentalSystem
    ) throws Exception {
        System.out.println("##### /rentalSystem/returnBook  called #####");
        rentalSystem.returnBook(returnBookcommand);
        rentalSystemRepository.save(rentalSystem);
        return rentalSystem;
    }
}
//>>> Clean Arch / Inbound Adaptor
