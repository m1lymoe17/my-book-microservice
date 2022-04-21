package uz.pdp.clients.book;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.print.Book;

@FeignClient(name = "book")
public interface BookClient {
//    @GetMapping("/api/book/{id}")
//    Book getBookById(@PathVariable("id") int id);
}
