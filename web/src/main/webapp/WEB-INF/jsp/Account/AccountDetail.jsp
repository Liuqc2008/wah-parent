<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" import="java.util.*"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
  	<meta charset="utf-8">
  	<title>form</title>
  	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  
  	<link href="/web/Resource/Script/layui/css/layui.css" rel="stylesheet" type="text/css" />
  	
  	<script type="text/javascript" src="/web/Resource/Script/jquery-3.3.1.min.js"></script>
  	<script type="text/javascript" src="/web/Resource/Script/extend.js"></script>
  	<script type="text/javascript" src="/web/Resource/Script/Ajax.js?v1"></script>
  	
  	<script type="text/javascript" src="/web/Resource/Script/layui/layui.js"></script>
  	<!--  
  	<script type="text/javascript" src="/web/Resource/Script/layui/layverify.js"></script>
  	-->
</head>
<body>
	<div style="height:20px;"></div>
	<div class="layui-form">
		<div class="layui-form-item ">
	        <label class="layui-form-label">用户名：</label>
	        <div class="layui-input-inline">
	            <input type="text" id="Name" Value="${account.name}" lay-verify="required|length" param="1,3" lay-verType="tips" autocomplete="off" class="layui-input">
	        </div>
	    </div>
	    <div class="layui-form-item ">
	        <label class="layui-form-label">密码：</label>
	        <div class="layui-input-inline">
	            <input type="text" id="Password" Value="${account.password}" lay-verify="required" lay-verType="tips" autocomplete="off" class="layui-input">
	        </div>
	    </div>
	    <div class="layui-form-item ">
	        <label class="layui-form-label">状态：</label>
	        <div class="layui-input-inline">
	        	<select name="State" id="State" lay-filter="aihao">
			        <option value=""></option>
			        <option value="Disabled">禁用</option>
			        <option value="Enabled" selected="">启用</option>
			 	</select>
	        </div>
	    </div>
	    <div class="layui-form-item">
	        <div class="layui-input-block">
	            <button class="layui-btn" lay-submit="" lay-filter="Submit">保存</button>
	            <button type="reset" class="layui-btn layui-btn-primary" onclick="Close()">关闭</button>
	        </div>
	    </div>
    </div>
	<script>
		var id = ${account.id == null ? 0 : account.id};
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		
		var layer;
		layui.use(['form', 'layedit'], function(){
			var form = layui.form,
		 	layedit = layui.layedit,
			layer = layui.layer;
			
			//监听提交
	        form.on('submit(Submit)', function (data) {
	        	var params = {
                    Id: id,
                    Name: $("#Name").val(),
                    Password: $("#Password").val(),
                    State: $("#State option:selected").val(),
                };
	       		//alert(JSON.stringify(params));
	        	
	        	var url = id == 0 ? "/web/Account/Add" :"/web/Account/Update";
	        	$.Ajax(url, params, function (result) {
	                layer.alert("保存成功！");
	                parent.layer.close(index);
	            });
	        	
	        	return false;
	        });
		});
		
		function Close(){
	        parent.layer.close(index);
	    }
	</script>
</body>
</html>


 
 