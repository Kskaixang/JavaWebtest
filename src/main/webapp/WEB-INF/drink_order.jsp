<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coffee Oder</title>
</head>
	<body>
		<div>
			<fieldset>
				<legend>Coffee Oder</legend>
				<%-- 會自動呼叫get方法 --%>
				*飲料: ${ drinkOrder.type } <br/>
				容量: ${ drinkOrder.size } <br/>
				含糖: ${ drinkOrder.ice } <br/>
				 ${ drinkOrder.info }<br/>			
			</fieldset>		
		</div>
		
	
	
	</body>
</html>