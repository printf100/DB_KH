package com.DAO;

import java.util.List;

import com.DTO.ScoreDTO;

public interface ScoreDAO {

	String SELECT_LIST_SQL =
			" SELECT NO, NAME, KOR, ENG, MATH "
			+ " FROM SCORE "
			+ " ORDER BY NO DESC ";
	
	String SELECT_ONE_SQL =
			" SELECT NO, NAME, KOR, ENG, MATH "
			+ " FROM SCORE "
			+ " WHERE NO = ? ";
	
	String INSERT_SQL = " INSERT INTO SCORE VALUES (?, ?, ?, ?, ?) ";
	
	String UPDATE_SQL = " UPDATE SCORE SET NAME = ?, KOR = ?, ENG = ?, MATH = ? "
			+ " WHERE NO = ? ";
	
	String DELETE_SQL = " DELETE FROM SCORE WHERE NO = ? ";

	public List<ScoreDTO> selectList();
	
	public ScoreDTO selectOne(int no);
	
	public int insert(ScoreDTO dto);
	
	public int update(ScoreDTO dto);
	
	public int delete(int no);
}
