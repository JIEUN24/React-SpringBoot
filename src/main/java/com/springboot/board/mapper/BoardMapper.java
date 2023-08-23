package com.springboot.board.mapper;

import com.springboot.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
@Repository
public interface BoardMapper {

    /**
     * 게시글 리스트 조회
     *
     * @return 게시글 리스트
     */
    public ArrayList<BoardDto> getPostList(BoardDto boardDto);

    /**
     * 게시글 상세정보 조회
     *
     * @param boardDto - 게시글 id
     * @return 게시글 상세정보
     */
    public BoardDto findById(BoardDto boardDto);

    /**
     * 전체 페이지 수 조회
     *
     * @return 전체 페이지 수
     */
    public int getTotalPostCount();

    /**
     * 게시글 저장
     *
     * @param boardDto - 게시글 정보
     */
    public int addPost(BoardDto boardDto);

    /**
     * 게시글 수정
     *
     * @param boardDto - 게시글 정보
     */
    public int updatePost(BoardDto boardDto);

    /**
     * 게시글 삭제
     *
     * @param boardDto - 게시글 id
     */
    public int deletePost(BoardDto boardDto);

}
