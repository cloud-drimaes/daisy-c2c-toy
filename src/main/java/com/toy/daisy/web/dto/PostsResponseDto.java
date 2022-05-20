package com.toy.daisy.web.dto;

import com.toy.daisy.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto { // Entity 필드 중 일부만 사용하므로 Entity를 받아 필드에 넣는다.
                                // 굳이 모든 필드를 가진 생성자가 필요하진 않으므로 Dto는 Entity를 받아 처리한다.

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
