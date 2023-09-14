package com.springboot.board.dto;

import lombok.*;

@Data
public class BoardDto {
    private Long id; // id
    private String title; // 제목
    private String content; // 내용
    private String userName; // 작성자
    private String createAt; // 최초 작성일
    private String updateAt; // 게시글 업데이트 날짜
}

