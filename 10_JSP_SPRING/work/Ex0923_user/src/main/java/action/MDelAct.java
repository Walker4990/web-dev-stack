package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.MemberDAO;

/**
 * Servlet implementation class MDelAct
 */
@WebServlet("/member_del.do")
public class MDelAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int res = MemberDAO.getInstance().delete(idx);
		String result = "no";
		
		if (res > 0) {
			result= "yes";
		}
		response.setContentType("text/plain;charset=UTF-8");
		String resultStr = String.format("[{ \"result\":\"%s\", \"idx\":%d }]", result, idx);		response.getWriter().println( resultStr );
//		response.sendRedirect("list.do");
		
		
	}

}
