package com.expense_management.config;

import com.expense_management.users.entity.Users;
import com.expense_management.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository userRepo;
    private final static String ROLE_PREFIX = "ROLE_";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> user = this.userRepo.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String password = user.get().getPassword();
        String role = user.get().getRole();
        role = ROLE_PREFIX + role ;
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(role));

        return new CustomUserDetails(email, password, roles);
    }
}
