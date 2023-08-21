package com.springboot.board.mapper;

import com.springboot.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
@Repository
public interface BoardMapper {

    // 게시글 조회
    public ArrayList<BoardDto> getPostList(BoardDto dto);

    // 게시글 상세 조회
    public BoardDto findById(Long id);

    // 전체 페이지 조회
    public int getTotalPostCount();

    // 게시글 추가
    public int addPost(BoardDto boardDto);

    // 게시글 수정
    public int updatePost(BoardDto boardDto);

    // 게시글 삭제
    public int deletePost(Long id);

}
