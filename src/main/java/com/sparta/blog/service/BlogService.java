package com.sparta.blog.service;

import com.sparta.blog.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor  //꼭필요
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional       //@Transactional는 꼭필요 업데이트
    public Blog update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        blog.update(requestDto); ///
        return blog;
    }

    @Transactional   // 비밀번호 확인  // password만 확인이 안될까????
    public boolean  checkPw(Long id, @RequestBody BlogPasswordDto requestDto){
        Blog blog =  blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        String realPassword = blog.getPassword();
        System.out.println(realPassword);
        System.out.println(requestDto.getPassword());  //com.sparta.blog.domain.BlogPasswordDto@5646979b <<주소

        return realPassword.equals(requestDto.getPassword());
    }


    @Transactional           // 리스폰 리스트로 만들어서 출력
    public TotalListResponseDto readAll(){            /////
        List<Blog> blogList = blogRepository.findAllByOrderByCreatedAtDesc();
        List<BlogResponseDto> newList = new ArrayList<>();

        for(int i = 0; i<blogList.size(); i++){
            Blog blog = blogList.get(i);
            BlogResponseDto blogResponseDto = new BlogResponseDto(blog); /// get의 이해
            newList.add(blogResponseDto);
        }
        TotalListResponseDto totalListResponseDto = new TotalListResponseDto(newList);

        return totalListResponseDto;


//        for (Blog blog : blogList) {            //예시코드
//            BlogResponseDto responseDto = new BlogResponseDto();
//            responseDto.setTitle(blog.getTitle());
//            responseDto.setAuthor(blog.getAuthor());
//            responseDto.setContents(blog.getContents());
//            responseDto.setCreatedAt(blog.getCreatedAt());
//            responseDto.setModifiedAt(blog.getModifiedAt());
//            newList.add(responseDto);
//        }
//        TotalListResponseDto.update(newList);



    }

    @Transactional     // 한개만 출력.
    public TotalListResponseDto readOnlyOne(Long id){
        Blog blog = blogRepository.findById(id).orElse(null);
        BlogResponseDto blogResponseDto = new BlogResponseDto(blog);  // 겟의 이해
        List<BlogResponseDto> newList = new ArrayList<>();
        newList.add(blogResponseDto);
        TotalListResponseDto totalListResponseDto = new TotalListResponseDto(newList);

      return totalListResponseDto;
    }


    @Transactional
    public TotalResponseDto deleteId(Long id){
        TotalResponseDto totalResponseDto = new TotalResponseDto();
        blogRepository.deleteById(id);
        return totalResponseDto;
    }



}