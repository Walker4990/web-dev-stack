package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(id, pwd, name, age);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/").forward(request, response);
		 // 서버 모듈에서 우리가 /로 지정해놨기 때문에 /로도 초기화면 갈 수 있음.
	}

}
