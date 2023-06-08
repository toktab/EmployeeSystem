package dev.toktab.controller;

import dev.toktab.model.Funding;
import dev.toktab.repository.FundingRepository;
import dev.toktab.service.FundingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fundings")
public class FundingController {
    private final FundingRepository fundingRepository;
    @Autowired
    FundingService fundingService;

    @GetMapping("/get")
    public List<Funding> getAllFundings() {
        return fundingService.get();
    }

    @PostMapping()
    public Funding createFunding(@RequestBody Funding funding) {
        return fundingService.create(funding);
    }

    @GetMapping("{id}")
    public ResponseEntity<Funding> getFundingId(@PathVariable long id) {
        return fundingService.get(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Funding> updateFunding(@RequestBody Funding fundingDetails) {
        return fundingService.update(fundingDetails);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteFunding(@PathVariable long id) {
        return fundingService.delete(id);
    }
}
