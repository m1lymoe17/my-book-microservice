package uz.pdp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookStarDto {
    private Integer id;
    private Integer bookId;
    private Integer stars;
    private Integer userId;
}
