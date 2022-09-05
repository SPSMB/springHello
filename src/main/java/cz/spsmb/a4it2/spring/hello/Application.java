package cz.spsmb.a4it2.spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Felipe Gutierrez
 *
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService helloWorldMessageService() {
        return new HelloWorldMessage();
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);

        MessageService service = context.getBean(MessageService .class);
        System.out.println(service.getMessage());
    }
}