package LF8.application.controllers;

import LF8.application.persistence.UserEntity;
import LF8.application.persistence.UserEntityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserEntityRepository userEntityRepository;

    public UserController(UserEntityRepository userEntityRepository) {this.userEntityRepository = userEntityRepository;}

    @GetMapping("/all")
    public List<UserEntity> findAllUser() {
        return this.userEntityRepository.findAll();
    }
}
