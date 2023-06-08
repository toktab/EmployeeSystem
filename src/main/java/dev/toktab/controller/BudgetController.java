package dev.toktab.controller;

import dev.toktab.model.Budget;
import dev.toktab.repository.BudgetRepository;
import dev.toktab.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/budgets")
public class BudgetController {
    private final BudgetRepository budgetRepository;
    @Autowired
    BudgetService budgetService;

    @GetMapping("/get")
    public List<Budget> getAllBudgets() {
        return budgetService.get();
    }

    @PostMapping()
    public Budget createBudget(@RequestBody Budget budget) {
        return budgetService.create(budget);
    }

    @GetMapping("{id}")
    public ResponseEntity<Budget> getBudgetId(@PathVariable long id) {
        return budgetService.get(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Budget> updateBudget(@RequestBody Budget budgetDetails) {
        return budgetService.update(budgetDetails);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBudget(@PathVariable long id) {
        return budgetService.delete(id);
    }
}
