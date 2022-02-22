package kr.green.boot.dao;

import java.sql.SQLException;
import java.util.HashMap;

import kr.green.boot.vo.TestVO;

public interface TestDAO {
	String today() throws SQLException;
	int    sum(HashMap<String, Integer> map) throws SQLException;
	int    mul(HashMap<String, Integer> map) throws SQLException;
	TestVO vo(TestVO testVO) throws SQLException;
}
