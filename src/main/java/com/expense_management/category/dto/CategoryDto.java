package com.expense_management.category.dto;

import com.expense_management.users.dto.UsersDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private int id;
    private String name;
    private UsersDto user;
}
