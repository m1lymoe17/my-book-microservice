package uz.pdp.emailsender.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookReview {
    private Integer userId;
    private Integer bookId;
    private String message;
}
