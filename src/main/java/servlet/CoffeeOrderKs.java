package servlet;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coffeeOrderKs")
public class CoffeeOrderKs extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//設定編碼
			resp.setCharacterEncoding("UTF-8");  //告訴Servlet
			resp.setContentType("text/html;charset=UTF-8"); //告訴瀏覽器  兩邊都要通知
			
			Map<String,Integer[]> coffeemap = new HashMap<>();
			coffeemap.put("Latte", new Integer[] {50,70,90});
			coffeemap.put("Mocha", new Integer[] {45,55,65});
			coffeemap.put("Americano", new Integer[] {40,45,60});
			coffeemap.put("Cappuccino", new Integer[] {55,80,100});			
				
			//接收參數?type=Latte&size=M&sugar=yes
			String type = req.getParameter("type");
			String size = req.getParameter("size");	
			String sugar = req.getParameter("sugar");
			int arrIndex = 0;
			String chinese = "";	
			
			Integer[] OsizeArr = coffeemap.get(type);
			
			switch (size) {
				case "S" : 
					arrIndex = 0;
					chinese = "小杯";
					break;				
				case "M" : 
					arrIndex = 1;
					chinese = "中杯";
					break;	
				case "L" : 
					arrIndex = 2;
					chinese = "大杯";
					break;						
			}
			int price = OsizeArr[arrIndex];
			String sugerValue = haveSugar(sugar);
			//您點了一杯中杯Latte 咖啡（加糖）價格：70 元
			resp.getWriter().print(String.format("您點了一杯%s %s 咖啡（%s）價格：%d 元",chinese,type,sugerValue,price));
			
	}
	private String haveSugar(String s) {
		return s.equals("yes") ? "要加糖" : "不加糖";
		
	}
	

}
