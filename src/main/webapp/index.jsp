<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JavaIndex</title>
	</head>
	<body>
		<h1>我的首頁</h1>
		<h2>Servlet 應用</h2>
		
		<ol>
			<li>
				<a href="http://localhost:8080/JavaWeb/hello">GO_hello(使用Model 0 [只用 Servlet 或 JSP])</a>				
			</li>
			<li>
				<%-- <a href="http://localhost:8080/JavaWeb/lottery">GOlottery</a>	可化簡 自動抓本機--%>
				<a href="/JavaWeb2/lottery">GO_lottery(使用Model 1 [用 Servlet+JSP])</a>
			</li>
			
		</ol>
		
	</body>
</html>