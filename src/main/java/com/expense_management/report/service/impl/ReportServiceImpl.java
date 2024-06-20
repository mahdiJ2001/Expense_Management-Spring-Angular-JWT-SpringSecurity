package com.expense_management.report.service.impl;

import com.expense_management.report.dto.ReportDto;
import com.expense_management.report.entity.Report;
import com.expense_management.report.mapper.ReportMapper;
import com.expense_management.report.repository.ReportRepository;
import com.expense_management.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, ReportMapper reportMapper) {
        this.reportRepository = reportRepository;
        this.reportMapper = reportMapper;
    }

    @Override
    public Optional<ReportDto> getReportById(int id) {
        return reportRepository.findById(id).map(reportMapper::toDto);
    }

    @Override
    public ReportDto saveReport(Report report) {
        Report savedReport = reportRepository.save(report);
        return reportMapper.toDto(savedReport);
    }

    @Override
    public boolean deleteReport(int id) {
        if (reportRepository.existsById(id)) {
            reportRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ReportDto updateReport(int id, Report report) {
        if (reportRepository.existsById(id)) {
            report.setId(id);
            Report updatedReport = reportRepository.save(report);
            return reportMapper.toDto(updatedReport);
        }
        return null;
    }

    @Override
    public List<ReportDto> getAllReports() {
        List<Report> reports = reportRepository.findAll();
        return reports.stream()
                .map(reportMapper::toDto)
                .collect(Collectors.toList());
    }
}
