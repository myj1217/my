package com.b01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 공통 속성 처리
// 모든 하위에 있는 엔티티 클래스에서 해당 클래스를 공통적으로 사용할 수 있다.
// 데이터베이스에 추가되거나 변경될 때 자동으로 시간값을 지정할 수 있다.
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
abstract class BaseEntity {
    // 자동으로 현재 날짜 및 시간으로 설정해야 하는 필드에 사용
    @CreatedDate
    // 생성 날짜
    @Column(name = "regdate", updatable = false) // 업데이트 되지 않도록 하는 옵션
    private LocalDateTime regDate;

    // 엔티티가 저장될 때 자동으로 최종 수정 날짜 및 시간으로 업데이트되어야 하는 필드에 사용
    @LastModifiedDate
    // 수정 날짜
    @Column(name = "moddate")
    private LocalDateTime modDate;
}
