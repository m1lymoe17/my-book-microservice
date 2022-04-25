package uz.pdp.clients.bookAndAuthor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookStar {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer stars;
}
