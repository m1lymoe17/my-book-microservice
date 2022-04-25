package uz.pdp.book_review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = "uz.pdp.clients")
public class BookReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookReviewApplication.class, args);
	}

}
