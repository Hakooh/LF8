package LF8.application.controllers;

import LF8.application.persistence.RatingEntity;
import LF8.application.persistence.RatingEntityRepository;
import LF8.application.persistence.UserEntity;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
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

    @Timed(value = "deleteShop.rating", description = "Time taken to delete a rating.")
    @DeleteMapping("/delete/id/{id}")
    public void deleteRating(@PathVariable Long id) {
        ratingEntityRepository.deleteById(id);
    }

    @PostMapping("/post")
    public RatingEntity addRating(@RequestBody RatingEntity ratingEntity) {
        return ratingEntityRepository.save(ratingEntity);
    }
}
