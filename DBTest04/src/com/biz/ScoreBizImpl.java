package com.biz;

import java.util.List;

import com.DAO.ScoreDAO;
import com.DAO.ScoreDAOImpl;
import com.DTO.ScoreDTO;

public class ScoreBizImpl implements ScoreBiz {
	
	private ScoreDAO dao = new ScoreDAOImpl();

	@Override
	public List<ScoreDTO> selectList() {
		return dao.selectList();
	}

	@Override
	public ScoreDTO selectOne(int no) {
		return dao.selectOne(no);
	}

	@Override
	public int insert(ScoreDTO dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(ScoreDTO dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int no) {
		return dao.delete(no);
	}

}
