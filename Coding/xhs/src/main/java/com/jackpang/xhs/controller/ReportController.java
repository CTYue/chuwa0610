package com.jackpang.xhs.controller;

import com.jackpang.xhs.batch.ReportHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author b1go
 * @date 3/3/23 12:06 AM
 */
@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportHandler reportHandler;

    @GetMapping("/getReport")
    public ResponseEntity<String> getReport() {
        reportHandler.getLast24HoursReport();
        return ResponseEntity.ok("check log");
    }
}
