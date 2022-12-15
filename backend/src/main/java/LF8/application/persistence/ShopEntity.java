package LF8.application.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "SHOP")
public class ShopEntity {

    private static final String GENERATOR = "shopEntity_id.generator";

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = "shopEntity_seq", allocationSize = 1)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="business_type")
    private String type;

    @OneToMany(mappedBy = "shop")
    private Set<RatingEntity> ratings;

    @ManyToMany
    @JoinTable(name = "festival_shop",
            joinColumns = @JoinColumn(name="shop_id"),
            inverseJoinColumns = @JoinColumn(name = "festival_id")
    )
    private Set<FestivalEntity> festivals;


}
