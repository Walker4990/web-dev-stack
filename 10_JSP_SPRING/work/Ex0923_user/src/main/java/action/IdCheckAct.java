package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

@WebServlet("/check_id.do")
public class IdCheckAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check_id.do?id=one
		
		String userid = request.getParameter("userid");
		
		MemberVO vo = MemberDAO.getInstance().selectOne(userid);
		
		String res = "no";
		if ( vo == null ) {
			// 가입이 가능한 userid인 경우
			res = "yes" ;
		}
		// 결과를 callback 메서드로 전달
		response.setContentType("text/plain;charset=UTF-8");
		String resultStr = String.format("[{ 'result':'%s', 'userid':'%s' }]", res, userid);
		
		// DB 사용을 마친 최종 결과를 콜백 메서드로 전달
		response.getWriter().println( resultStr );
	
	}

}
