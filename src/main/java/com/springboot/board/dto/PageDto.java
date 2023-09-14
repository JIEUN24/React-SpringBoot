package com.springboot.board.dto;

import lombok.*;

@Data
public class PageDto {
    private int page; // 페이지 번호
    private int start; // 시작 인덱스
    private int size; // 페이지 당 데이터 수
}
