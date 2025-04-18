package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Util;

@WebServlet("/bmi")
public class bmiServlet extends HttpServlet{
	//Servlet預設 不支援UTF8 要設定編碼
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//設定編碼
		resp.setCharacterEncoding("UTF-8");  //告訴Servlet
		resp.setContentType("text/html;charset=UTF-8"); //告訴瀏覽器  兩邊都要通知
		
		//接收參數?name=Rose&age=20
		String h = req.getParameter("h");
		String w = req.getParameter("w");
		if( !(Util.isDouble(h) && Util.isDouble(w)) ) {
			resp.getWriter().print("身高體重輸入錯誤");
			return;
		}	
		//BMI＝體重(公斤)÷身高(公尺)÷身高(公尺)
		double dh = Double.parseDouble(h);
		double dw = Double.parseDouble(w);
		double bmiValue = getBMI(dh,dw);		
		String result = getBMIResult(bmiValue);
		//印出資訊
		resp.getWriter().print(String.format("BMI 值 = %.2f (%s)", bmiValue, result));
	}
	
	private String getBMIResult(Double bmiValue) {
		//三元套三元
		return bmiValue < 18 ? "過輕" : (bmiValue > 23) ? "過重" : "正常";
	}
	
	private double getBMI(double h,double w) {
		//BMI＝體重(公斤)÷身高(公尺)÷身高(公尺)
		return w / Math.pow(h/100,2);
		
	}
	/*
	private boolean isDouble(String data) {
		try {
			Double.parseDouble(data);
			//如果轉入parseInt通過 不會拋異常
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	*/
	

}
