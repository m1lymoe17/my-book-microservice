package uz.pdp.userfavourite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.userfavourite.entity.template.AbsEntity;

import javax.persistence.Entity;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "user_favourites")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFavourite extends AbsEntity {
    private Integer userId;
    private Integer bookId;
}
