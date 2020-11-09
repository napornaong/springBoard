package com.mybatis.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mybatis.board.mapper.BoardMapper;
import com.mybatis.board.vo.BoardVO;
import com.mybatis.board.vo.memberVO;

import net.webjjang.util.PageObject;

@Service
public class boardService {
	@Inject
	private BoardMapper mapper;
	
	public List<BoardVO> list(PageObject pageObject){
		System.out.println("BoardService.list().pageObject"+pageObject);
		pageObject.setTotalRow(mapper.getCount());
		return mapper.list(pageObject);
	}

	public Integer write(BoardVO vo) {
		return mapper.write(vo);
		// TODO Auto-generated method stub
	}
	
	public BoardVO view(int no, int inc) {
		if(inc==1) 
			mapper.increase(no);
		
		return mapper.view(no);
	}
	
	public Integer update(BoardVO vo) {
		return mapper.update(vo);
		
	}
	
	public Integer delete(int no) {
		return mapper.delete(no);
		
	}
	
	public Integer join(memberVO vo) {
	
		return mapper.join(vo);
	}
	public Integer sameid(String ckid) {
		System.out.println("BoardService"+ckid);
		return mapper.sameid(ckid);
	}
	
	public memberVO login(String id) {
		
		return mapper.login(id);
		
		
	}
}
