package by.mopahta.recklesstelephone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "by.mopahta.recklesstelephone")
public class RecklessTelephoneApplication {

    public static void main (String[] args) {
        SpringApplication.run(RecklessTelephoneApplication.class, args);
    }

}
