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
  
  	<link href="/MavenSSM/Resource/Script/layui/css/layui.css" rel="stylesheet" type="text/css" />
  	
  	<script type="text/javascript" src="/MavenSSM/Resource/Script/jquery-3.3.1.min.js"></script>
  	<script type="text/javascript" src="/MavenSSM/Resource/Script/extend.js"></script>
  	<script type="text/javascript" src="/MavenSSM/Resource/Script/Ajax.js"></script>
  	
  	<script type="text/javascript" src="/MavenSSM/Resource/Script/layui/layui.js"></script>
  	<!--  
  	<script type="text/javascript" src="/MavenSSM/Resource/Script/layui/layverify.js"></script>
  	-->
</head>
<body>
	<div class="layui-form">
		<div class="layui-form-item ">
	        <label class="layui-form-label">名称：</label>
	        <div class="layui-input-inline">
	            <input type="text" id="Name" Value="${role.name}" lay-verify="required" lay-verType="tips" autocomplete="off" class="layui-input">
	        </div>
	    </div>
	    <div class="layui-form-item ">
	        <label class="layui-form-label">备注：</label>
	        <div class="layui-input-inline">
	            <input type="text" id="Desc" Value="${role.desc}" autocomplete="off" class="layui-input">
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
		var id = ${role.id == null ? 0 : role.id};
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
                    Desc: $("#Desc").val(),
                };
	        	
	        	var url = id == 0 ? "/MavenSSM/Role/Add" :"/MavenSSM/Role/Update";
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


 
 