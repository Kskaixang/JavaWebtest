<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<%-- 不小心改到了 --%>
	<body style="margin: 100px;">
	<form class="pure-form" method="POST" action="/JavaWeb/guestbook">
				<fieldset>
					<legend>留言板</legend>
					<label>請輸入留言:</label>
					<%-- required 代表必填 --%>
					<input name="milk" type="text" required />
					 
				</fieldset>
				<button type="submit" class="pure-button pure-button-primary">送出</button>
	
	</body>
</html>