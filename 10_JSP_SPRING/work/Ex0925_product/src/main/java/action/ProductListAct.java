package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;

@WebServlet("/list.do")
public class ProductListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// list.do?category=com001
		
		String category = request.getParameter("category");
		// list.do <= NULL
		// list.do?category= <= empty
		// 어떤 상황이 올지 몰라서 둘 다 체크하는 것이 좋다.
		if ( category == null || category.isEmpty() ) {
			category = "com001";
		}
		List<ProductVO> list = ProductDAO.getInstance().select(category);
		request.setAttribute("list", list);
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
	}

}
