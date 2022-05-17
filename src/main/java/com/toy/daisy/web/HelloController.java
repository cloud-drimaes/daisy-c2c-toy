package com.toy.daisy.web;

import com.toy.daisy.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /*
    *   @RequestParam
    *   - 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션이다.
    *   - 여기에서는 외부에서 name(@RequestParam("name")) 이란 이름으로 넘긴 파라미터를
    *     메소드 파리미터 name(String name)에 저장하게 된다.
    *
    * */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
