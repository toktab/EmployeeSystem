package dev.toktab.controller;

import dev.toktab.model.SalaryHistory;
import dev.toktab.repository.SalaryHistoryRepository;
import dev.toktab.service.SalaryHistoryService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/salary_histories")
public class SalaryHistoryController {

    private final SalaryHistoryRepository salaryHistoryRepository;
    @Autowired
    SalaryHistoryService salaryHistoryService;
    @GetMapping("/get")
    public List<SalaryHistory> getAllSalaryHistories() {
        return salaryHistoryService.get();
    }

    @PostMapping()
    public SalaryHistory createSalaryHistory(@RequestBody SalaryHistory salaryHistory) {
        return salaryHistoryService.create(salaryHistory);
    }

    @GetMapping("{id}")
    public ResponseEntity<SalaryHistory> getSalaryHistoryId(@PathVariable long id) {
        return salaryHistoryService.get(id);
    }

    @PutMapping("/update")
    public ResponseEntity<SalaryHistory> updateSalaryHistory(@RequestBody SalaryHistory salaryHistoryDetails) {
        return salaryHistoryService.update(salaryHistoryDetails);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteSalaryHistory(@PathVariable long id) {
        return salaryHistoryService.delete(id);
    }
}
