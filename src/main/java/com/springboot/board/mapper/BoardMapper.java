package com.springboot.board.mapper;

import com.springboot.board.controller.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface BoardMapper {
    public ArrayList<BoardDto> getPostList(HashMap<String,String> map);

    public int addPost(BoardDto boardDto);

    public int updatePost(BoardDto boardDto);
    public BoardDto findById(Long id);


    public  int deletePost(Long id);

}
