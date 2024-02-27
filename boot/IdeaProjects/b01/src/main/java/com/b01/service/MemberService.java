package com.b01.service;

import com.b01.security.dto.MemberJoinDTO;

public interface MemberService {
    static class MidExistException extends Exception {

    }

    // 회원등록 기능을 수행할 때
    // 이미 동일 id를 가진 회원이 존재하면 MidExistException을 처리한다.
    // MidExistException은 회원 등록 시 중복된 id가 발생한 경우를 나타내는 예외.
    void join(MemberJoinDTO memberJoinDTO) throws MidExistException;
}
