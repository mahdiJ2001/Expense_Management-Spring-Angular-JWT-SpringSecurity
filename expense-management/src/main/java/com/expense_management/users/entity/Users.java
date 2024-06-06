package com.expense_management.users.entity;
import com.expense_management.category.entity.Category;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name="users")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int phone;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Category> categories;

}
