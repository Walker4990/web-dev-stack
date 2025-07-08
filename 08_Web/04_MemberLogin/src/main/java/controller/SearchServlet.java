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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		Member member = null;
		MemberDAO dao = new MemberDAO();
		boolean check = true;
		
		try {
			String id = request.getParameter("id");
			member = dao.search(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("member", member);
		request.setAttribute("check", check);
		request.getRequestDispatcher("/views/result.jsp").forward(request, response);
	}

}
