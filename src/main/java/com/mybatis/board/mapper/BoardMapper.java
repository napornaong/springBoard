package com.mybatis.board.mapper;

import java.util.List;

import com.mybatis.board.vo.BoardVO;
import com.mybatis.board.vo.memberVO;

import net.webjjang.util.PageObject;

public interface BoardMapper {
	//�Խ��� ����Ʈ
	public List<BoardVO>list(PageObject pageObject);
	//��ü ������ ��������
	public Integer getCount();
	//�Խ��� �ۺ���
	public BoardVO view(int no);
	//�Խ��� �۾���
	public Integer write(BoardVO vo);
	//��ȸ�� 1����
	public Integer increase(int no);
	//�Խ��� ����
	public Integer update(BoardVO vo);
	//�Խ��� ����
	public Integer delete(int no);
	
	public Integer join(memberVO vo);
	
	public Integer sameid(String id);
	
	public memberVO login(String id);
	
}
