package com.springboot.board.service;

import com.springboot.board.controller.BoardDto;
import com.springboot.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Service("boardService")
public class BoardService {

    @Resource(name = "boardMapper")
    private BoardMapper mapper;

    public ArrayList<BoardDto> getPostList(HashMap<String, String> map) throws Exception{
        ArrayList<BoardDto> list = mapper.getPostList(map);
        return list;
    }

    public HashMap<String,String> addPost(BoardDto boardDto){
        int result = mapper.addPost(boardDto);

        HashMap<String,String > response = new HashMap<>();
        // add 쿼리를 날림 성공하면 1 실패 0
        if (result == 1) {
            response.put("status", "success");
            response.put("message", "게시글이 등록이 완료되었습니다.");
        } else {
            response.put("status", "fail");
            response.put("message", "게시글 등록에 실패하였습니다.");
        }

        return response;
    }

    public HashMap<String, String> updatePost(BoardDto boardDto) {
        BoardDto originalPost = mapper.findById(boardDto.getId());

        if (originalPost == null) {
            // 해당 ID를 가진 게시물을 찾을 수 없는 경우 에러 처리
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
