package servlet;

import java.io.IOException;

import java.util.*;

import model.Coffee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//老師的版本
@WebServlet("/coffee")
public class CoffeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_form.jsp");
			rd.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");  
		//接收參數?type=Latte&size=M&sugar=true
		String milkAmount = req.getParameter("milk");
		String coffeeAmount = req.getParameter("coffee");	
	
		Coffee coffee = new Coffee(milkAmount, coffeeAmount);		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_result.jsp");
		req.setAttribute("coffee", coffee);
		rd.forward(req, resp);
	}
				
		
			
	

}
