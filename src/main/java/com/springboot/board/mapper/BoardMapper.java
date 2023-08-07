package com.springboot.board.mapper;


import com.springboot.board.controller.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface BoardMapper {
    public ArrayList<BoardDto> getList(HashMap<String,String> map);
    public BoardDto findById(Long id);
    // int가 반환값
    public int addPost(BoardDto boardDto);
    public  int deletePost(Long id);
    public int updatePost(BoardDto boardDto);

}
