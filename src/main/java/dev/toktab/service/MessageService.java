package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.Message;
import dev.toktab.model.User;
import dev.toktab.repository.FundingRepository;
import dev.toktab.repository.MessageRepository;
import dev.toktab.repository.UserRepository;
import dev.toktab.service.interfaces.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MessageService extends BaseService<Message> implements IMessageService {

    private MessageRepository messageRepository;
    private final UserService userService = new UserService();
    private final List<Message> allMessages =  get();

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository){
        super.setRepository(messageRepository);
        this.messageRepository = messageRepository;
    }

    @Override
    public boolean send(long from, long to, String msg) {
        var newMessage = new Message();

        User fromUser = userService.get(from).getBody();
        User toUser = userService.get(to).getBody();

        newMessage.setFromUser(fromUser);
        newMessage.setToUser(toUser);
        newMessage.setMessage(msg);

        messageRepository.save(newMessage);
        return true;
    }

    @Override
    public List<Message> receivedFrom(long fromUser, long toUser) {
        List<Message> messageList = new ArrayList<>();
        for (Message allMessage : allMessages) {
            if (allMessage.getFromUser().getId() == fromUser &&
                    allMessage.getToUser().getId() == toUser) {
                messageList.add(allMessage);
            }
        }
        return messageList;

//        return null;
    }

    @Override
    public List<Message> received(long to) {
        List<Message> messageList = new ArrayList<>();
        for (Message allMessage : allMessages) {
            if (allMessage.getToUser().getId() == to) {
                messageList.add(allMessage);
            }
        }
        return messageList;

//        return null;
    }
}
