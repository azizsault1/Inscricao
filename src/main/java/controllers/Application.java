package controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "controllers", "servicos" })
public class Application {

   public static void main(final String[] args) {
      SpringApplication.run(Application.class, args);
   }

}
