package LF8.application.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name ="FESTIVAL")
public class FestivalEntity {

    private static final String GENERATOR = "festivalEntity_id.generator";

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR)
    @SequenceGenerator(name = GENERATOR, sequenceName = "festivalEntity_seq", allocationSize = 1)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="place")
    private String festivalPlace;

    @Column(name="address")
    private String address;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="start_date")
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Column(name="end_date")
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @ManyToMany(mappedBy = "festivals")
    private Set<ShopEntity> shops;

}
