package javaMailDemo;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;

@org.springframework.context.annotation.Configuration
@ComponentScan
public class Configuration {
	   @Bean
	    public JavaMailSender getMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	 
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
	        mailSender.setUsername("your-email");
	        mailSender.setPassword("your-password");
	 
	        Properties javaMailProperties = new Properties();
	        javaMailProperties.put("mail.smtp.starttls.enable", "true");
	        javaMailProperties.put("mail.smtp.auth", "true");
	        javaMailProperties.put("mail.transport.protocol", "smtp");
	        javaMailProperties.put("mail.debug", "true");
	 
	        mailSender.setJavaMailProperties(javaMailProperties);
	        return mailSender;
	    }
	 
	    @Bean
	    public VelocityEngine getVelocityEngine() throws VelocityException, IOException {
	        VelocityEngineFactory velocityEngineFactory = new VelocityEngineFactory();
	        Properties props = new Properties();
	        props.put("resource.loader", "class");
	        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	 
	        velocityEngineFactory.setVelocityProperties(props);
	        return velocityEngineFactory.createVelocityEngine();
	    }
}
