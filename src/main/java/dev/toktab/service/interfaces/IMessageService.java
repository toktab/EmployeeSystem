package dev.toktab.service.interfaces;

import dev.toktab.model.Message;
import dev.toktab.service.IService;

import java.util.List;

public interface IMessageService extends IService<Message> {
    abstract boolean send(long from, long to, String msg);
    abstract List<Message> receivedFrom(long fromUser, long toUser);
    abstract List<Message> received(long to);
}
