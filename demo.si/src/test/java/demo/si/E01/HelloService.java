package demo.si.E01;

import org.springframework.stereotype.Component;

/**
 * This service simply modify the original message and return the new message
 */
@Component
public class HelloService {
 
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}