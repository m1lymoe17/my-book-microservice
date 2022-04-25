package uz.pdp.emailsender.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookReview {
    private Integer userId;
    private String bookId;
    private String message;
}
