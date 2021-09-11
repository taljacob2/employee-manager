package com.tal.employeemanager.controller.settlement;

import com.tal.employeemanager.entity.settlement.SettlementEntity;
import com.tal.employeemanager.service.settlement.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller @RequestMapping("settlement") public class SettlementController {

    @Autowired SettlementService settlementService;

    @GetMapping public ResponseEntity<List<SettlementEntity>> getAllRecords() {
        List<SettlementEntity> records = settlementService.findAll();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }
}
