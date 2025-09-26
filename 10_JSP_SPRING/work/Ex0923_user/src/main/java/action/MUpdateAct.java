package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;


/**
 * Servlet implementation class MUpdateAct
 */
@WebServlet("/update.do")
public class MUpdateAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("idx", idx);       
	    map.put("userid", userid);
	    map.put("name", name);
	    map.put("pwd", pwd);       
	    map.put("email", email);
	    map.put("addr", addr);
		
		MemberDAO.getInstance().update(map);
		response.sendRedirect("list.do");
	}

}
