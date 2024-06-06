package com.expense_management.expense.entity;

import com.expense_management.category.entity.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name="expenses")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float amount;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String note;
}