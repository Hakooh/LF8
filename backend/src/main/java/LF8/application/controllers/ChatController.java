package LF8.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rivescript.RiveScript;

@CrossOrigin(origins = "localhost:3000")
@RestController
@RequestMapping("/api/chat")
public class ChatController {
    
    @Autowired
    RiveScript riveScript;

    @GetMapping("/message/{message}")
    public String getReply(@PathVariable String message) {
        return riveScript.reply("test", message);
    }

}