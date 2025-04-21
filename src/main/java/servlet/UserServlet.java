package servlet;

import java.io.IOException;
import model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/User")
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setCharacterEncoding("UTF-8");  //告訴Servlet
		//resp.setContentType("text/html;charset=UTF-8"); 
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/user_form.jsp");
		//3.對"請求"添加 要給jsp址的屬性
		//req.setAttribute("numbers", numbers); //裝配要傳輸的屬性  		
		rd.forward(req,resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setCharacterEncoding("UTF-8");  //告訴Servlet
		//resp.setContentType("text/html;charset=UTF-8"); 
		
		//接收參數
		String userName = req.getParameter("userName");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		
		//將資料 給User物件  model包就是存資料
		User user = new User(userName,gender,age,height,weight);
		
		
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/user_result.jsp");		
		rd.forward(req,resp);
		
		
	}
	

}
