package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.tribes.util.Arrays;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		String[] menu = request.getParameterValues("menu");

		gender = gender.equals("M") ? "남자" : "여자";

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>ID : " + id + "</h1>");
		out.println("<h1>PWD : " + pwd + "</h1>");
		out.println("<h1>Gender : " + gender + "</h1>");
//		out.println("<h1>MENU : "+Arrays.toString(menu)+"</h1>");
//		out.println("<h1>MENU : "+String.join(",", menu)+"</h1>");

		if (menu != null) {
			out.println("<h1>MENU : </h1>");
			out.println("<ul>");
			for (String m : menu)
				out.println("<li>" + m + "</li>");
			out.println("</ul>");
		}

		out.println("</body></html>");
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
