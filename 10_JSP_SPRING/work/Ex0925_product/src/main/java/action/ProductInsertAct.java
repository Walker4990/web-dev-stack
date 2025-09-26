package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDAO;
import vo.ProductVO;


@WebServlet("/insert.do")
public class ProductInsertAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			// 개발자만 볼수 있는 경로 : 상대 경로
			// 개발자 + 클라이언트 들도 접속할 수 있는 경로 : 절대 경로
			String web_path = "/images/";
			
			ServletContext app = request.getServletContext();
			
			String path = app.getRealPath(web_path);

			// 최대 업로드 용량
			int max_size = 1024 * 1024 * 100;
													// 요청처리객체, 경로, 최대 크기, 인코딩 방식, 동일 이름 파일이 존재하면 자동으로 이름 변경
			MultipartRequest mr = new MultipartRequest( request, path, max_size, "utf-8", new DefaultFileRenamePolicy()  ); 
			
			// 절대 경로에 들어왔으면 DB에 넣어야함(파일을 직접 넣는게 아닌 이름만 넣는것)
			
			// 업로드 된 파일정보 얻어오기
			String p_image_s = "no_file";
			String p_image_l = "no_file";
			// 일반적인 텍스트가 아니기 때문에 파일구조로 받아야함.
			File f = mr.getFile("p_image_s");
			
			if (f != null) {
				p_image_s = f.getName(); // 업로드 된 파일의 실제 파일명
			}
			
			f = mr.getFile("p_image_l");
			if (f != null) {
				p_image_l = f.getName();
			}
			// 파일 이외의 나머지 파라미터들도 수신
			String category = mr.getParameter("category");
			String p_num = mr.getParameter("p_num");
			String p_name = mr.getParameter("p_name");
			String p_company = mr.getParameter("p_company");
			String p_content = mr.getParameter("p_content");
			
			int p_price = Integer.parseInt(mr.getParameter("p_price"));
			int p_saleprice = Integer.parseInt(mr.getParameter("p_saleprice"));
			
			ProductVO vo = new ProductVO();
			vo.setCategory(category);
			vo.setP_num(p_num);
			vo.setP_name(p_name);
			vo.setP_company(p_company);
			vo.setP_price(p_price);
			vo.setP_saleprice(p_saleprice);
			vo.setP_content(p_content);
			vo.setP_image_s(p_image_s);
			vo.setP_image_l(p_image_l);
			
			// 상품정보를 db로 보내자
			ProductDAO.getInstance().insert( vo );
			response.sendRedirect("list.do?category=" + vo.getCategory());
		}

}
