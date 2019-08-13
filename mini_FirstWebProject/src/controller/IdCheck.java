package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;

@WebServlet("/check")
public class IdCheck extends HttpServlet {
	private static UserDAO dao = UserDAO.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		// 로그인시 조건식 검증
		boolean r = dao.indentify(id, pw);
		
		
		HttpSession session = request.getSession();
		
		// 윤하일 경우만 관리자 그 외는 유저로 로그인
		if (r && id.equals("윤하")) {
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			response.sendRedirect("manage");
		} else if (r) {
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			response.sendRedirect("user");
		} else {
			response.sendRedirect("fail");
		}
		


	}

}
