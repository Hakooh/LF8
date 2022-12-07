package LF8.application.persistence;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ShopEntity {
    private Long id;
    private String name;
    private String type;
    private Set<RatingEntity> ratings;
}
