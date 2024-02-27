package com.b01.service;

import com.b01.domain.Member;
import com.b01.domain.MemberRole;
import com.b01.repository.MemberRepository;
import com.b01.security.dto.MemberJoinDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void join(MemberJoinDTO memberJoinDTO) throws MidExistException {
        String mid = memberJoinDTO.getMid();
        boolean exist = memberRepository.existsById(mid);
        // 만약 회원 아이디가 이미 존재한다면 MidExistException을 발생시킴
        if (exist) {
            throw new MidExistException();
        }
        // MemberJoinDTO 객체를 Member 객체로 매핑
        Member member = modelMapper.map(memberJoinDTO, Member.class);
        // 회원의 비밀번호를 암호화하여 설정
        member.changePassword(passwordEncoder.encode(memberJoinDTO.getMpw()));
        // 회원에게 기본 역할(USER)을 추가
        member.addRole(MemberRole.USER);

        log.info("============");
        log.info(member);
        log.info(member.getRoleSet());

        memberRepository.save(member);
    }
}
