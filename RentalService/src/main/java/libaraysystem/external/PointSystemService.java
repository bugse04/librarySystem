package libaraysystem.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "PointService", url = "${api.url.PointService}")
public interface PointSystemService {
    @RequestMapping(method= RequestMethod.PUT, path="/pointSystems/{id}/decreasepoint")
    public void decreasePoint(@PathVariable("id")  , @RequestBody DecreasePointCommand decreasePointCommand );
}
