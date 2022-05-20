package com.toy.daisy.domain.posts;

import com.toy.daisy.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
*   @Entity 는 JPA의 어노테이션, @Getter, @NoArgsConstructor은 롬복의 어노테이션이다.
*   롬복은 코드를 단순화시켜 주지만 필수 어노테이션은 아니다.
*
* */
@Getter // 클래스 내 모든 필드의 Getter 메소드 자동생성
@NoArgsConstructor  // 기본 생성자 자동 추가. public Posts(){} 와 같은 효과
@Entity
public class Posts extends BaseTimeEntity { // 실제 DB 테이블과 매칭될 클래스이다. Entity 클래스라고도 한다.
                     // DB 데이터 작업 경우, 실제 쿼리를 날리지 않고 이 클래스의 수정을 통해 작업한다.
                     // 기본적으로 카멜케이스 이름을 언더스코어 네이밍으로 테이블명을 매칭한다. (MqttData.java -> mqtt_data table)

    @Id // PK 필드를 지칭한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙을 나타낸다. IDENTITY를 붙이면 auto increament가 된다. (버전에 따라 상이)
    private Long id;
    @Column(length = 500, nullable = false) // 테이블 컬럼을 나타내는데, 굳이 선언하지 않아도 됨. 기본값 외에 변경 옵션이 있으면 사용한다. (사이즈, 타입 등)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author, Long id) {
        /*
        Posts.builder()
                .title(title)
                .content(content)
                .author(author);

         */
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
