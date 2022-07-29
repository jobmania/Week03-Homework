package com.sparta.blog.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class TotalResponseDto {

    private boolean success = true ;
    private BlogResponseDto data;
    private String error;


    public TotalResponseDto(BlogResponseDto requestDto) {
        this.data = requestDto;
    }

}
