package com.sparta.blog.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BlogRequestDto {
    private String title;
    private String author;
    private String contents;
    private String password;



}

