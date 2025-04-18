package servlet;

import java.io.IOException;

import java.util.*;

import model.DrinkOrder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//老師的版本
@WebServlet("/drinkOrder")
public class DrinkOrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//設定編碼
			resp.setCharacterEncoding("UTF-8");  //告訴Servlet
			resp.setContentType("text/html;charset=UTF-8"); //告訴瀏覽器  兩邊都要通知
				
				
			//接收參數?type=Latte&size=M&sugar=true
			
			//回家作業 ?type=milkTea&size=L&ice=yes
			String type = req.getParameter("type");
			String size = req.getParameter("size");	
			String ice = req.getParameter("ice");
			
			if(type == null || size == null || ice == null) {
				resp.getWriter().print("Dk參數輸入錯誤");
				return;
			}
			//再model 設了CoffeeOder物件
			//
			DrinkOrder drinkOrder = new DrinkOrder(type,size,ice);
			//resp.getWriter().print(drinkOrder.getInfo());
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/drink_order.jsp");
			req.setAttribute("drinkOrder", drinkOrder);
			rd.forward(req, resp);
			
	}
	

}
