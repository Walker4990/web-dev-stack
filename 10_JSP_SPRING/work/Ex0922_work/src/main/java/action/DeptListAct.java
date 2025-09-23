package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

@WebServlet("/list.do")
public class DeptListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeptListAct() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<DeptVO> list = DeptDAO.getInstance().selectList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("dept_list.jsp").forward(request, response);

	}

}
