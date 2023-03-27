package LF8.application.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/chat")
@Log4j2
public class ChatController {

    @Autowired
    RiveScript riveScript;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserEntityRepository entityRepository;

    @GetMapping("/send")
    public String getReply(@RequestParam String text, @RequestHeader(value = "Authorization", required = false )  String token) {
        String username = getBotUser(token);
        try {
            text = URLEncoder.encode(text.toLowerCase(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("Error encoding incoming string: ", e.getMessage());
            return "";
        }
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
        } catch (Exception e) {
            log.info("Anonymous user is now using chat");
            return "anonymous";
        }
    }
}