package uz.pdp.clients.author;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "author")
public interface AuthorClient {

}
