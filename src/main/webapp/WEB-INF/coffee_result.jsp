<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	
	<body style="margin: 100px;">
	<div class="pure-form">
		<h2>咖啡資料結果</h2>
	</div>	
		<fieldset>
			<legend>Coffee Result</legend>
			類型: ${ coffee.coffeeType } <p/>
			牛奶毫升數: ${ coffee.milkMl } (ml)<p/>
			咖啡毫升數: ${ coffee.coffeeMl } (ml)<p/>
			
			
			<a href="/JavaWeb/coffee" class="pure-button pure-button-primary">返回</a>
			
			
			
		</fieldset>
	
	</body>
</html>