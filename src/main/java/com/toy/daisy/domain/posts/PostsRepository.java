package com.toy.daisy.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    /*
    *   SpringDataJpa에서 제공하지 않는 메소는 @Query를 사용한다. (예)
    *   규모가 있는 데이터 조회는 복잡한 조건, Join으로 인해 Entity 클래스만으로 처리하기 어려워 조회용 프레임워크를 추가로 사용한다.
    *   보통 조회는 @Query를, 등록/수정/삭제는 JPA를 사용!
    *   **querydsl, jooq, MyBatis
    *
    * querydsl 장점
    *   - 타입 안정성 보장
    *       메소드 기반으로 쿼리를 생성하기 때문에 오타나 존재하지 않는 컬럼명이 있으면 IDE에서 검출해준다. (Jooq에서도 지원, Mabatis는 지원x)
    *   - 국내 많은 회사에서 사용
    *       쿠팡, 배민 등 JPA를 적극 사용하는 회사에서는 Querydsl을 적극적으로 사용하고 있다.
    *   - 레퍼런스가 많음
    *
    * */
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC ")
    List<Posts> findAllDesc();
}
