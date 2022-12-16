package LF8.application.controllers;

import LF8.application.persistence.UserEntity;
import LF8.application.persistence.UserEntityRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserEntityRepository userEntityRepository;

    public UserController(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @GetMapping("/all")
    public List<UserEntity> findAllUser() {
        return userEntityRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public UserEntity findUserById(@PathVariable Long id) {
        Optional<UserEntity> userEntityOptional = userEntityRepository
                .findById(id);
        if (userEntityOptional.isEmpty()) {
            return null;
        } else {
            return userEntityOptional.get();
        }
    }

    @GetMapping("/firstname/{firstName}/lastname/{lastName}")
    public UserEntity findUserByFullName(@PathVariable String firstName, @PathVariable String lastName) {
        Optional<UserEntity> userEntityOptional = userEntityRepository
                .findByFirstNameAndLastName(firstName, lastName);
        if (userEntityOptional.isEmpty()) {
            return null;
        } else {
            return userEntityOptional.get();
        }
    }

    @GetMapping("/email/{eMail}")
    public UserEntity findUserByeMail(@PathVariable String eMail) {
        Optional<UserEntity> userEntityOptional = userEntityRepository
                .findByeMail(eMail);
        if (userEntityOptional.isEmpty()) {
            return null;
        } else {
            return userEntityOptional.get();
        }
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteUser(@PathVariable Long id) {
        userEntityRepository.deleteById(id);
    }

    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        Optional<UserEntity> existingUser = userEntityRepository
                .findByFirstNameAndLastName(userEntity.getFirstName(), userEntity.getLastName());
        if (existingUser.isEmpty()) {
            return userEntityRepository.save(userEntity);
        } else {
            return existingUser.get();
        }

    }
}
