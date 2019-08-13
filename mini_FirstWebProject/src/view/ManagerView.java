package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SingerDAO;
import model.domain.SingerDTO;

@WebServlet("/manage")
public class ManagerView extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		HttpSession session = request.getSession();

		out.println(session.getAttribute("id") + "관리자님 환영합니다" + "<br>" + "<br>");
		out.println("가수정보" + "<br>");
		for(SingerDTO v : SingerDAO.getAll()) {
			out.println(v + "<br>");
		}
		out.println("<br>");
		out.println("	<form action='add' method='post'>\r\n" + 
				"		이름 : <input type='text' name='name'><br>\r\n" + 
				"		나이 : <input type='number' name='age'><br>\r\n" + 
				"		대표곡: <input type='text' name='signaturesong'><br>\r\n" + 
				"		저장 : <input type='submit' value='저장'>	\r\n" + 
				"	</form>" + "<br>");
		out.println("<button onclick='location.href=\"end\"'>로그아웃</button>");

	}

}
