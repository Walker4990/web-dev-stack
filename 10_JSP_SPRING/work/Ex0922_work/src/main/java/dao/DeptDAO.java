package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVO;

public class DeptDAO {

	SqlSessionFactory factory;
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static DeptDAO single = null;

	public static DeptDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new DeptDAO();
		//생성된 객체정보를 반환
		return single;
	}
	public DeptDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	public int insert(DeptVO dept) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("d.insert", dept);
		sqlSession.close();
		return res;
	}
	public List<DeptVO> selectList() {
		SqlSession sqlSession = factory.openSession();
		List<DeptVO> list = sqlSession.selectList("d.dept_list");
		sqlSession.close();
		return list;
	}
	public int delete(int no) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.delete("d.delete", no);
		sqlSession.close();
		return res;
	}
	public int update(Map<String, Object> map) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("d.update", map);
		System.out.println(res);
		sqlSession.close();
		return res;
	}
	public DeptVO selectOne(int deptno) {
		SqlSession sqlSession = factory.openSession();
		DeptVO vo = sqlSession.selectOne("d.select_one", deptno);
		sqlSession.close();
		return vo;
	}
}
