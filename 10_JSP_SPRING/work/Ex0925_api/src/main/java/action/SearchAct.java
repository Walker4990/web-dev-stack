package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list.do")
public class SearchAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search_txt = request.getParameter("search_txt");
		// 네이버 API를 사용할때 UTF-8로 인코딩해서 보내야함.
		String search = URLEncoder.encode( search_txt, "UTF8" );
		
		// 네이버에서 요구하는 경로 /  &display로 불러오는 갯수 조정
		String urlStr = 
			"https://openapi.naver.com/v1/search/book.json?query=" + search +"&display=20";
		// 네이버 정책에 따라 ClientID, Secret key를 같이 보내야함
		URL url = new URL(urlStr);// openAPI의URL을 알고 있는 애를 HttpURLConnection으로 연결
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//		발급받은 아이디
		conn.setRequestProperty("X-Naver-Client-Id", "4pQo1aZfowjqd8FqpPEq");
		// 발급받은 시크릿 키
		conn.setRequestProperty("X-Naver-Client-Secret", "Kk5UHbB_zE");
		// Buffered라고 붙어있으면 조금이라도 빨리 처리하려고 만들어진 것
		// getInputStream으로 받아온걸 InputStreamReader로 읽고
		BufferedReader br = new BufferedReader( 
				new InputStreamReader( conn.getInputStream() ) );
		
		String line;
		String resultJson="";
		// api에서 읽어온 json구조의 내용들을 resultJson변수에 저장
		// line에 줄 단위로 가져온 것을 resultJson에 null이 나올때 까지 담는다. 
		while((line= br.readLine()) != null ) {
			resultJson += line;
		
		}
//		System.out.println(resultJson);
		// 열었던 스트림은 닫아줘야함.
		br.close();
		conn.disconnect();
		// 보내려고하는 JSON 값에 한글이 있으면 인코딩을 해서 보내야한다. 스프링이든 부트든 똑같음.
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().println("[" + resultJson + "]");
	}

}
