package com.expense_management.report.entity;

import com.expense_management.expense.entity.Expense;
import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name="reports")
@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String type;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    private List<Expense> data;


    public void addExpense(Expense expense) {
        this.data.add(expense);
    }

}
