<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" import="java.util.*"%>
 
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
  	
  	<script type="text/javascript" src="/web/Resource/Script/layui/layui.js"></script>
  	<script type="text/javascript" src="/web/Resource/Script/Ajax.js"></script>
</head>
<body>
	<div style="height:20px;"></div>
	<div class="demoTable">
  		用户名：
	  	<div class="layui-inline">
	    	<input class="layui-input" name="name" id="name" autocomplete="off">
	  	</div>
	  	密码：
	  	<div class="layui-inline">
	    	<input class="layui-input" name="password" id="password" autocomplete="off">
	  	</div>
	  	创建时间:
	  	<div class="layui-inline">
            <input type="text" class="layui-input" name="startTime" id="startTime" placeholder="yyyy-MM-dd">
        </div>
        <div class="layui-inline">
        	<input type="text" class="layui-input" name="endTime" id="endTime" placeholder="yyyy-MM-dd">
	  	</div>
  		<button class="layui-btn" data-type="reload">搜索</button>
	</div>
	
	<div class="layui-btn-group demoTable">
	    <button class="layui-btn layui-btn-sm" data-type="Add">新增</button>
   		<button class="layui-btn layui-btn-sm" data-type="getCheckData">获取选中行数据</button>
   		<button class="layui-btn layui-btn-sm" data-type="getCheckLength">获取选中数目</button>
   		<button class="layui-btn layui-btn-sm" data-type="isAll">验证是否全选</button>
	</div>
	
	<table class="layui-hide" id="test" lay-filter="demo"></table>
	
    <script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>       
	   
	<script>
	$(function(){
		document.onkeydown = function(e){ 
		  	var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	Reload();
		        return false;
		     }
		}
	});
	
	var layui;
	layui.use(['layer', 'element', 'form', 'table', 'laydate'], function(){
		layer = layui.layer;
		var table = layui.table,
        	form = layui.form,
        	element = layui.element,
        	laydate = layui.laydate;
	  
  		table.render({
	    	elem: '#test',
	    	url:'/web/Common/GetPageData?reportName=GetUserPageList',
	    	cols: [[
				//{type: 'numbers' },
				{checkbox: true, fixed: 'left'},
                {field:'right', title: '操作', width: 130, toolbar: "#barDemo", align: 'center' },
	      		{field:'id', width:80, title: 'Id', align: 'center', sort: true},
	      		{field:'name', width:130, align: 'center', title: '用户名'},
	      		{field:'password', width:180, align: 'center', title: '密码'},
	      		{field:'createDate', width:180, align: 'center', title: '创建时间'},
	    	]],
	    	id: 'testReload',
	    	page: true,
	    	height: 'full-200',
	  	});
  		
  		//监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.id + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('确定删除该行？', function (index) {
                    $.Ajax("/web/User/Delete?id=" + data.id, {}, function (result) {
                        layer.alert("删除成功！");
                        Reload();
                        layer.close(index);
                    });

                });
            } else if (obj.event === 'edit') {
            	OpenFrame("修改用户信息", "/web/User/UserDetail?id=" + data.id, 460, 300, '', Reload);
            }
        });
        
  		var $ = layui.$, active = {
			getCheckData: function(){ //获取选中数据
		 		var checkStatus = table.checkStatus('testReload'),
		      		data = checkStatus.data;
			      	layer.alert(JSON.stringify(data));
	    	},
			getCheckLength: function(){ //获取选中数目
			   	var checkStatus = table.checkStatus('testReload'),
			      	data = checkStatus.data;
			    layer.msg('选中了：'+ data.length + ' 个');
			},
			isAll: function(){ //验证是否全选
			 	var checkStatus = table.checkStatus('testReload');
			   	layer.msg(checkStatus.isAll ? '全选': '未全选')
			},
			Add: function () {
	         	OpenFrame("新增用户", "/web/User/UserDetail", 460, 300, '', Reload);
	        },	
  			reload: function(){
 			 	table.reload('testReload', {
  			      	page: {
  			          curr: 1 //重新从第 1 页开始
  			        },
  			        where: {
  			          	key: {
  			          		name: $('#name').val(),
  			          		password: $('#password').val(),
  			          		startTime: $('#startTime').val(),
  			          		endTime: $('#endTime').val(),
  			          	}
  			        }
  			   	});
  			},
  		};
  			 
  		var start = laydate.render({
            elem: '#startTime',
            done: function (value, date, endDate) {
                end.config.min = {
                    year: date.year,
                    month: date.month - 1,
                    date: date.date,
                }
            }
        });

        var end = laydate.render({
            elem: '#endTime',
            done: function (value, date, endDate) {
                start.config.max = {
                    year: date.year,
                    month: date.month - 1,
                    date: date.date,
                }
            }
        });
  		
  		$('.demoTable .layui-btn').on('click', function(){
  			var type = $(this).data('type');
  			active[type] ? active[type].call(this) : '';
  		});
  		
  		window.Reload = function Reload() {
  			active['reload'].call();
         }
	});
	</script>

</body>
</html>


 
 