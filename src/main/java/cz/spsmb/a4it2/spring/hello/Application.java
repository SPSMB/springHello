package cz.spsmb.a4it2.spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Felipe Gutierrez
 * Spring framework je založen na jednoduchém principu: Injekce závislostí Jedná se o návrhový vzor,
 * který funguje na základě návrhu rozhraní a injektáží přes settery, či konstruktory všech závislostí
 * a implemantací, které spolupracují a intaragují napříč třídami.
 *
 * Výhodou tohoto přístupu je, že pokud změníme implementaci, uděláme to pouze v jedné třídě a ostatní
 * zůstane nedotčeno. Takto je umožňeno vytvářet robustní a do budoucna rozšiřitelnou aplikaci.
 *
 */
@Configuration
@ComponentScan
public class Application {

    // Touto anotací říkáme kontejneru Springu. že třída HelloWorldMessage bude použita později v
    // nějakém bodě.
    @Bean
    MessageService helloWorldMessageService() {
        return new HelloWorldMessage();
    }

    public static void main(String[] args) {
        // Třída ApplicationContext slouží k vytvoření Spring kontejneru. Pomocí této třídy s pomocí
        // dalších anotací (@Configuration, @ComponentScan, @Bean) vytvoříme kontrejner a pospojujeme
        // vše tak, že metoda getBean Spring kontejneru ví, krerý objekt se má použít.
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);

        MessageService service = context.getBean(MessageService .class);
        System.out.println(service.getMessage());
    }
}
