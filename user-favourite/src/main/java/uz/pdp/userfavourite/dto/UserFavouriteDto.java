package uz.pdp.userfavourite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFavouriteDto {
    private Integer id;
    private Integer userId;
    private Integer bookId;
}
