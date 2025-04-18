package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//表示瀏覽器可以透過 http://localhost:8080/JavaWeb/hello
//網址執行到此servlet 程式  {"/hello","/welcome} 給兩個網址 可以用來記錄入口流量 比方統計廣再從哪邊被點擊導向
//標準寫法
@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 將字串回應給瀏覽器 resp即回應的物件
		resp.getWriter().print("Hello JavaServlet");
	}

	
}
