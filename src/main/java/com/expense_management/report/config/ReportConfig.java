package com.expense_management.report.config;

import com.expense_management.report.mapper.ReportMapper;
import com.expense_management.report.repository.ReportRepository;
import com.expense_management.report.service.ReportService;
import com.expense_management.report.service.impl.ReportServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.expense_management.report.repository")
@EntityScan("com.expense_management.report.entity")
@ComponentScan("com.expense_management")
public class ReportConfig {

    @Bean
    public ReportService reportService(ReportRepository reportRepository, ReportMapper reportMapper) {
        return new ReportServiceImpl(reportRepository, reportMapper);
    }

}
