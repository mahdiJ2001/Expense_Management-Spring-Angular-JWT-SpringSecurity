package com.expense_management.report.service;

import com.expense_management.report.dto.ReportDto;
import com.expense_management.report.entity.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {
    Optional<ReportDto> getReportById(int id);
    ReportDto saveReport(Report report);
    boolean deleteReport(int id);
    ReportDto updateReport(int id, Report report);
    List<ReportDto> getAllReports();
}
