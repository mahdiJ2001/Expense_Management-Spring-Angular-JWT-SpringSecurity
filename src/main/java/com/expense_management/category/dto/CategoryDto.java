package com.expense_management.category.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private int id;
    private String name;
    private Integer userId;
}
