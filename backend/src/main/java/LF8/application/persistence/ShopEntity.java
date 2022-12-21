package LF8.application.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "SHOPS")
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @OneToMany
    private Set<RatingEntity> ratings;
}
