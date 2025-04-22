<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

    
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
			歷史留言: ${ guestbooks }<p/>
			
			<ol>
			<%--var=自定義變數名  引用名 --%>
				<c:forEach var="guestbooks" items="${ guestbooks }">
				<li> ${ guestbooks.message } ${ guestbooks.date } </li>
				</c:forEach>
			</ol>
			
			
			目前留言筆數: ${fn:length(guestbooks)}
			<table class="pure-table pure-table-bordered"> 
				<thead>
					<tr>
						<th>No</th>
						<th>留言內容</th>
						<th>留言時間</th>
					</tr>				
				</thead>
				<tbody>
				<%-- varStatus 提供索引 0開始  使用index 時+1 就能增加可讀性--%>
				<c:forEach  varStatus="i" var="gb" items="${ guestbooks }">
					<tr>
						<td>${ i.index + 1 }</td>
						<td>${ gb.message }</td>
						<%-- 格式化日期  yyyy-MM-dd 上午下午 hh:mm:ss 星期幾 --%>
						<td><fmt:formatDate value="${ gb.date }" pattern="yyyy-MM-dd a hh:mm:ss E"/></td>
					</tr>	
				</c:forEach>			
				</tbody>
			</table>
			
			
			<a href="/JavaWeb/guestbook" class="pure-button pure-button-primary">返回</a>
			
			
			
		</fieldset>
</body>
</html>