package com.springboot.board.mapper;

import com.springboot.board.dto.BoardDto;
import com.springboot.board.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * CREATE TABLE public.post (
 * id serial4 NOT NULL,
 * title varchar(255) NOT NULL,
 * "content" text NULL,
 * user_name varchar(50) NOT NULL,
 * create_at date NOT NULL DEFAULT CURRENT_DATE,
 * update_at date NULL DEFAULT CURRENT_DATE,
 * CONSTRAINT post_pkey PRIMARY KEY (id)
 * );
 */

@Mapper
@Repository
public interface BoardMapper {

    /**
     * 게시글 리스트 조회
     *
     * @return 게시글 리스트
     */
    public ArrayList<BoardVo> getPostList(BoardVo boardVo);

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
