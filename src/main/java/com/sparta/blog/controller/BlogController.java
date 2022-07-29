package com.sparta.blog.controller;


import com.sparta.blog.domain.*;
import com.sparta.blog.service.BlogService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController  // 스프링이 new 를 만들어준다.
public class BlogController {

    private final BlogRepository blogRepository;
    private final BlogService blogService;

        ////////// SUCCESS 따로 ,

    @GetMapping("/api/blogs")     //전체 게시글 조회  // 수정필요: 비밀번호 안보이게, success 보이게
    public TotalListResponseDto readBlog(){
        return blogService.readAll();
//        return  blogRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/blogs/{id}")  // 게시글 한개만 조회 // 수정 비밀번호 안보이게
    public TotalListResponseDto readOnlyBlog(@PathVariable Long id){
        return blogService.readOnlyOne(id);
//        return blogRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/blogs")      ////게시글 생성 (완성)
    public Blog createBlog(@RequestBody BlogRequestDto requestDto){   //@RequestBody 바디에 있는 것을 넣어줘
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    @PostMapping("/api/blogs/{id}") //password 확인하기 (완성???) 애매함....
    public boolean checkPw(@PathVariable Long id, @RequestBody BlogPasswordDto requestDto){
        return blogService.checkPw(id, requestDto);
    }

    @PutMapping("/api/blogs/{id}")     // 수정
    public Blog updateBlog(@PathVariable Long id,@RequestBody BlogRequestDto blogRequestDto){
        return blogService.update(id,blogRequestDto);
    }

    @DeleteMapping("/api/blogs/{id}")  //  삭제.
    public TotalResponseDto deleteBlog(@PathVariable Long id){
        return blogService.deleteId(id);
    }













}
