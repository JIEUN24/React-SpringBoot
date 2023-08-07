package com.springboot.board.controller;

import com.springboot.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class BoardController {

    @Resource(name = "boardService")
    private BoardService service;

    @GetMapping("/board/list")
    public ArrayList<BoardDto> getList() throws Exception {
        ArrayList<BoardDto> list = service.getList(null);
        System.out.println(list);
        return list;
    }

    @PostMapping("/board/add")
    public HashMap<String, String> addPost(@RequestBody BoardDto body) throws Exception {

        HashMap<String,String> response = new HashMap<>();
        response = service.addPost(body);

        return response;
    }

    @DeleteMapping("/board/delete/{id}")
    public HashMap<String, String> deletePost(@PathVariable("id") Long id) throws Exception {

        System.out.println(id);

        HashMap<String, String> response = new HashMap<>();
        response = service.deletePost(id);

        return response;
    }

    @PutMapping("/board/update")
    public HashMap<String, String> updatePost(@RequestBody BoardDto boardDto) throws Exception {
        HashMap<String,String> response = new HashMap<>();
        response = service.updatePost(boardDto);

        return response;
    }

}