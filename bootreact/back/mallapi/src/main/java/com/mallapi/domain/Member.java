package com.mallapi.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString (exclude = "memberRoleList")
public class Member {

  @Id
  private String email;

  private String pw;

  private String nickname;

  private boolean social;

  // 부모의 엔티티 외 저장
  @ElementCollection(fetch = FetchType.LAZY)
  @Builder.Default
  private List<MemberRole> memberRoleList = new ArrayList<>();

  public void addRole(MemberRole memberRole){

      memberRoleList.add(memberRole);
  }

  public void clearRole(){
      memberRoleList.clear();
  }

  public void changeNickname(String nickname) {
    this.nickname = nickname;
  }

  public void changePw(String pw){
    this.pw = pw;
  }

  public void changeSocial(boolean social) {
    this.social = social;
  }

}