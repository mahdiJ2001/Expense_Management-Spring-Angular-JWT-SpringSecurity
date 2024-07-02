package com.expense_management.report.service;

import com.expense_management.report.dto.ReportDto;
import com.expense_management.report.entity.Report;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface ReportService {
    Optional<ReportDto> getReportById(int id);
    ReportDto saveReport(Report report);
    boolean deleteReport(int id);
    ReportDto updateReport(int id, Report report);
    List<ReportDto> getAllReports();
    ResponseEntity<byte[]> generateReportForUser(int userId) throws JRException, IOException;
}
