<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h4>功能列表：</h4>
<ul>
<s:if test="#session.user.type==50|| #session.user.type==99">
  <li>会员管理
    <ul>
	      <li><a href="vip_saveUI.action" target=main>新增会员</a><br></li>
      	<li><a href="vip_findAllVip.action" target=main>会员列表</a>
      	</li>
    </ul>
  </li>
</s:if>

        <li>用户管理
            <ul>
                <s:if test="#session.user.type==99">
                    <li><a href="sys_saveUI.action" target=main>新增用户</a></li>
                </s:if>
                <s:if test="#session.user.type==99">
                <li><a href="sys_findAllUser.action" target=main>用户列表</a></li>
                </s:if>
                <s:if test="#session.user.type==1 || #session.user.type==50">
                    <li><a href="sys_editinfoUI.action" target=main>修改个人信息</a></li>
                </s:if>
            </ul>
        </li>




    <li>棋牌室管理
  	<ul>
  		<s:if test="#session.user.type==50|| #session.user.type==99">
  			<li><a href="qipaishi_saveUI.action" target=main>新增棋牌室 </a> </li>
  		</s:if>
  		<li><a href="qipaishi_findAllQipaishi.action" target=main>棋牌室列表</a> </li>
  	</ul>	
  </li>
<li>订单情况
  	<ul>
  	<s:if test="#session.user.type==1">
  		<li><s:a action="order_findAll.action" target="main">
				<s:param name="order.vipid" value="#session.user.id"></s:param>
				个人订单
				</s:a>
  		</li>
  		</s:if>
  		 <s:if test="#session.user.type==50 || #session.user.type==99">
  		<li><a href="order_findAll.action" target=main>订单汇总</a> </li>
  	</s:if>
  	</ul>	
  </li>
  </ul>
</body>
</html>