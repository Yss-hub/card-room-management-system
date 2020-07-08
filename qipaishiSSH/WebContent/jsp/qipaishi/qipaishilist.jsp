<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>棋牌室管理系统</title>
<link href="${pageContext.request.contextPath }/bootstrap/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/bootstrap/bootstrap.min.js"></script>
<script >

function delOne(id){
	//alert(id);
	var sure=window.confirm("确定删除吗？");
	if(sure){
		window.location.href="qipaishi_removeQipaishi.action?qipaishi.id="+id;
	}
}

function order(qipaishiid,vipid,cost){
	//alert(id + ' '+name);
	$('#form_order').get(0).reset();
	$('#form_order [name="order.qipaishiid"]').val(qipaishiid);
	$('#form_order [name="order.vipid"]').val(vipid);
	$('#form_order [name="order.cost"]').val(cost);
	$('#modal_order').modal('show');
}
function saveOrder(){
	var obj = new Object();
	var array = $('#form_order').serializeArray();
	if(array == null || array.length == 0){
		return ;
	}else{
		for(var i=0;i<array.length;i++){
			obj[array[i].name]=array[i].value;
		}
	}
	var number=$('#form_order [name="order.number"]').val();
	if(number==''){
		alert('数量必须填写');
		$('#form_order [name="number"]').focus();
		return false;
	}
	if(number>3){
		alert('数量不能超出3');
		$('#form_order [name="number"]').focus();
		return false;
	}
	$.post('order_save.action',obj,function(data){
		alert(data);
	});
	$('#modal_order').modal('hide');
	
}
</script>
</head>
<body align="center">
<h2>棋牌室信息列表</h2>
<form id="form1" action="qipaishi_findAllQipaishi.action" method="post">
	名称：<s:textfield name="qipaishi.qipaishiname" ></s:textfield>
	
	<input type="submit" value="查询" > 
</form>
<p>
<table width="90%" border="1" align="center">
	<tr>
		<th>棋牌室名称</th>
		<th>棋牌室类型</th>
		<th>棋牌室大小</th>
		<th>价格</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="qipaishis" >
	<tr>
		<td align="center">${qipaishiname}</td>
		<td align="center">${type}</td>
		<td align="center">${size}</td>
		<td align="center">${price}</td>
		
		<td align="center">${state}</td>
		<td>
			
				<s:a href="javascript:order('%{id}','%{#session.user.id}','%{price}')">下单</s:a>
			
			<s:if test="#session.user.type==50||#session.user.type==99">
				<s:a action="qipaishi_editUI">
				<s:param name="qipaishi.id" value="%{id}"></s:param>
				修改
				</s:a>
				<s:a href="javascript:delOne('%{id}')">删除</s:a>
			</s:if>
		 </td>
	</tr>
	</s:iterator>
</table>

<!-- 模态框（Modal）用户登入 -->
<div class="modal fade" id="modal_order" tabindex="-1" role="dialog" aria-labelledby="modal_login_label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modal_login_label">下单</h4>
            </div>
            <div class="modal-body">
            
            <form id="form_order" class="form-horizontal" role="form" onsubmit="return false;">          
            		
				  <div class="form-group">
				    <label for="username" class="col-sm-2 control-label">棋牌室编码</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="order.qipaishiid"  readonly="readonly">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="checkcode" class="col-sm-2 control-label">日期</label>
				    <div class="col-sm-10">
				      <input type="date" class="form-control" name="order.data"  placeholder="日期">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="password" class="col-sm-2 control-label">时间</label>
				    <div class="col-sm-10">
				      <input type="time" class="form-control" name="order.time"  placeholder="时间">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="password" class="col-sm-2 control-label">价格</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="order.cost"  readonly="readonly">
				    </div>
				  </div>
				  
				  
				  <div class="form-group">
				    <label for="checkcode" class="col-sm-2 control-label">数量</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="order.number" placeholder="数量">
				      </div>
				  </div>
				  <input type="hidden" id="id" name="order.vipid" value="${user.id}">
			</form>
             </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="saveOrder()">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>