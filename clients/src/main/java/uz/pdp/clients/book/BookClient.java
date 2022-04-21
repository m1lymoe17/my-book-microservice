package uz.pdp.clients.book;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "book")
public interface BookClient {
}
