package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SingerDAO;
import model.domain.SingerDTO;

@WebServlet("/user")
public class UserView extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ArrayList<SingerDTO> nameList = SingerDAO.getAll();
		
		// 일반 유저는 가수정보 열람만 가능
		out.println(session.getAttribute("id") + "님 환영합니다" + "<br>" + "<br>");
		out.println("가수정보" + "<br>");
		for(SingerDTO v : nameList) {
			out.println(v + "<br>");
		}
		out.println("<button onclick='location.href=\"end\"'>로그아웃</button>");
	}

}
