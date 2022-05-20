package com.toy.daisy.service.posts;

import com.toy.daisy.domain.posts.Posts;
import com.toy.daisy.domain.posts.PostsRepository;
import com.toy.daisy.web.dto.PostsListResponseDto;
import com.toy.daisy.web.dto.PostsResponseDto;
import com.toy.daisy.web.dto.PostsSaveRequestDto;
import com.toy.daisy.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository repository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return repository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        return repository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        // JpaRepository에서 이미 delete 메소드를 지원하고 있으니 활
        Posts posts = repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        repository.delete(posts);
    }
}
