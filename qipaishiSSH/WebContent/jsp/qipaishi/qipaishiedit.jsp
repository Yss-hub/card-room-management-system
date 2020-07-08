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
	修改棋牌室信息

</h1>
<form action="qipaishi_update.action" method="post">
<br>
<table align="center">
	<tr>
		<td>棋牌室名称</td><td> <s:textfield name="qipaishi.qipaishiname" ></s:textfield></td>
	</tr>
	<tr>
		<td>棋牌室类型</td><td> <s:textfield name="qipaishi.type" ></s:textfield></td>
	</tr>
		<tr>
		<td>大小</td><td> <s:textfield name="qipaishi.size" ></s:textfield></td>
	</tr>
		<tr>
		<td>价格</td><td> <s:textfield name="qipaishi.price" ></s:textfield></td>
	</tr>
		<tr>
		<td>状态</td><td> <s:textfield name="qipaishi.state" ></s:textfield></td>
	</tr>
	<tr>
		<td><s:hidden name="qipaishi.id" ></s:hidden></td>
		<td> <input type="submit" value="提交"></td>
	</tr>
</table>
</form>
</body>
</html>