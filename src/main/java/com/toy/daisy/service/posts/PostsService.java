package com.toy.daisy.service.posts;

import com.toy.daisy.domain.posts.PostsRepository;
import com.toy.daisy.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository repository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return repository.save(requestDto.toEntity()).getId();
    }
}
