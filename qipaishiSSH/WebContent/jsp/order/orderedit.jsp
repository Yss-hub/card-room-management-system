<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>棋牌室管理系统</title>
<link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1 align="center">
	修改订单信息

</h1>
<form action="order_update.action" method="post">
<br>
<table align="center">
	<tr>
		<td>会员ID</td><td> <s:textfield name="order.vipid" ></s:textfield></td>
	</tr>
	<tr>
		<td>棋牌室ID</td><td> <s:textfield name="order.qipaishiid" ></s:textfield></td>
	</tr>
		<tr>
		<td>数量</td><td> <s:textfield name="order.number" ></s:textfield></td>
	</tr>
	<tr>
		<td>日期</td><td> <s:textfield name="order.data" ></s:textfield></td>
	</tr>
	<tr>
		<td>时间</td><td> <s:textfield name="order.time" ></s:textfield></td>
	</tr>
	<tr>
		<td>价格</td><td> <s:textfield name="order.cost" ></s:textfield></td>
	</tr>
	<tr>
		<td><s:hidden name="order.id" ></s:hidden></td>
		<td> <input type="submit" value="提交"></td>
	</tr>
</table>
</form>
</body>
</html>