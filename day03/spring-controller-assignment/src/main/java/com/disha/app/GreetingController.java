package com.disha.app;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/greet")
    public String Greet() {
        return "Greet from App";
    }

    @GetMapping("/welcome")
    public String Welcome(){
        return "Welcome from App";

    }
    @GetMapping("/hi")
    public String Hi(){
        return "Hi from App";

    }
    @GetMapping("/thanks")
    public String Thanks(){
        return "Thanks from App";

    }

}
