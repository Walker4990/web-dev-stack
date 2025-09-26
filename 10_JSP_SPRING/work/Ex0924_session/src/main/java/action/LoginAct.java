package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class LoginAct
 */
@WebServlet("/login.do")
public class LoginAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.do?id=one?pwd=1111
		
		String userid = request.getParameter("userid");
		System.out.println(userid);
		String pwd = request.getParameter("pwd");
		
		MemberVO vo = MemberDAO.getInstance().selectOne(userid);
		String param = "";
		String resultStr = "";
		// 아이디부터 잘못 됐다.
		if( vo == null ) {
			param="no_id";
			resultStr = String.format("[{ \"param\":\"%s\" }]", param);
			response.getWriter().println( resultStr );
			return;
		} 
		// 비밀번호 일치 여부
		if ( !vo.getPwd().equals( pwd ) ) {
			param="no_pwd";
			resultStr = String.format("[{ \"param\":\"%s\" }]", param);
			response.getWriter().println( resultStr );
			return;
		}
		
		
		// 로그인이 가능한경우
		HttpSession session = request.getSession();
		session.setAttribute("user", vo);
		// request와 session의 차이
		param="clear";
		resultStr = String.format("[{ \"param\":\"%s\" }]", param);
		response.getWriter().println( resultStr );
		
		}
	}


