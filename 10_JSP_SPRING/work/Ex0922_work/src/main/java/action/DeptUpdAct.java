package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

/**
 * Servlet implementation class DeptUpdAct
 */
@WebServlet("/update.do")
public class DeptUpdAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));

        DeptVO vo = DeptDAO.getInstance().selectOne(deptno);
       
        request.setAttribute("vo", vo);
        RequestDispatcher disp = 
        		request.getRequestDispatcher("dept_update.jsp");
        disp.forward(request, response);
        
	}

}
