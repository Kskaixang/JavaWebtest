<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>冰果店的結帳系統</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
</head>
<body style="margin: 100px;">
	<div class="pure-form">
		<h2>冰果店的結帳系統</h2>
	</div>	
		<fieldset>
			<legend>結帳系統</legend>
			訂單資訊 : 
			
			<table class="pure-table pure-table-bordered"> 
				<thead>
					<tr>
						<th>Id</th>
						<th>主餐</th>
						<th>配料</th>
						<th>訂單時間</th>
						<th>價格</th>
						<th>修改</th>
						<th>刪除</th>
						
					</tr>				
				</thead>
				
				<tbody>					
					<c:forEach  varStatus="i" var="ib" items="${ Orders }">
					<tr>
						<td>${ ib.id }</td>
						<td>${ ib.mainDish }</td>
						<td>
						<c:forEach  var="tp" items="${ ib.toppings }">
							${ tp }
						</c:forEach>
						</td>
						
						
						<td><fmt:formatDate value="${ ib.date }" pattern="yyyy-MM-dd a hh:mm:ss E"/></td>
						<td>${ ib.price }</td>
						<td>修改</td>
						<td>刪除</td>
					
					</tr>
					</c:forEach>				
							
				</tbody>

			<tfoot>
				<tr style="border:1px solid;">
				
					<td colspan="3" style="text-align: right;">訂單數量: ${fn:length(Orders)}</td>
					<td style="text-align: right;">總金額：</td>
					<td>
						<c:forEach  var="od" items="${ Orders }">
						  <c:set var="total" value="${total + od.price}" />						 
						</c:forEach>
						 ${total}
					</td>
					<td colspan="2" style="text-align: center;">購買</td >
				</tr>
			</tfoot>


		</table>
			
			</p>
			<a href="/JavaWeb/ice" class="pure-button pure-button-primary">返回</a>
			
			
			
		</fieldset>
</body>
</html>