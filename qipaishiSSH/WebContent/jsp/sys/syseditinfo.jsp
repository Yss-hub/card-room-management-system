<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1 align="center">
    修改用户信息

</h1>
<form action="sys_updateinfo.action" method="post">
    <table align="center">
        <tr>
            <td>等级</td>
            <td>
                <s:label value="%{#session.user.typeStr}"></s:label></td>
            </td>
        </tr>
        <tr>
            <td>姓名</td><td> <s:textfield name="user.name" value="%{#session.user.name}"></s:textfield></td>
        </tr>
        <tr>
            <td>用户名</td><td> <s:textfield name="user.username" value="%{#session.user.username}" readonly="true" style="color:#a29e9e"></s:textfield></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <s:if test="#session.user.sex==1">
                    <s:radio list="#{'1':'男','0':'女'}" name="user.sex" value="1"/>
                </s:if>
                <s:if test="#session.user.sex==0">
                <s:radio list="#{'1':'男','0':'女'}" name="user.sex" value="0"/>
                </s:if>
            </td>
        </tr>
        <tr>
            <td>联系方式</td><td> <s:textfield name="user.tel" value="%{#session.user.tel}"></s:textfield></td>
        </tr>
        <tr>
            <td><s:hidden name="user.password" value="%{#session.user.password}"></s:hidden></td>
            <td><s:hidden name="user.type" value="%{#session.user.type}"></s:hidden></td>
            <td><s:hidden name="user.id" value="%{#session.user.id}"></s:hidden></td>
            <td> <input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>