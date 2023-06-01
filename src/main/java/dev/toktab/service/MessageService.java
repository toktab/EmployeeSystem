package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.Message;
import dev.toktab.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IService<Message>{
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> get() {
        return messageRepository.findAll();
    }

    @Override
    public Message create(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public ResponseEntity<Message> get(long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceException("Message Not Found With the following ID -> " + id));
        return ResponseEntity.ok(message);
    }

    @Override
    public ResponseEntity<Message> update(long id, Message details) {
        Message updateMessage = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceException("Message Not Found With the following ID -> " + id));
        updateMessage.setMessage(details.getMessage());
        updateMessage.setFromUser(details.getFromUser());
        updateMessage.setToUser(details.getToUser());

        messageRepository.save(updateMessage);

        return ResponseEntity.ok(updateMessage);
    }

    @Override
    public boolean delete(long id) {
        Message deleteMessage = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceException("Message Not Found With the following ID -> " + id));
        messageRepository.delete(deleteMessage);

        return true;
    }
}
