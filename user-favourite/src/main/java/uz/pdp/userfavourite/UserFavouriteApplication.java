package uz.pdp.userfavourite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = "uz.pdp.clients")
public class UserFavouriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserFavouriteApplication.class, args);
    }

}
