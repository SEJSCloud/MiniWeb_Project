package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SingerDAO;
import model.domain.SingerDTO;

@WebServlet("/add")
public class Add extends HttpServlet {
	private SingerDAO dao = SingerDAO.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String age2 = request.getParameter("age");
		// 나이는 숫자값으로 파싱
		int age = Integer.parseInt(age2);
		String signaturesong = request.getParameter("signaturesong");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 저장시 검증
		boolean r = dao.indentify(name, age, signaturesong);
		
		// 저장되면 바로 볼 수 있게 다시 manage로 redirect
		// 저장조건이 맞지 않는다면 경고창 팝업과 확인을 누르면 다시 manage로 redirect
		if(r) {
			dao.virtualDB.add(new SingerDTO(name, age, signaturesong));
			response.sendRedirect("manage");
		}else {
			out.println("<script>alert('유효하지않습니다');"
					+ "location.href='manage'</script>");
		}
	}

}
