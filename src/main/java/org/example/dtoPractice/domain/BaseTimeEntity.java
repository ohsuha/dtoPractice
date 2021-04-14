package org.example.dtoPractice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //엔티티 클래스들이 BaseTimeEntity를 상속할 경우 아래 필드들도 칼럼으로 자동 인식하도록함
@EntityListeners(AuditingEntityListener.class) //클래스에 AUditing기능을 포함시킴
public abstract class BaseTimeEntity {

    //이렇게 만든 BaseTimeEntity는 모든 Entity의 상위 클래스가 되어 엔티티들의
    //생성일, 수정일을 자동으로 관리하는 역할을 합니다.

    @CreatedDate
    private LocalDateTime createdDate;
    //생성시간 자동저장

    @LastModifiedDate
    private LocalDateTime modifiedDate;
    //수정시간 자동저장
}
