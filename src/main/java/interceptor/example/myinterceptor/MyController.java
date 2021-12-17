package interceptor.example.myinterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MyController {
    private final Logger log = LoggerFactory.getLogger(MyController.class);


    @GetMapping({"/get"})
    public String  example() {
        System.out.println();
        System.out.println();
        log.info("Test Log4j with MDC");
        return "response sent successfully";
    }

}
