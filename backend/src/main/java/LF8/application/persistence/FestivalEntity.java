package LF8.application.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FestivalEntity {
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String festivalPlace;

    @Column
    private String address;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @OneToMany
    private Set<ShopEntity> shops;

}
