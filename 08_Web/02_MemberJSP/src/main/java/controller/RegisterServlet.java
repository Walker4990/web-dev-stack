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
		
		// 2. DAO 호출 - DB접근 필요시
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(id, pwd, name, age);
			System.out.println("가입 완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. 결과 페이지
		response.sendRedirect("result.jsp");
	}
}
