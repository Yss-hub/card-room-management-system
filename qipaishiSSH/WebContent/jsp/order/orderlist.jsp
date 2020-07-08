<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>棋牌室管理系统</title>
<link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/bootstrap/bootstrap.min.js"></script>
<script >
function delOne(id){
	//alert(id);
	var sure=window.confirm("确定删除吗？");
	if(sure){
		window.location.href="order_removeOrder.action?order.id="+id;
	}
}
</script>
</head>
<body align="center">
<h2>棋牌室订单情况</h2>

<table width="90%" border="1" align="center">
	<tr>
	    <th align="center">订单编号</th>
		<th align="center">会员Id</th>
		<th align="center">棋牌室ID</th>
		<th align="center">数量</th>
		<th align="center">时间</th>
		<th align="center">预约日期</th>
		<th align="center">价格</th>
		<th>操作</th>
	</tr>
	<s:iterator value="orders" >
	<tr>
		<td align="center">${id}</td>
		<td align="center">${vipid}</td>
		<td align="center">${qipaishiid} </td>
		<td align="center">${number} </td>
		<td align="center">${data} </td>
		<td align="center">${time} </td>
		<td align="center">${cost} </td>
				<td>
				<s:a action="order_editUI">
				<s:param name="order.id" value="%{id}"></s:param>
				修改
				</s:a>
				<s:a href="javascript:delOne('%{id}')">删除</s:a>
		 </td>
	</tr>
	</s:iterator>
</table>
</body>
</html>