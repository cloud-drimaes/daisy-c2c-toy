package com.toy.daisy.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        /*
        *   assertThat
        *   - assertj라는 테스트 검증 라이브러리의 검증 메소드이다.
        *   - 검증하고 싶은 대상을 메소드 인자로 받는다.
        *   - 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 쓸 수 있다.
        *
        *   isEqualTo
        *   - assertj의 동등 비교 메소드이다.
        *   - assertThat에 있는 값과 isEqualTo의 값을 비교하여 같을 때만 성공이다.
        *
        *   JUnit assertThat VS assertj assertThat
        *   > assertj
        *       - CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않다. (JUnit은 CoreMatchers를 추가해줘야함)
        *       - 자동완성이 더 확실히 지원된다. (Matcher라이브러리는 자동완성 지원이 약함)
        */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }

}
