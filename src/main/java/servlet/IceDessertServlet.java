package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ice.IceOrder;  //老師建的包 不要抓錯了

//冰品店
@WebServlet("/ice")
public class IceDessertServlet extends HttpServlet{
	private static List<IceOrder> iceOrders = new CopyOnWriteArrayList<>();
	public static List<IceOrder> getIceOrders() {
        return iceOrders;
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/ice_dessert_form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* 我自己寫的
		String mainDish = req.getParameter("mainDish");
		String[] toppings = req.getParameterValues("toppings");
		
		IceOrder iceOrder = new IceOrder(mainDish,toppings);
		Orders.add(iceOrder);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/ice_dessert_result.jsp");
		req.setAttribute("iceOrder", iceOrder);
		req.setAttribute("Orders", Orders);
		rd.forward(req, resp);
		*/
		//老師寫的
		req.setCharacterEncoding("UTF-8");  //這只是預防未來中文的使用 老師是建議加上
		String mainDishName = req.getParameter("mainDish");
		String[] toppingsArray = req.getParameterValues("toppings");
		IceOrder iceOrder = new IceOrder(mainDishName,toppingsArray);
		iceOrders.add(iceOrder);		
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/ice_dessert_result.jsp");
		req.setAttribute("iceOrders", iceOrders);
		rd.forward(req, resp);
		
		
	}
	

}
