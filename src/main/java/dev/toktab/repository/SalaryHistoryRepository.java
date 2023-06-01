package dev.toktab.repository;

import dev.toktab.model.SalaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryHistoryRepository extends JpaRepository<SalaryHistory, Long> {
}
