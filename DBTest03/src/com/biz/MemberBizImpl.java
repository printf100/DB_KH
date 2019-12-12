package com.biz;

import java.util.List;

import com.DAO.MemberDAO;
import com.DAO.MemberDAOImpl;
import com.DTO.MemberDTO;

public class MemberBizImpl implements MemberBiz {

	private MemberDAO dao = new MemberDAOImpl();
	
	@Override
	public List<MemberDTO> selectList() {
		return dao.selectList();
	}

	@Override
	public MemberDTO selectOne(int no) {
		return dao.selectOne(no);
	}

	@Override
	public int insert(MemberDTO dto) {
		
		// 소문자로 들어오면 대문자로 바꿔주기
		dto.setGender(dto.getGender().toUpperCase());
			
		return dao.insert(dto);
	}

	@Override
	public int update(MemberDTO dto) {
		
		dto.setGender(dto.getGender().toUpperCase());
			
		return dao.update(dto);
	}

	@Override
	public int delete(int no) {
		return dao.delete(no);
	}

}
