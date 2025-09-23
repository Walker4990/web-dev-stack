package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

/**
 * Servlet implementation class DeptUpdateAct
 */
@WebServlet("/dept_modify_fin.do")
public class DeptUpdateAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 가장 중요한 것은 파라미터 넘기는 것과 받는것, 그리고 Map이 엄청 중요하다.
		int ori_deptno = Integer.parseInt(request.getParameter("ori_deptno"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ori_deptno", ori_deptno);
		map.put("deptno", deptno);
		map.put("dname", dname);
		map.put("loc", loc);
		
		DeptDAO.getInstance().update(map);
		response.sendRedirect("list.do");
	}

}
