package com.springboot.board.controller;

import com.springboot.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class BoardController {

    // 의존관계 연결
    @Resource(name = "boardService")
    private BoardService service;

    // 게시글 조회
    @GetMapping("/board/list")
    public HashMap<String, Object> getList(@RequestParam("page") int page, @RequestParam("size") int size) throws Exception {
        HashMap<String, Integer> paramMap = new HashMap<>();
        paramMap.put("start", (page - 1) * size); // 시작 인덱스
        paramMap.put("size", size); // 페이지당 게시글 수

        ArrayList<BoardDto> postList = service.getPostList(paramMap);
        int totalPostCount = service.getTotalPostCount();
        int totalPages = (int) Math.ceil((double) totalPostCount / size);

        HashMap<String, Object> response = new HashMap<>();
        response.put("posts", postList);
        response.put("totalPages", totalPages);

        return response;
    }

    // 게시글 상세 조회
    @GetMapping("/board/list/{id}")
    public BoardDto getPost(@PathVariable("id") Long id) throws Exception {
        BoardDto response = service.getDetailPost(id);

        return response;
    }

    // 게시글 추가
    @PostMapping("/board/add")
    public HashMap<String, String> addPost(@RequestBody BoardDto body) throws Exception {
        HashMap<String,String> response = new HashMap<>();
        response = service.addPost(body);

        return response;
    }

    // 게시글 수정
    @PutMapping("/board/update")
    public HashMap<String, String> updatePost(@RequestBody BoardDto boardDto) throws Exception {
        HashMap<String,String> response = new HashMap<>();
        response = service.updatePost(boardDto);

        return response;
    }

    // 게시글 삭제
    @DeleteMapping("/board/delete/{id}")
    public HashMap<String, String> deletePost(@PathVariable("id") Long id) throws Exception {
        HashMap<String, String> response = new HashMap<>();
        response = service.deletePost(id);

        return response;
    }
}