package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MemberDAO;


@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			MemberDAO dao = new MemberDAO();
			ArrayList<Member> member = dao.view(); // dao.view의 값들이 member로 들어감.
			
			request.setAttribute("member", member); // member의 값 바인딩
			
			request.getRequestDispatcher("view.jsp").forward(request, response); // 네비게이션
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
