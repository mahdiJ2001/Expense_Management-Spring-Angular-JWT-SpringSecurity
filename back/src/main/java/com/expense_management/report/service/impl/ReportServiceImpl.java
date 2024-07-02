package com.expense_management.report.service.impl;

import com.expense_management.expense.entity.Expense;
import com.expense_management.expense.service.ExpenseService;
import com.expense_management.report.dto.ReportDto;
import com.expense_management.report.entity.Report;
import com.expense_management.report.mapper.ReportMapper;
import com.expense_management.report.repository.ReportRepository;
import com.expense_management.report.service.ReportService;
import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.service.UsersService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UsersService usersService;

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

    public ResponseEntity<byte[]> generateReportForUser(int userId) {
        try {
            List<Expense> expenses = expenseService.getExpensesByUserId(userId);

            Optional<UsersDto> userOptional = usersService.getUserById(userId);
            String firstName = "";
            String lastName = "";

            if (userOptional.isPresent()) {
                UsersDto user = userOptional.get();
                firstName = user.getFirstName();
                lastName = user.getLastName();
            } else {
                throw new RuntimeException("User not found with ID: " + userId);
            }

            ClassPathResource resource = new ClassPathResource("newreport.jrxml");
            InputStream inputStream = resource.getInputStream();
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("userId", userId);
            parameters.put("firstName", firstName);
            parameters.put("lastName", lastName);

            Date currentDate = new Date();
            parameters.put("currentDate", currentDate);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(expenses);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            byte[] pdfReport = outputStream.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "UserExpenseReport.pdf");

            return ResponseEntity.ok().headers(headers).body(pdfReport);

        } catch (IOException | JRException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
