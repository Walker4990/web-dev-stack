package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;

@WebServlet("/view.do")
public class ProductViewAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println("idx=" + request.getParameter("idx"));
		// DB에서 상품 하나 가져오기
	    ProductVO vo = ProductDAO.getInstance().selectOne(idx);

	    // request scope에 저장
	    request.setAttribute("vo", vo);

	    // JSP로 forward
	    request.getRequestDispatcher("product_detail.jsp").forward(request, response);
		
	}

}
