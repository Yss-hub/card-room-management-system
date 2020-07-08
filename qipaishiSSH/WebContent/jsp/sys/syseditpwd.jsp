<%@ page import="org.hibernate.Session" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    修改密码

</h1>
<form action="sys_updatePassword.action" method="post" target="main">
    <br>
    <table align="center">
        <tr>
            <td>账号</td>
            <td><s:textfield value="%{#session.user.username}" readonly="true" style="color:#a29e9e"></s:textfield></td>
        </tr>
        <tr>
            <td>原密码</td>
            <td><s:password name="oldpassword"></s:password></td>
        </tr>
        <tr>
            <td>新密码</td>
            <td><s:password name="password"></s:password></td>
        </tr>
        <tr>
            <td><s:hidden name="id" value="%{#session.user.id}"></s:hidden></td>
            <td><input type="submit" value="提交" id="submitButton"></td>
        </tr>
    </table>
</form>
</body>
</html>