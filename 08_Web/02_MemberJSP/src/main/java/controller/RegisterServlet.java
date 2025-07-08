package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 1. (있으면) 폼 값 받아온다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");

		int age = Integer.parseInt(ageStr);
		
		boolean check = true;
		
		
		// 2. DAO 호출 - DB접근 필요시
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(id, pwd, name, age);
		} catch (SQLException e) {
			check = false;
		}
		// 3. 바인딩 : 결과 페이지에 서버에서 받은 값 보내야 할 때
		// request.setAttribute(키, 값)
//		request.setAttribute("name", name);
		request.setAttribute("check", check);
		// 4. 네비게이션 : 결과페이지 지정
		// 결과 페이지는 하나로!
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		// 4. 네비게이션 : 결과페이지 지정
		// 회원가입 성공할 때랑 실패할 때 페이지를 구분하는 것?
		// check = true  회원가입 성공페이지로 이동
				// false 인 경우 실패페이지 이동
//				if (check) // response.sendRedirect("result.jsp");
//							// 만약 결과 페이지로 서버에서 받은 값 보여주려면
//					// -> RequestDispatcher forward 방식으로 보내야함.
//					request.getRequestDispatcher("result.jsp").forward(request, response);
//				else response.sendRedirect("fail.jsp");
	}
}
