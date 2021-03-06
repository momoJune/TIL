package kr.green.file.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import kr.green.file.vo.FileBoardVO;

public class FileBoardDAOImpl implements FileBoardDAO{
	private static FileBoardDAO instance = new FileBoardDAOImpl();
	private FileBoardDAOImpl() {}
	public static FileBoardDAO getInstance() {
		return instance;
	}
	//---------------------------------------------------------------------------
	@Override
	public int selectCount(SqlSession sqlSession) throws SQLException {
		return sqlSession.selectOne("board.selectCount");
	}
	@Override
	public FileBoardVO selectByIdx(SqlSession sqlSession, int idx) throws SQLException {
		return sqlSession.selectOne("board.selectByIdx", idx);
	}
	@Override
	public List<FileBoardVO> selectList(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
		return sqlSession.selectList("board.selectList", map);
	}
	@Override
	public void insert(SqlSession sqlSession, FileBoardVO fileBoardVO) throws SQLException {
		sqlSession.insert("board.insert", fileBoardVO);
	}
	@Override
	public void update(SqlSession sqlSession, FileBoardVO fileBoardVO) throws SQLException {
		sqlSession.update("board.update", fileBoardVO);
	}
	@Override
	public void delete(SqlSession sqlSession, int idx) throws SQLException {
		sqlSession.delete("board.delete", idx);
	}
	@Override
	public int selectMaxIdx(SqlSession sqlSession) throws SQLException {
		return sqlSession.selectOne("board.selectMaxIdx");
	}
}
