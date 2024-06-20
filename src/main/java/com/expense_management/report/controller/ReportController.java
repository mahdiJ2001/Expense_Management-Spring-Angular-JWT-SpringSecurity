package com.expense_management.report.controller;

import com.expense_management.report.dto.ReportDto;
import com.expense_management.report.entity.Report;
import com.expense_management.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
