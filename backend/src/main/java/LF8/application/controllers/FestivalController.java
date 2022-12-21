package LF8.application.controllers;

import LF8.application.persistence.FestivalEntity;
import LF8.application.persistence.FestivalEntityRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/festival")
@CrossOrigin(origins = "http://localhost:3000")
public class FestivalController {

    private final FestivalEntityRepository festivalEntityRepository;

    public FestivalController(FestivalEntityRepository festivalEntityRepository) {
        this.festivalEntityRepository = festivalEntityRepository;
    }

    @Timed(value = "allFestivals.time", description = "Time taken to return all Festivals")
    @Counted(value ="allFestivals.count", description = "How many times All Festivals have been called")
    @GetMapping("/all")
    public List<FestivalEntity> findAllFestivals() {
        return festivalEntityRepository.findAll();
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteFestival(@PathVariable Long id) {
        festivalEntityRepository.deleteById(id);
    }

    @GetMapping("/Id/{id}")
    public Optional<FestivalEntity> findById(@PathVariable Long id) {
        return festivalEntityRepository.findById(id);
    }
}
