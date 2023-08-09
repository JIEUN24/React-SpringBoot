package com.springboot.board.controller;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;


public class BoardDto {
    private Long id; // id
    private String title; // 제목
    private String content; // 내용
    private String userName; // 작성자
    private String createAt; // 최초 작성일
    private String updateAt; // 게시글 업데이트 날짜
    private int page; // 페이지 번호
    private int size; // 페이지 당 데이터 수

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreateAt() {
        return createAt;
    }
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BoardDto{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", createAt='").append(createAt).append('\'');
        sb.append(", updateAt='").append(updateAt).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
