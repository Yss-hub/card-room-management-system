<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
    <script>

        function delOne(id) {
            //alert(id);
            var sure = window.confirm("确定删除吗？");
            if (sure) {
                window.location.href = "sys_removeUser.action?user.id=" + id;
            }
        }

    </script>
</head>
<body align="center">
<h1>会员信息显示</h1>
<form id="form1" action="sys_findAllUser.action" method="post">
    用户级别：
    <select name="user.type" onchange="topage(1)">
        <option value="">---请选择---</option>
        <option ${user.type==1?"selected":""} value="1">普通用户</option>
        <option ${user.type==50?"selected":""} value="50">管理员</option>
        <option ${user.type==99?"selected":""} value="99">超级管理员</option>
    </select>

    姓名：<s:textfield name="user.name"></s:textfield>

    <input type="button" value="查询" onclick="topage(1)">


    <p>
    <table width="90%" border="1" align="center">
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>性别</th>
            <th>类别</th>

            <th>用户名</th>
            <th>电话</th>

            <th>操作</th>

        </tr>
        <s:iterator value="page.records">
            <tr>
                <td align="center">${id}</td>
                <td align="center">${name}</td>
                <td align="center">${sex}</td>
                <td align="center">${typeStr}</td>

                <td align="center">${username}</td>
                <td align="center">${tel}</td>
                <td><s:a action="sys_editUser">
                    <s:param name="user.id" value="%{id}"></s:param>
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