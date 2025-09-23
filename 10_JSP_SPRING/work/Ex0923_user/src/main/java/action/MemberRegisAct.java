package action;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberRegisAct
 */
@WebServlet("/register.do")
public class MemberRegisAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post로 전송되는 파라미터에 한글이 포함되어 있다면 글자가 깨지지 않도록 utf8로 인코딩
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setUserid(userid);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setAddr(addr);
		
		MemberDAO.getInstance().register(vo);
		response.sendRedirect("list.do");
	
	}

	}
	
