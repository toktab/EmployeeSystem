package dev.toktab;

import dev.toktab.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class Main {
    static JpaRepository<Message, Long> repository;
    public static void main(String[] args) {
        repository.findAll().get(1).getFromUser();
    }
    public static List<Message> get() {
        return repository.findAll();
    }
}
