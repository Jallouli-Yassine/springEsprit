package tn.esprit.tp1yassinejallouli4twin7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
public class Tp1YassineJallouli4Twin7Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp1YassineJallouli4Twin7Application.class, args);
    }

}
