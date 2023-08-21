package com.springboot.board.controller;

import com.springboot.board.dto.BoardDto;
import com.springboot.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/posts")
public class BoardController {
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    // 게시글 조회
    @GetMapping
    public HashMap<String, Object> getList(@ModelAttribute BoardDto param) throws Exception {

        int page = param.getPage();
        int size = param.getSize();
        param.setStart((page - 1) * size);

        ArrayList<BoardDto> postList = service.getPostList(param);
        int totalPostCount = service.getTotalPostCount();
        int totalPages = (int) Math.ceil((double) totalPostCount / size);

        HashMap<String, Object> response = new HashMap<String, Object>();
        response.put("posts", postList);
        response.put("totalPages", totalPages);

        return response;
    }

    // 게시글 상세 조회
    @GetMapping("/{id}")
    public BoardDto getPost(@PathVariable("id") Long id) throws Exception {
        BoardDto response = service.getDetailPost(id);

        return response;
    }

    // 게시글 추가
    @PostMapping
    public HashMap<String, String> addPost(@RequestBody BoardDto body) throws Exception {
        HashMap<String, String> response = new HashMap<>();
        response = service.addPost(body);

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
    public HashMap<String, String> deletePost(@PathVariable("id") Long id) throws Exception {
        HashMap<String, String> response = new HashMap<>();
        response = service.deletePost(id);

        return response;
    }
}