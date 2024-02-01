package com.jdbcex.service;

import com.jdbcex.dao.MemberDAO;
import com.jdbcex.domain.MemberVO;
import com.jdbcex.dto.MemberDTO;
import com.jdbcex.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO dao; // 데이터베이스 연결을 위한
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 우리 회사만의 메서드
    public MemberDTO login(String mid, String mpw) throws Exception {
        // getWithPassword : 데이터베이스와 네트워크를 연결해주는 메서드
        MemberVO vo = dao.getWithPassword(mid, mpw);
        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);
        return memberDTO;
    }

    public void updateUuid (String mid, String uuid) throws Exception {
        dao.updateUuid(mid, uuid);
    }

    public MemberDTO getByUUID(String uuid) throws Exception {
        MemberVO vo = dao.selectUUID(uuid);
        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);
        return memberDTO;
    }
}
