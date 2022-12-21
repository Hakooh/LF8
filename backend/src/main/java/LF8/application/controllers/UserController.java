package LF8.application.controllers;

import LF8.application.persistence.UserEntity;
import LF8.application.persistence.UserEntityRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserEntityRepository userEntityRepository;

    public UserController(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Timed(value = "findAllUsers.time", description = "Time taken to delete a user.")
    @GetMapping("/all")
    public List<UserEntity> findAllUser() {
        return userEntityRepository.findAll();
    }

    @Timed(value = "deleteUser.time", description = "Time taken to delete a user.")
    @DeleteMapping("/delete/id/{id}")
    public void deleteUser(@PathVariable Long id) {
        userEntityRepository.deleteById(id);
    }

    @Timed(value = "addUser.time", description = "Time taken to create a user.")
    @Counted(value = "addUser.count", description = "How many users registered.")
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

    @Timed(value = "findUserByeMail.time", description = "Time taken to find a user by email.")
    public UserEntity findByeMail(String eMail) {
        return userEntityRepository.findByeMail(eMail).get();
    }

}
