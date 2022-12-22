package LF8.application.controllers;

import LF8.application.persistence.UserEntity;
import LF8.application.persistence.UserEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserEntityRepository userEntityRepository;

    public UserController(UserEntityRepository userEntityRepository) {this.userEntityRepository = userEntityRepository;}

    @GetMapping("/all")
    public List<UserEntity> findAllUser() {
        return userEntityRepository.findAll();
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteUser(@PathVariable Long id) {userEntityRepository.deleteById(id);}

    @PostMapping()
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        Optional<UserEntity> existingUser = userEntityRepository
                .findByFirstNameAndLastName(userEntity.getFirstName(), userEntity.getLastName());
        if (existingUser.isEmpty()) {
            return userEntityRepository.save(userEntity);
        } else {
            return existingUser.get();
        }
    }

    public UserEntity findByeMail(String eMail) {
        return userEntityRepository.findByeMail(eMail).get();
    }

}
