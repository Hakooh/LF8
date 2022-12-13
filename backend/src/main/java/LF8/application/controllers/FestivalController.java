package LF8.application.controllers;

import LF8.application.persistence.FestivalEntity;
import LF8.application.persistence.FestivalEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/festival")
public class FestivalController {

    private final FestivalEntityRepository festivalEntityRepository;

    public FestivalController(FestivalEntityRepository festivalEntityRepository) {
        this.festivalEntityRepository = festivalEntityRepository;
    }

    @GetMapping("/all")
    public List<FestivalEntity> findAllFestivals() {
        return festivalEntityRepository.findAll();
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteFestival(@PathVariable Long id) {
        festivalEntityRepository.deleteById(id);
    }

}
