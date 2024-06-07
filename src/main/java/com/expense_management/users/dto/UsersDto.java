package com.expense_management.users.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int phone;
}