package uz.pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "book_stars")
public class BookStar extends AbsEntity {
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private Integer userId;

    private Integer stars;
}
