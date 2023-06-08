package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.Message;
import dev.toktab.repository.MessageRepository;
import dev.toktab.service.interfaces.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService extends BaseService<Message> implements IMessageService {

    public MessageService(MessageRepository messageRepository) {
        super(messageRepository);
        this.messageRepository = messageRepository;
    }

    @Autowired
    private MessageRepository messageRepository;
}
