package com.springboot.board.service;

import ch.qos.logback.core.pattern.FormatInfo;
import com.springboot.board.dto.BoardDto;
import com.springboot.board.dto.PageDto;
import com.springboot.board.mapper.BoardMapper;
import com.springboot.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class BoardService {

    @Autowired
    private BoardMapper mapper;

    // 게시글 조회
    public ArrayList<BoardDto> getPostList(BoardDto boardDto, PageDto pageDto) throws Exception {
        int page = pageDto.getPage();
        int size = pageDto.getSize();
        int start = (page - 1) * size;
        pageDto.setStart(start);

        BoardVo boardVo = toBoardVo(boardDto, pageDto);
        ArrayList<BoardVo> response = mapper.getPostList(boardVo);
        ArrayList<BoardDto> responseList = new ArrayList<>();
        for (BoardVo vo : response) {
            responseList.add(toBoardDto(vo));
        }

        return responseList;
    }

    public BoardVo toBoardVo(BoardDto boardDto, PageDto pageDto) {
        BoardVo boardVo = new BoardVo();
        boardVo.setId(boardDto.getId());
        boardVo.setUserName(boardDto.getUserName());
        boardVo.setTitle(boardDto.getTitle());
        boardVo.setContent(boardDto.getContent());
        boardVo.setSize(pageDto.getSize());
        boardVo.setPage(pageDto.getPage());
        boardVo.setStart(pageDto.getStart());

        return boardVo;
    }

    public BoardDto toBoardDto(BoardVo boardVo) {
        BoardDto boardDto = new BoardDto();
        boardDto.setId(boardVo.getId());
        boardDto.setUserName(boardVo.getUserName());
        boardDto.setTitle(boardVo.getTitle());
        boardDto.setContent(boardVo.getContent());
        boardDto.setCreateAt(boardVo.getCreateAt());
        boardDto.setUpdateAt(boardVo.getUpdateAt());
        return boardDto;
    }

    // 전체 페이지 조회
    public int getTotalPostCount(PageDto pageDto) {
        int size = pageDto.getSize();
        int totalPostCount = mapper.getTotalPostCount();
        int totalPages = (int) Math.ceil((double) totalPostCount / size);

        return totalPages;
    }

    // 게시글 상세 조회
    public ArrayList<BoardDto> getDetailPost(BoardDto boardDto) throws Exception {
        BoardVo boardVo = toBoardVo(boardDto, new PageDto());
        ArrayList<BoardVo> response = mapper.getPostList(boardVo);
        ArrayList<BoardDto> responseList = new ArrayList<>();
        for (BoardVo vo : response) {
            responseList.add(toBoardDto(vo));
        }

        return responseList;
    }

    // 게시글 추가
    public HashMap<String, String> addPost(BoardDto boardDto) {
        int result = mapper.addPost(boardDto);

        HashMap<String, String> response = new HashMap<>();

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
        BoardDto originalPost = mapper.findById(boardDto);

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
    public HashMap<String, String> deletePost(BoardDto boardDto) {
        int result = mapper.deletePost(boardDto);
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
