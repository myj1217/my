package com.b01.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
// @RequiredArgsConstructor   // 인증 처리를 위해 UserDetailsService의 구현체를 사용해야함.
public class CustomUserDetailsService implements UserDetailsService {
    private PasswordEncoder passwordEncoder;
    public CustomUserDetailsService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    // UserDetails는 사용자인증(Authentication)과 관련된 정보들을 저장하는 역할을 한다.
    @Override // UserDetails 반환값이라는 것은 UserDetails 패스워드를 검사하고 사용자 권한을 확인하는 방식으로 동작.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername: " + username);

        UserDetails userDetails = User.builder()
                .username("user1")
                .password(passwordEncoder.encode("1111"))
                .authorities("ROLE_USER")
                .build();

        return userDetails;
    }
}
