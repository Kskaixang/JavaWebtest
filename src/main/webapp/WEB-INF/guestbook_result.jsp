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
		<h2>訪客留言資料結果</h2>
	</div>	
		<fieldset>
			<legend>Guest Coffee Result</legend>
			本次留言: ${ message } <p/>
			歷史留言: ${ guestbooks } (ml)<p/>
			
			
			<a href="/JavaWeb/guestbook" class="pure-button pure-button-primary">返回</a>
			
			
			
		</fieldset>
</body>
</html>