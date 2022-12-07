package LF8.application.persistence;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class FestivalEntity {
    private Long id;
    private String name;
    private String festivalPlace;
    private String address;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<ShopEntity> shops;

}
