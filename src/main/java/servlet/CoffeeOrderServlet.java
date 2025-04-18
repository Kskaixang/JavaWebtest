package servlet;

import java.io.IOException;

import java.util.*;

import model.CoffeeOrder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//老師的版本
@WebServlet("/coffeeOrder")
public class CoffeeOrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//設定編碼
			resp.setCharacterEncoding("UTF-8");  //告訴Servlet
			resp.setContentType("text/html;charset=UTF-8"); //告訴瀏覽器  兩邊都要通知
				
				
			//接收參數?type=Latte&size=M&sugar=true
			String type = req.getParameter("type");
			String size = req.getParameter("size");	
			String sugar = req.getParameter("sugar");
			
			if(type == null || size == null || sugar == null) {
				resp.getWriter().print("參數輸入錯誤");
				return;
			}
			//再model 設了CoffeeOder物件
			CoffeeOrder coffeeOrder = new CoffeeOrder(type,size,sugar);
			resp.getWriter().print(coffeeOrder.getInfo());
			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_order.jsp");
			req.setAttribute("coffeeOrder", coffeeOrder);
			rd.forward(req, resp);
			
	}
	

}
