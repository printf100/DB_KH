package com.DAO;

import java.util.List;

import com.DTO.MemberDTO;

public interface MemberDAO {
	
	// 상수는 스네이크 표기법으로!
	String SELECT_LIST_SQL =
			" SELECT NO, NAME, AGE, GENDER, LOCATION, JOB, TEL, EMAIL "
			+ " FROM TB_MEMBER "
			+ " ORDER BY NO DESC ";
	
	String SELECT_ONE_SQL =
			" SELECT NO, NAME, AGE, GENDER, LOCATION, JOB, TEL, EMAIL "
			+ " FROM TB_MEMBER "
			+ " WHERE NO = ? ";
	
	String INSERT_SQL = " INSERT INTO TB_MEMBER VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
	
	String UPDATE_SQL = " UPDATE TB_MEMBER SET NAME = ?, AGE = ?, GENDER = ?, LOCATION = ?, JOB = ?, TEL = ?, EMAIL = ? "
			+ " WHERE NO = ? ";
	
	String DELETE_SQL = " DELETE FROM TB_MEMBER WHERE NO = ? ";

	public List<MemberDTO> selectList();
	
	public MemberDTO selectOne(int no);
	
	public int insert(MemberDTO dto);
	
	public int update(MemberDTO dto);
	
	public int delete(int no);
}
