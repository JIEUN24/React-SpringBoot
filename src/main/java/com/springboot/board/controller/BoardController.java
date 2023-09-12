package com.springboot.board.controller;

import com.springboot.board.dto.BoardDto;
import com.springboot.board.service.BoardService;
import com.springboot.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.ArrayList;

@RestController
@RequestMapping("/posts")
public class BoardController {
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @GetMapping
    public HashMap<String, Object> getList(@ModelAttribute BoardVo boardVo) throws Exception {
        ArrayList<BoardVo> postList = service.getPostList(boardVo);
        int totalPage = service.getTotalPostCount(boardVo);

        HashMap<String, Object> response = new HashMap<>();
        response.put("posts", postList);
        response.put("totalPages", totalPage);

        return response;
    }

    @GetMapping("/{id}")
    public ArrayList<BoardVo> getPost(@ModelAttribute BoardVo boardVo) throws Exception {
        ArrayList<BoardVo> response = service.getDetailPost(boardVo);

        return response;
    }

    @PostMapping
    public HashMap<String, String> addPost(@RequestBody BoardDto boardDto) throws Exception {
        HashMap<String, String> response = new HashMap<>();
        response = service.addPost(boardDto);

        return response;
    }

    // 게시글 수정
    @PutMapping
    public HashMap<String, String> updatePost(@RequestBody BoardDto boardDto) throws Exception {
        HashMap<String, String> response = new HashMap<>();
        response = service.updatePost(boardDto);

        return response;
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public HashMap<String, String> deletePost(@ModelAttribute BoardDto boardDto) throws Exception {
        HashMap<String, String> response = new HashMap<>();
        response = service.deletePost(boardDto);

        return response;
    }
}