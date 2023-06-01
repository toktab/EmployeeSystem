package dev.toktab.controller;

import dev.toktab.model.Message;
import dev.toktab.model.User;
import dev.toktab.repository.MessageRepository;
import dev.toktab.repository.UserRepository;
import dev.toktab.service.MessageService;
import dev.toktab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;
    MessageService messageService = new MessageService();

    @GetMapping("/get")
    public List<Message> getAllMessages() {
        return messageService.get();
    }

    @PostMapping()
    public Message createMessage(@RequestBody Message message) {
        return messageService.create(message);
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getMessageId(@PathVariable long id) {
        return messageService.get(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable long id, @RequestBody Message messageDetails) {
        return messageService.update(id, messageDetails);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteMessage(@PathVariable long id) {
        return messageService.delete(id);
    }
}
