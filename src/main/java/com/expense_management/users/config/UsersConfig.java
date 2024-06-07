package com.expense_management.users.config;

import com.expense_management.users.mapper.UsersMapper;
import com.expense_management.users.repository.UsersRepository;
import com.expense_management.users.service.UsersService;
import com.expense_management.users.service.impl.UserServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.expense_management.users.repository")
@EntityScan("com.expense_management.users.entity")
@ComponentScan("com.expense_management")
public class UsersConfig {
    @Bean
    public UsersService usersService(UsersRepository usersRepository, UsersMapper usersMapper){
        return new UserServiceImpl(usersRepository,usersMapper);
    }
}
