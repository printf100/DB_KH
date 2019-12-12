package com.biz;

import java.util.List;

import com.DTO.ScoreDTO;

public interface ScoreBiz {

	public List<ScoreDTO> selectList();
	
	public ScoreDTO selectOne(int no);
	
	public int insert(ScoreDTO dto);
	
	public int update(ScoreDTO dto);
	
	public int delete(int no);
}
