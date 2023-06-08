package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.Funding;
import dev.toktab.model.User;
import dev.toktab.repository.FundingRepository;
import dev.toktab.service.interfaces.IFundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundingService extends BaseService<Funding> implements IFundingService {
    @Autowired
    public void setFundingRepository(FundingRepository fundingRepository){
        super.setRepository(fundingRepository);
    }
}
