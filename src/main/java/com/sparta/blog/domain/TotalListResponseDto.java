package com.sparta.blog.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class TotalListResponseDto {


    private boolean success = true ;
    private List<BlogResponseDto> data;
    private String error;

    public TotalListResponseDto (List<BlogResponseDto> requestDto) {

        this.data = requestDto;


    }


}
