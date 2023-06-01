package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.SalaryHistory;
import dev.toktab.model.User;
import dev.toktab.repository.SalaryHistoryRepository;
import dev.toktab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryHistoryService implements IService<SalaryHistory> {
    @Autowired
    private SalaryHistoryRepository salaryHistoryRepository;

    @Override
    public List<SalaryHistory> get() {
        return salaryHistoryRepository.findAll();
    }

    @Override
    public SalaryHistory create(SalaryHistory salaryHistory) {
        return salaryHistoryRepository.save(salaryHistory);
    }

    @Override
    public ResponseEntity<SalaryHistory> get(long id) {
        SalaryHistory salaryHistory = salaryHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceException("SalaryHistory Not Found With the following ID -> " + id));
        return ResponseEntity.ok(salaryHistory);
    }

    @Override
    public ResponseEntity<SalaryHistory> update(long id, SalaryHistory details) {
        SalaryHistory updateSalaryHistory = salaryHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceException("SalaryHistory Not Found With the following ID -> " + id));
        updateSalaryHistory.setFromDate(details.getFromDate());
        updateSalaryHistory.setToDate(details.getToDate());
        updateSalaryHistory.setSalary(details.getSalary());

        salaryHistoryRepository.save(updateSalaryHistory);

        return ResponseEntity.ok(updateSalaryHistory);
    }

    @Override
    public boolean delete(long id) {
        SalaryHistory deleteSalaryHistory = salaryHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceException("SalaryHistory Not Found With the following ID -> " + id));
        salaryHistoryRepository.delete(deleteSalaryHistory);

        return true;
    }
}
