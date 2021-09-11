package com.tal.employeemanager.controller.record;

import com.tal.employeemanager.entity.settlement.Record;
import com.tal.employeemanager.service.record.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller @RequestMapping("record") public class RecordController {

    @Autowired RecordService recordService;

    @GetMapping public ResponseEntity<List<Record>> getAllRecords() {
        List<Record> records = recordService.findAll();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }
}
