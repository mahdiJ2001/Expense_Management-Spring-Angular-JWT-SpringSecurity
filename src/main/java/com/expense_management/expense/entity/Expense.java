package com.expense_management.expense.entity;

import com.expense_management.category.entity.Category;
import com.expense_management.report.entity.Report;
import com.expense_management.users.entity.Users;
import lombok.*;

import jakarta.persistence.*;
import java.util.Date;

@Table(name="expenses")
@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private float amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private Report report;
}
