package LF8.application.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import LF8.application.payload.request.LoginRequest;
import LF8.application.payload.request.SignupRequest;
import LF8.application.payload.response.JwtResponse;
import LF8.application.persistence.UserEntity;
import LF8.application.persistence.UserEntityRepository;
import LF8.application.security.jwt.JwtUtils;

@CrossOrigin(origins = "localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {
        if (!userEntityRepository.existsByeMail(loginRequest.getEMail())) {
            return new ResponseEntity<String>("No account with this email exists.",
                    HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEMail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Validated @RequestBody SignupRequest signUpRequest) {
        if (userEntityRepository.existsByeMail(signUpRequest.getEMail())) {
            return new ResponseEntity<String>("Email is already in use.",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        UserEntity userEntity = UserEntity.builder().firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .dayOfBirth(signUpRequest.getDateOfBirth())
                .gender(signUpRequest.getGender())
                .eMail(signUpRequest.getEMail())
                .password(encoder.encode(signUpRequest.getPassword())).build();


        userEntityRepository.save(userEntity);

        return ResponseEntity.ok().body("User registered successfully!");
    }
}
