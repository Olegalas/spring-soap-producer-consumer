package com.dexter.spring.soap.consumer;


import com.dexter.spring.soap.consumer.model.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

    @Bean
    CommandLineRunner lookup(final CountryConsumer countryConsumer) {
        return args -> {
            String countryName = "Spain";

            if (args.length > 0) {
                countryName = args[0];
            }
            GetCountryResponse response = countryConsumer.getCountry(countryName);
            log.info("Was received next country : {}", response);
        };
    }
}
