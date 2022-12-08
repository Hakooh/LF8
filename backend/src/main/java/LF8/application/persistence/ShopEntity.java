package LF8.application.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ShopEntity {
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @OneToMany
    private Set<RatingEntity> ratings;
}
