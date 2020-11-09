package com.mybatis.board.mapper;

import java.util.List;

import com.mybatis.board.vo.BoardVO;
import com.mybatis.board.vo.memberVO;

import net.webjjang.util.PageObject;

public interface BoardMapper {
	//게시판 리스트
	public List<BoardVO>list(PageObject pageObject);
	//전체 더이터 가져오기
	public Integer getCount();
	//게시판 글보기
	public BoardVO view(int no);
	//게시판 글쓰기
	public Integer write(BoardVO vo);
	//조회수 1증가
	public Integer increase(int no);
	//게시판 수정
	public Integer update(BoardVO vo);
	//게시판 삭제
	public Integer delete(int no);
	
	public Integer join(memberVO vo);
	
	public Integer sameid(String id);
	
	public memberVO login(String id);
	
}
