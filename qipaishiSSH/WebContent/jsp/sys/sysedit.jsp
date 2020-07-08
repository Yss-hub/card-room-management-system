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
<form action="sys_update.action" method="post">
    <table align="center">
        <tr>
            <td>等级</td>
            <td>
                <select name="user.type">
                    <option value="">---请选择---</option>
                    <option ${user.type==1?"selected":""} value="1">普通用户</option>
                    <option ${user.type==50?"selected":""} value="50">管理员</option>
                    <option ${user.type==99?"selected":""} value="99">超级管理员</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>姓名</td><td> <s:textfield name="user.name" ></s:textfield></td>
        </tr>
        <tr>
            <td>用户名</td><td> <s:textfield name="user.username" ></s:textfield></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <s:radio list="#{'1':'男','0':'女'}" name="user.sex" value="1"/>
            </td>
        </tr>
        <tr>
            <td>联系方式</td><td> <s:textfield name="user.tel" ></s:textfield></td>
        </tr>
       
        <tr>
            <td><s:hidden name="user.password" ></s:hidden></td>
            <td><s:hidden name="user.id" ></s:hidden></td>
            <td> <input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>