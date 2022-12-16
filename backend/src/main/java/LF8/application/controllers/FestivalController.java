package LF8.application.controllers;

import LF8.application.persistence.FestivalEntity;
import LF8.application.persistence.FestivalEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "localhost:3000")
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

    @GetMapping("/id/{id}")
    public FestivalEntity findFestivalById(@PathVariable Long id) {
        Optional<FestivalEntity> festivalEntityOptional = festivalEntityRepository.findById(id);
        if (festivalEntityOptional.isEmpty()) {
            return null;
        } else {
            return festivalEntityOptional.get();
        }
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteFestival(@PathVariable Long id) {
        festivalEntityRepository.deleteById(id);
    }

}
