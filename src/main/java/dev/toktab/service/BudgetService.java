package dev.toktab.service;

import dev.toktab.model.Budget;
import dev.toktab.repository.BudgetRepository;
import dev.toktab.service.interfaces.IBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BudgetService extends BaseService<Budget> implements IBudgetService {
    @Autowired
    public void setBudgetRepository(BudgetRepository budgetRepository){
        super.setRepository(budgetRepository);
    }
}
