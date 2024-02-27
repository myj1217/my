package com.b01.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "roleSet")
public class Member extends BaseEntity{
    @Id
    private String mid;

    private String mpw;
    private String email;
    private boolean del;
    private boolean social;

    // 하나로 처리해서 가져와라. (분할해서 여러개 가지고 오지 말고)
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void changePassword(String mpw) {
        this.mpw = mpw;
    }
    public void changeEmail(String email) {
        this.email = email;
    }
    public void changeDel(boolean del) {
        this.del = del;
    }
    public void addRole(MemberRole memberRole) {
        this.roleSet.add(memberRole);
    }
    public void clearRoles() {
        this.roleSet.clear();
    }
    public void changeSocial(boolean social) {
        this.social = social;
    }
}
