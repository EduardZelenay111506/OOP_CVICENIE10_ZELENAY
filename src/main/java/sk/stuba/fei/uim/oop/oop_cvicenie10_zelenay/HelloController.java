package sk.stuba.fei.uim.oop.oop_cvicenie10_zelenay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private IGreetingsService service;

    private int counter=0;

    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("/helloObject")
    public HelloResponse helloObject(){
        return new HelloResponse(counter++,"hello world");
    }

    @GetMapping("/path/{name}")
    public String helloPath(@PathVariable("name") String name){
        return "hello "+ name;
    }

    @GetMapping("/param")
    public String helloParam(@RequestParam(name = "name",defaultValue = "world") String name){
        return "hello "+ name;
    }
    @GetMapping("/body")
    public String body(@RequestBody HelloRequestBody body) {
        return service.createResponse(body);
    }

    @GetMapping("/responseEntity")
    public ResponseEntity<HelloResponse> helloResponse(){
        return new ResponseEntity<>(new HelloResponse(counter++,"hello world"), HttpStatus.OK);
    }
}
