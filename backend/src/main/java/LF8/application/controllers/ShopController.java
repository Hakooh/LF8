package LF8.application.controllers;

import LF8.application.persistence.ShopEntity;
import LF8.application.persistence.ShopEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private final ShopEntityRepository shopEntityRepository;


    public ShopController(ShopEntityRepository shopEntityRepository) {
        this.shopEntityRepository = shopEntityRepository;
    }

    @GetMapping("/all")
    public List<ShopEntity> findAllShops() {
        return shopEntityRepository.findAll();
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteShop(@PathVariable Long id) {
        shopEntityRepository.deleteById(id);
    }
}
