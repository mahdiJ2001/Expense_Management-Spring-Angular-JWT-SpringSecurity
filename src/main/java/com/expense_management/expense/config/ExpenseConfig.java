package com.expense_management.expense.config;

import com.expense_management.expense.mapper.ExpenseMapper;
import com.expense_management.expense.repository.ExpenseRepository;
import com.expense_management.expense.service.ExpenseService;
import com.expense_management.expense.service.impl.ExpenseServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.expense_management.expense.repository")
@EntityScan("com.expense_management.expense.entity")
@ComponentScan("com.expense_management")
public class ExpenseConfig {

    @Bean
    public ExpenseService expenseService(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        return new ExpenseServiceImpl(expenseRepository, expenseMapper);
    }
}
