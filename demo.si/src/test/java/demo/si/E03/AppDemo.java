package demo.si.E03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.message.GenericMessage;

public class AppDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new ClassPathXmlApplicationContext("classpath:**/e03-spring-config_delay.xml");
		
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:**/e03-spring-config.xml");
		MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
		PollableChannel outputChannel = context.getBean("outputChannel", PollableChannel.class);
		inputChannel.send(new GenericMessage<String>("World"));
		System.out.println("==> HelloWorldDemo: " + outputChannel.receive(0).getPayload());
		
		
	}

}
