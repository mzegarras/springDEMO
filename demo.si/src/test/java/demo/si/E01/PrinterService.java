package demo.si.E01;

import org.springframework.stereotype.Component;

@Component
public class PrinterService {
 
    // if only one method is present in the class the @ServiceActivator is not necessary
    // in alternative the method has to be explicitly declared in the configuration
 
    
    public void printValue(String value){
        System.out.println(value.toUpperCase());
    }
}