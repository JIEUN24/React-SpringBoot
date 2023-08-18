package com.springboot.board.service;

import com.springboot.board.controller.BoardDto;
import com.springboot.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Component
public class BoardService {

    @Autowired
    private BoardMapper mapper;

    // 게시글 조회
    public ArrayList<BoardDto> getPostList(HashMap<String, Integer> paramMap) throws Exception{
        ArrayList<BoardDto> response = mapper.getPostList(paramMap);
        if (response == null) {
            throw new Exception("게시글 목록이 없습니다.");
        }
        return response;
    }

    // 전체 페이지 조회
    public int getTotalPostCount() {
        return mapper.getTotalPostCount();
    }

    // 게시글 상세 조회
    public BoardDto getDetailPost(Long id) throws Exception {
        BoardDto response = mapper.findById(id);

        if (response == null) {
            throw new Exception("게시글을 찾을 수 없습니다.");
        }
        return response;
    }

    // 게시글 추가
    public HashMap<String,String> addPost(BoardDto boardDto){
        int result = mapper.addPost(boardDto);

        HashMap<String,String > response = new HashMap<>();

        // add 쿼리를 날림 성공하면 true: 1 실패 false: 0
        if (result == 1) {
            response.put("status", "success");
            response.put("message", "게시글이 등록이 완료되었습니다.");
        } else {
            response.put("status", "fail");
            response.put("message", "게시글 등록에 실패하였습니다.");
        }

        return response;
    }

    // 게시글 수정
    public HashMap<String, String> updatePost(BoardDto boardDto) {
        BoardDto originalPost = mapper.findById(boardDto.getId());

        if (originalPost == null) {
            HashMap<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "게시물을 찾을 수 없습니다.");
            return errorResponse;
        } else {
            mapper.updatePost(boardDto);
        }

        HashMap<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "게시물이 성공적으로 수정되었습니다.");

        return response;
    }

    // 게시글 삭제
    public HashMap<String, String> deletePost(Long id) {
        int result = mapper.deletePost(id);
        HashMap<String, String> response = new HashMap<>();

        if (result == 1) {
            response.put("status", "success");
            response.put("message", "게시글이 성공적으로 삭제되었습니다.");
        } else {
            response.put("status", "fail");
            response.put("message", "게시글 삭제에 실패하였습니다.");
        }

        return response;
    }
}
