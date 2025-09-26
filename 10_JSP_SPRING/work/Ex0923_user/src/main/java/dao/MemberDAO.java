package dao;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVO;

public class MemberDAO {
	SqlSessionFactory factory;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static MemberDAO single = null;

	public static MemberDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new MemberDAO();
		//생성된 객체정보를 반환
		return single;
	}
	public MemberDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	public List<MemberVO> selectList(){
		SqlSession sqlSession = factory.openSession();
		List<MemberVO> list = sqlSession.selectList("m.member_list");
		sqlSession.close();
		return list;
	}
	public int register(MemberVO mem) {
		SqlSession sqlSession = factory.openSession( true );
		int res = sqlSession.insert("m.register", mem);
		sqlSession.close();
		return res;
	}
	public int delete(int idx) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.delete("m.member_del", idx);
		sqlSession.close();
		return res;
	}
	public MemberVO selectOne(int idx) {
		SqlSession sqlSession = factory.openSession();
		MemberVO member = sqlSession.selectOne("m.select_one", idx);
		sqlSession.close();
		return member;
	}
	public int update(Map<String, Object> map) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("m.member_update", map);
		sqlSession.close();
		return res;
	}
	// 아이디 중복체크
	public MemberVO selectOne(String userid) {
		SqlSession sqlSession = factory.openSession();
		MemberVO member = sqlSession.selectOne("m.check_userid", userid);
		sqlSession.close();
		return member;
	}
}
