package com.biz;

import java.util.List;

import com.DTO.MemberDTO;

public interface MemberBiz {

	public List<MemberDTO> selectList();
	
	public MemberDTO selectOne(int no);
	
	public int insert(MemberDTO dto);
	
	public int update(MemberDTO dto);
	
	public int delete(int no);
}
