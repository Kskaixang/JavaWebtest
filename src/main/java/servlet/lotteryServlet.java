package servlet;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//我們要設計一個 539樂透  需求是 39號中 抽出5個 不重複的集合

//這邊是網址
@WebServlet("/lottery")
public class lotteryServlet extends HttpServlet{
	//
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.生成樂透		
		Random random = new Random(); // 亂數 隨機數物件
		Set<Integer> numbers = new LinkedHashSet<>(); //號抽選後號碼的容器
		while(numbers.size() < 5) {
			int num = random.nextInt(39) +1; // 39 = 0~38的亂數 +1  == 1~39
			numbers.add(num);			
		}
		resp.getWriter().print("numbers");
		//2.生成調度器 調給你要的jsp    對請求建立調度器 且提供jsp址 讓指定的jsp回應
		RequestDispatcher rd = req.getRequestDispatcher("/lottery.jsp");
		//3.傳遞樂透號碼 設屬性給req     請求添加 要給jsp址的屬性
		req.setAttribute("numbers", numbers); //裝配請求要傳輸的內容		
		//resp 是要各自獨立 所以要獨立傳出
		rd.forward(req,resp); //傳出去
		
	}
	

}
