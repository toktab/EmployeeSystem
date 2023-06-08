package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.SalaryHistory;
import dev.toktab.model.User;
import dev.toktab.repository.FundingRepository;
import dev.toktab.repository.SalaryHistoryRepository;
import dev.toktab.repository.UserRepository;
import dev.toktab.service.interfaces.ISalaryHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryHistoryService extends BaseService<SalaryHistory> implements ISalaryHistoryService {
    @Autowired
    public void setSalaryHistoryRepository(SalaryHistoryRepository salaryHistoryRepository){
        super.setRepository(salaryHistoryRepository);
    }
}
