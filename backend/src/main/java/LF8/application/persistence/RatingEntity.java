package LF8.application.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "RATING")
public class RatingEntity {

    private static final String GENERATOR = "ratingEntity_id.generator";

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = "ratingEntity_seq", allocationSize = 1)
    private Long id;

    @Column(name="commentary")
    private String comment;

    @Column(name="score")
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Temporal(TemporalType.DATE)
    @Column(name="date_of_comment")
    private LocalDate commentDate;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;
}
