package uz.pdp.clients.book;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.print.Book;

@FeignClient(name = "book")
public interface BookClient {
    @PostMapping("/api/book")
    Book save(@RequestBody BookDto bookDto);
}
