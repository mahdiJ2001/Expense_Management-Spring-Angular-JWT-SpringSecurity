package com.expense_management.budget.entity;

import com.expense_management.category.entity.Category;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "budgets")
@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private float amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    private String period;

    private float spentAmount;
}
