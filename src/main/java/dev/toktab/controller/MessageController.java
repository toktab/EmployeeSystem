package dev.toktab.controller;

import dev.toktab.controller.model.MessageResponse;
import dev.toktab.model.Message;
import dev.toktab.repository.MessageRepository;
import dev.toktab.service.MessageService;
import dev.toktab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageRepository messageRepository;
    @Autowired
    MessageService messageService;
    private final UserService userService;
    private long getCurrentlyLoggedInId(){
        long currentlyLoggedUserId = -1;
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            currentlyLoggedUserId = userService.getUserIdByUsername(username);

        } else {
            String username = principal.toString();
        }
        return currentlyLoggedUserId;
    }

    @GetMapping("/get")//only admin and head-admin
    public List<Message> getAllMessages() {
        return messageService.get();
    }

    @PostMapping()
    public Message createMessage(@RequestBody Message message) {
        return messageService.create(message);
    }

    @GetMapping("{id}")//only admin and head-admin
    public ResponseEntity<Message> getMessageId(@PathVariable long id) {
        return messageService.get(id);
    }

    @PutMapping("/update")//only admin and head-admin
    public ResponseEntity<Message> updateMessage(@RequestBody Message messageDetails) {
        return messageService.update(messageDetails);
    }

    @DeleteMapping("/delete/{id}")//only admin and head-admin
    public boolean deleteMessage(@PathVariable long id) {
        return messageService.delete(id);
    }

    @GetMapping("/send/{to}/{msg}")
    public MessageResponse sendMessage(@PathVariable long to, @PathVariable String msg){
        if(!userService.userExists(to)) return MessageResponse.fail("User with that id don't exist!");
        boolean result = messageService.send(getCurrentlyLoggedInId(),to,msg);
        if(!result) return MessageResponse.fail("Error! Couldn't send due to unknown error");
        return MessageResponse.ok("Successfully sent message from:"+getCurrentlyLoggedInId()+"; to:"+to+"");
    }
//    @GetMapping("/read/all")//get Currently logged in id
//    public List<Message> readAll(){
//        return messageService.received(this.getCurrentlyLoggedInId());
//    }
//    @GetMapping("/read/{from}")
//    public List<Message> readFrom(@PathVariable long from){
//        if(!userService.userExists(from)) return null;
//        return messageService.receivedFrom(from,this.getCurrentlyLoggedInId());
//    }
}
