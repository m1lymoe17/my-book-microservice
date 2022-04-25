package uz.pdp.clients.bookReview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookReview {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private String message;
}
