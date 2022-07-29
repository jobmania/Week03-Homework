package com.sparta.blog.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BlogResponseDto {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long id;
    private String title;
    private String author;
    private String contents;



public BlogResponseDto(Blog blog){
    this.id = blog.getId();
    this.title = blog.getTitle();
    this.contents=blog.getContents();
    this.author = blog.getAuthor();
    this.createdAt = blog.getCreatedAt();
    this.modifiedAt = blog.getModifiedAt();


}



}


