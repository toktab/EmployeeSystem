package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.Funding;
import dev.toktab.model.User;
import dev.toktab.repository.FundingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundingService implements IService<Funding>{
    @Autowired
    private FundingRepository fundingRepository;

    @Override
    public List<Funding> get() {
        return fundingRepository.findAll();
    }

    @Override
    public Funding create(Funding funding) {
        return fundingRepository.save(funding);
    }

    @Override
    public ResponseEntity<Funding> get(long id) {
        Funding funding = userRepository.findById(id)
                .orElseThrow(() -> new ResourceException("User Not Found With the following ID -> " + id));
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<Funding> update(long id, Funding details) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
