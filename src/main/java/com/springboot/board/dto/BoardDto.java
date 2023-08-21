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
    private int page; // 페이지 번호
    private int start; // 시작 인덱스
    private int size; // 페이지 당 데이터 수
    private int totalPage; // 총 페이지 수
}
