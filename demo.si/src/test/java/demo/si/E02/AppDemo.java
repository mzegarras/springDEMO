package demo.si.E02;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.support.channel.BeanFactoryChannelResolver;
import org.springframework.integration.support.channel.ChannelResolver;

public class AppDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
        ClassPathXmlApplicationContext context =
    			new ClassPathXmlApplicationContext("classpath:**/e02-spring-config.xml");
        
    		ChannelResolver channelResolver = new BeanFactoryChannelResolver(context);

    		// Compose the XML message according to the server's schema
    		String requestXml =
    				"<FahrenheitToCelsius xmlns=\"http://www.w3schools.com/webservices/\">" +
    				"    <Fahrenheit>90.0</Fahrenheit>" +
    				"</FahrenheitToCelsius>";

    		// Create the Message object
    		Message<String> message = MessageBuilder.withPayload(requestXml).build();

    		// Send the Message to the handler's input channel
    		MessageChannel channel = channelResolver.resolveChannelName("fahrenheitChannel");
    		channel.send(message);
        
	}

	
}
