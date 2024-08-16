package com.expense_management.report.controller;

import com.expense_management.report.dto.ReportDto;
import com.expense_management.report.entity.Report;
import com.expense_management.report.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDto> getReportById(@PathVariable int id) {
        Optional<ReportDto> reportDtoOptional = reportService.getReportById(id);
        return reportDtoOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReportDto> createReport(@RequestBody Report report) {
        ReportDto savedReportDto = reportService.saveReport(report);
        return ResponseEntity.ok(savedReportDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportDto> updateReport(@PathVariable int id, @RequestBody Report report) {
        ReportDto updatedReportDto = reportService.updateReport(id, report);
        if (updatedReportDto != null) {
            return ResponseEntity.ok(updatedReportDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable int id) {
        boolean deleted = reportService.deleteReport(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ReportDto>> getAllReports() {
        List<ReportDto> reportDtoList = reportService.getAllReports();
        return ResponseEntity.ok(reportDtoList);
    }

    @GetMapping("/generate/{userId}")
    public ResponseEntity<byte[]> generateReport(@PathVariable int userId) throws JRException, IOException {
        return reportService.generateReportForUser(userId);
    }

}
