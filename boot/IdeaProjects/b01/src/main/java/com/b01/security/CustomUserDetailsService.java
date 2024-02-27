package com.b01.security;

import com.b01.domain.Member;
import com.b01.repository.MemberRepository;
import com.b01.security.dto.MemberSecurityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor   // 인증 처리를 위해 UserDetailsService의 구현체를 사용해야함.
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    // private PasswordEncoder passwordEncoder;

    // public CustomUserDetailsService() {
    //     this.passwordEncoder = new BCryptPasswordEncoder();
    // }
    // // UserDetails는 사용자인증(Authentication)과 관련된 정보들을 저장하는 역할을 한다.
    @Override // UserDetails 반환값이라는 것은 UserDetails 패스워드를 검사하고 사용자 권한을 확인하는 방식으로 동작.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername: " + username);

        Optional<Member> result = memberRepository.getWithRoles(username);

        if (result.isEmpty()) { // 해당 아이디를 가진 사용자가 없다면
            throw new UsernameNotFoundException("username not found......");
        }

        Member member = result.get();

        MemberSecurityDTO memberSecurityDTO = new MemberSecurityDTO(
                member.getMid(),
                member.getMpw(),
                member.getEmail(),
                member.isDel(),
                false, // ROLE_USER, ROLE_ADMIN
                member.getRoleSet().stream().map(memberRole ->
                        new SimpleGrantedAuthority("ROLE_" + memberRole.name()))
                        .collect(Collectors.toList())
        );

        log.info("memberSecurityDTO");
        log.info(memberSecurityDTO);

        return memberSecurityDTO;

//        UserDetails userDetails = User.builder()
//                .username("user1")
//                .password(passwordEncoder.encode("1111"))
//                .authorities("ROLE_USER")
//                .build();
//
//        return userDetails;
    }
}
