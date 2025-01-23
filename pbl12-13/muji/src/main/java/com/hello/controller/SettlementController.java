package com.hello.controller;


import com.hello.domain.Settlement;
import com.hello.service.SettlementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SettlementController {
    private final SettlementService settlementService;

    @PostMapping("/settle/create")
    public ResponseEntity<Object> createSettlement(@RequestParam("settlementName") String settlementName) {
        Settlement settlement = settlementService.createSettlement(settlementName);
        return new ResponseEntity<>(settlement, HttpStatus.OK);
    }

    @PostMapping("/settle/{id}/join")
    public ResponseEntity<Void> joinSettlement (@PathVariable Long id){
        settlementService.joinSettlement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/settle/{id}/balance")
    public ResponseEntity<Object> getSettlementBalanceResult(@PathVariable Long id) {
        log.info("id = {}", id);
        return new ResponseEntity<>(settlementService.getBalanceResult(id), HttpStatus.OK);
    }

}
