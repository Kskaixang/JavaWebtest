<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>冰果店的點餐系統</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
</head>
	<body style="margin: 100px;">
		<h2>冰果店的點餐系統</h2>
		<form class="pure-form" method="POST" action="/JavaWeb/ice">
				<fieldset>
				<%--單選 Servlet使用req.getParameter("mainDish") 得到String --%>
					<legend>選擇主餐</legend>
					<input type="radio" name="mainDish" value="剉冰" checked>🍧剉冰 (50元) <p/>
					<input type="radio" name="mainDish" value="豆花" >🍮豆花 (40元) <p/>
				</fieldset>
				<%--複選 Servlet使用req.getParameterValues("toppings") 得到String[]--%>
				<fieldset>
					<legend>選擇加料(每樣10元)</legend>
					<input type="checkbox" name="toppings" value="花生" >🥜花生 <p/>
					<input type="checkbox" name="toppings" value="綠豆" >🌱綠豆 <p/>
					<input type="checkbox" name="toppings" value="紅豆" >🍒紅豆 <p/>
					<input type="checkbox" name="toppings" value="芋圓" >🥔芋圓 <p/>
					<input type="checkbox" name="toppings" value="粉圓" >⚪粉圓 <p/>
					<input type="checkbox" name="toppings" value="煉乳" >🍼煉乳 <p/>					
				</fieldset>
				
				<button type="submit" class="pure-button pure-button-primary">送出</button>
		</form>
</body>
</html>