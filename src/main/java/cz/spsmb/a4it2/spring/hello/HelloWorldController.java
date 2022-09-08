package cz.spsmb.a4it2.spring.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Anotace @Controller označuje třídu HelloWorldController jako web controller
// který má @RequestMapping a @ResponseBody
// Takto navržený web server bude naslouchat na http://localhost:8080
@Controller
@EnableAutoConfiguration
public class HelloWorldController {
    @RequestMapping("/")
    @ResponseBody
    String getMessage() {
        return "<h1>Hello World!</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class, args);
    }
}
