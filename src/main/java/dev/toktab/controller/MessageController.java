package dev.toktab.controller;

import dev.toktab.model.Message;
import dev.toktab.model.User;
import dev.toktab.repository.MessageRepository;
import dev.toktab.repository.UserRepository;
import dev.toktab.service.MessageService;
import dev.toktab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageRepository messageRepository;
    @Autowired
    MessageService messageService;

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

    @PutMapping("/update")
    public ResponseEntity<Message> updateMessage(@RequestBody Message messageDetails) {
        return messageService.update(messageDetails);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteMessage(@PathVariable long id) {
        return messageService.delete(id);
    }
}
