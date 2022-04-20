package sk.stuba.fei.uim.oop.oop_cvicenie10_zelenay;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private int counter=0;


    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("/helloObject")
    public HelloResponse helloObject(){
        return new HelloResponse(counter++,"hello world");
    }
}
