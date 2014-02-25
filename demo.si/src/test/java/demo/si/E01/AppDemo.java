package demo.si.E01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class AppDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		// load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/e01-spring-config.xml");
 
        // get the reference to the message channel
        MessageChannel channel = context.getBean("inputChannel", MessageChannel.class);
 
        // create a message with the content "World"
        Message<String> message = MessageBuilder.withPayload("World").build();
 
        // send the message to the inputChannel
        channel.send(message);
        
	}

}
