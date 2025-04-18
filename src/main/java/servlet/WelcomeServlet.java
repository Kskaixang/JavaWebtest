package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Util;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet{
	//Servlet預設 不支援UTF8 要設定編碼
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//設定編碼
		resp.setCharacterEncoding("UTF-8");  //告訴Servlet
		resp.setContentType("text/html;charset=UTF-8"); //告訴瀏覽器  兩邊都要通知
		
		//接收參數?name=Rose&age=20
		String name = req.getParameter("name");		
		String age = req.getParameter("age");
		String mes = "";
		
		if(Util.isNumber(age)) {
			mes = Integer.parseInt(age) >= 18 ? "已成年" : "未成年";
			resp.getWriter().print(name + " ,歡迎光臨 (" + age + "歲) 用戶" + mes);
		} else {
			resp.getWriter().print("訪客歡迎光臨");
		}
		
	}
	/*
	private boolean isNumber(String data) {
		try {
			Integer.parseInt(data);
			//如果轉入parseInt通過 不會拋異常
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}*/
	
	private boolean isNumber2(String data) {
		if(data == null) return false;
		return data.matches("\\d+");		
	}
	

}
