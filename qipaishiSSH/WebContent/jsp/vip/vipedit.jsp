<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">
	修改vip信息

</h1>
<form action="vip_update.action" method="post">
<table align="center">
	<tr>
		<td>会员卡类型</td>
		<td> 

	<s:select name="vip.depart" list="departs" listKey="departname" listValue="departname"></s:select></td>
	
	</tr>
	<tr>
		<td>姓名</td><td> <s:textfield name="vip.name" ></s:textfield></td>
	</tr>
	<tr>
		<td>电话号码</td><td> <s:textfield name="vip.phonenumber" ></s:textfield></td>
	</tr>
	<tr>
		<td>性别</td>
		<td> 
			<s:radio name="vip.sex" list="#{'1':'男','0':'女'}" listKey="key" listValue="value"></s:radio>
		</td>
	</tr>
	<tr>
		<td>卡号</td><td> <s:textfield name="vip.cardnumber" ></s:textfield></td>
	</tr>
	<tr>
		<td>密码</td><td> <s:textfield name="vip.cardpassword"></s:textfield> </td>
	</tr>
	<tr>
		<td>入职日期</td><td><s:textfield name="vip.enrolldate" /> </td>
	</tr>
	<tr>
		<td>
		<s:hidden name="vip.id" ></s:hidden> </td>
		<td> <input type="submit" value="提交"></td>
	</tr>
</table>
</form>
</body>
</html>