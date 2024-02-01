package com.jdbcex.dao;

import com.jdbcex.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public MemberVO getWithPassword(String mid, String mpw) throws Exception {
        String query = "select mid, mpw, mname from tbl_member where mid = ? and mpw = ?";

        MemberVO memberVO = null; // 일단 비워놓음.

        // @Cleanup : 알아서 호출하고 닫아줌 - 메모리 누수 방지
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection(); // Hikari CP
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, mid); // ex) user01
        preparedStatement.setString(2, mpw); // ex) 1111

        // ResultSet이라는 친구를 통해서 결과값을 반환받아야 한다.
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next(); // 한줄한줄씩 처리해라.

        memberVO = MemberVO.builder()
                .mid(resultSet.getString(1))
                .mpw(resultSet.getString(2))
                .mname(resultSet.getString(3))
                .build();

        return memberVO; // 비워놨던 memberVO 에 객체를 넣는다.
    }

    public void updateUuid (String mid, String uuid) throws Exception {
        String sql = "update tbl_member set uuid = ? where mid = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, uuid); // 첫번째 물음표
        preparedStatement.setString(2, mid); // 두번째 물음표

        preparedStatement.executeUpdate(); // 최종 업데이트
    }

    public MemberVO selectUUID(String uuid) throws Exception {
        String query = "select mid, mpw, mname, uuid from tbl_member where uuid = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, uuid);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        MemberVO memberVO = MemberVO.builder()
                .mid(resultSet.getString(1))
                .mpw(resultSet.getString(2))
                .mname(resultSet.getString(3))
                .uuid(resultSet.getString(4))
                .build();

        return memberVO;
    }
}
