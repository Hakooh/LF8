package LF8.application.controllers;

import LF8.application.persistence.RatingEntity;
import LF8.application.persistence.RatingEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "localhost:3000")
@RestController
@RequestMapping("/api/rating")
public class RatingController {

    private final RatingEntityRepository ratingEntityRepository;


    public RatingController(RatingEntityRepository ratingEntityRepository) {
        this.ratingEntityRepository = ratingEntityRepository;
    }

    @GetMapping("/all")
    public List<RatingEntity> findAllRatings() {
        return ratingEntityRepository.findAll();
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteRating(@PathVariable Long id) {
        ratingEntityRepository.deleteById(id);
    }
}
