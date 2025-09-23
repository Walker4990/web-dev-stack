package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SjVO;

public class SjDAO {

	SqlSessionFactory factory;
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static SjDAO single = null;

	public static SjDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new SjDAO();
		//생성된 객체정보를 반환
		return single;
	}
	public SjDAO() {
		// DB를 접속하는 객체를 싱글톤으로 호출
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	// 학생 목록 가져오기
	public List<SjVO> select(){
		/// mapper로 접근하기 위한 Sqlsession객체를 준비
		SqlSession sqlSession = factory.openSession();
		List<SjVO> list = sqlSession.selectList("s.sj_list");
		sqlSession.close();
		return list;
	}
	// 학생정보 등록
	public int register(SjVO vo) {
		SqlSession sqlSession = factory.openSession();
		int result = sqlSession.insert("s.sj_register", vo);
		sqlSession.commit(); 
		sqlSession.close();
		return result;
	}
	public int delete(int no) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.delete("s.sh_del", no);
		sqlSession.close();
		return res;
	}
}
