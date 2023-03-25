package LF8.application.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rivescript.RiveScript;

import LF8.application.persistence.UserEntity;
import LF8.application.persistence.UserEntityRepository;
import LF8.application.security.jwt.JwtUtils;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    RiveScript riveScript;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserEntityRepository entityRepository;

    @GetMapping("/send")
    public String getReply(@RequestParam String text, @RequestHeader("Authorization") String token) {
        String username = getBotUser(token);
        return riveScript.reply(username, text);
    }

    private String getBotUser(String token) {
        try {
            String email = jwtUtils.getEMailFromJwtToken(token.replace("Bearer ", ""));
            if (riveScript.getUservars(email) == null) {
                UserEntity user = entityRepository.findByeMail(email).get();
                riveScript.setUservar(email, "firstname", user.getFirstName());
                riveScript.setUservar(email, "lastname", user.getLastName());
            }
            return email;
        } catch (NoSuchElementException e) {
            return "anonymous";
        }
    }
}