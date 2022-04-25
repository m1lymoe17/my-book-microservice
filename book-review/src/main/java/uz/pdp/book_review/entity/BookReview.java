package uz.pdp.book_review.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.book_review.entity.template.AbsEntity;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "book_review")
public class BookReview extends AbsEntity {
    private Integer userId;
    private Integer bookId;
    private String message;
}
