package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVO;

public class ProductDAO {

	SqlSessionFactory factory;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static ProductDAO single = null;

	public static ProductDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new ProductDAO();
		//생성된 객체정보를 반환
		return single;
	}
	public ProductDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}

	public List<ProductVO> select(String category){
		SqlSession sqlSession = factory.openSession();
		List<ProductVO> list = sqlSession.selectList("p.select_list", category);
		sqlSession.close();
		return list;
	}
	public int insert(ProductVO vo) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("p.insert_product", vo);
		sqlSession.close();
		return res;
	}
	public ProductVO selectOne(int idx) {
		SqlSession sqlSession = factory.openSession();
		ProductVO vo = sqlSession.selectOne("p.product_detail", idx);
		sqlSession.close();
		return vo;
	}
}
