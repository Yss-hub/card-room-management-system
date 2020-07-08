<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
<script >

function delOne(id){
	//alert(id);
	var sure=window.confirm("确定删除吗？");
	if(sure){
		window.location.href="vip_removeVip.action?vip.id="+id;
	}
}

</script>
</head>
<body align="center">
<h1>vip信息显示</h1>
<form id="form1" action="vip_findAllVip.action" method="post">
	会员卡信息：
<%-- 	<s:select name="vip.depart" list="departs" listKey="departname" listValue="departname"></s:select> --%>
	<select name="vip.depart" onchange="topage(1)">
		<option value="">---请选择---</option>
		<s:iterator value="departs" >
			<option ${departname==vip.depart?"selected":""}>${departname}</option>
		</s:iterator>	
	</select>
	姓名：<s:textfield name="vip.name" ></s:textfield>
	
	<input type="button" value="查询" onclick="topage(1)"> 
	

<p>
<table width="90%" border="1" align="center">
	<tr>
		<th>会员卡信息</th>
		<th>姓名</th>
		<th>性别</th>
		<th>电话号码</th>
		<th>卡号</th>
		<th>密码</th>
		<th>入会时间</th>
	</tr>
	<s:iterator value="page.records" >
	<tr>
		<td align="center">${depart}</td>
		<td align="center">${name}</td>
		<td align="center">${sexstr}</td>
		<td align="center">${phonenumber}</td>
		
		<td align="center">${cardnumber}</td>
		<td align="center">${cardpassword}</td>
		<td align="center">${enrolldate}</td>
		<td><s:a action="vip_editUI">
			<s:param name="vip.id" value="%{id}"></s:param>
			修改
		</s:a>
		<s:a href="javascript:delOne('%{id}')">删除</s:a>
		 </td>
	</tr>
	</s:iterator>
</table>
<!-- 分页的开始 -->
<%@ include file="/jsp/common/page.jsp" %>
<!-- 分页的结束 -->
</form>
</body>
</html>