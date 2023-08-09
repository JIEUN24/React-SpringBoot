package com.springboot.board.mapper;

import com.springboot.board.controller.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface BoardMapper {

    // 게시글 조회
    public ArrayList<BoardDto> getPostList(HashMap<String,Integer> paramMap);

    // 게시글 상세 조회
    public BoardDto findById(Long id);

    // 전체 페이지 조회
    public int getTotalPostCount();

    // 게시글 추가
    public int addPost(BoardDto boardDto);

    // 게시글 수정
    public int updatePost(BoardDto boardDto);

    // 게시글 삭제
    public  int deletePost(Long id);

}
