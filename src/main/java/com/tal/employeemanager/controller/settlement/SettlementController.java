package com.tal.employeemanager.controller.settlement;

import com.tal.employeemanager.entity.settlement.SettlementEntity;
import com.tal.employeemanager.service.settlement.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller @RequestMapping("settlement") public class SettlementController {

    @Autowired SettlementService settlementService;

    @GetMapping public ResponseEntity<List<SettlementEntity>> findAll() {
        List<SettlementEntity> settlements = settlementService.findAll();
        return new ResponseEntity<>(settlements, HttpStatus.OK);
    }

    @GetMapping("name")
    public ResponseEntity<List<SettlementEntity>> findByOrderByNameAsc() {
        List<SettlementEntity> settlements =
                settlementService.findByOrderByNameAsc();
        return new ResponseEntity<>(settlements, HttpStatus.OK);
    }

    @GetMapping("{id}}")
    public ResponseEntity<SettlementEntity> findById(@PathVariable int id) {
        Optional<SettlementEntity> settlementEntityOptional =
                settlementService.findById(id);
        return new ResponseEntity<>(settlementEntityOptional.get(),
                HttpStatus.OK);
    }
}
