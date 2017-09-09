<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理系统HTML模板--模板之家 www.cssmoban.com</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />

<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip1").show();
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>
 <SCRIPT type="text/javascript">
 var cid=0;
 function cc(id) {  
	 cid=id;
     var setting = {  
        check: {  
            enable: true,  
            chkStyle: "checkbox",  
            chkboxType : { "Y" : "s", "N" : "p" }  
        },  
        //获取json数据  
        async : {    
            enable : true,   
            url : "Ztree", // Ajax 获取数据的 URL 地址    
            autoParam : [ "id", "name" ], //ajax提交的时候，传的是id值  
            otherParam: { "id":id}
        },    
        data:{ // 必须使用data    
            simpleData : {    
                enable : true,    
                idKey : "id", // id编号命名     
                pIdKey : "pId", // 父id编号命名      
                rootId : 0  
            }    
            },    
        // 回调函数    
        callback : {    
            onClick : function(event, treeId, treeNode, clickFlag) { 
            },    
            //捕获异步加载出现异常错误的事件回调函数 和 成功的回调函数    
            onAsyncSuccess : function(event, treeId, treeNode, msg){    
            },  
            beforeClick: beforeClick,  
        }   
            
    };  
 $.fn.zTree.init($("#treeDemo"), setting); 
 }
 //获取所有选中节点的值
 function GetCheckedAll() {
     var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
     var nodes = treeObj.getCheckedNodes(true);
     var msg = "name--id--pid\n";
     for (var i = 0; i < nodes.length; i++) {
         msg += nodes[i].name+"--"+nodes[i].id+"--"+nodes[i].pId+"\n";
     }
     $.ajax({
         async : false,
         cache : false,
         timeout: 1000,
         url: '/Cornucopia/PM_RolesItem/PM_RolesAdd?id='+cid,
         type: "post",
         data:{"msg":msg,"id":cid}
     });
     window.close();     
      
 }    
    function beforeClick(treeId, treeNode) {  
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
        zTree.checkNode(treeNode, treeNode.checked, null, true);  
        return false;  
    }  
    var code;  
      
    function showCode(str) {  
        if (!code) code = $("#code");  
        code.empty();  
        code.append("<li>"+str+"</li>");  
    }  
      
  
     //确定按钮
   function getSelectedNodes()  
   {  
        var zTree = $.fn.zTree.getZTreeObj("treeDemo"),  
        nodes = zTree.getCheckedNodes(true),
        deletenodes = zTree.getCheckedNodes(false); 
        codes = "";
        names = "";  
        var ids="";  
        for (var i=0, l=nodes.length; i<l; i++) {  
        	codes += nodes[i].code + ",";  
            names += nodes[i].name + ",";  
            ids+=nodes[i].id+",";  
        }  
        //删除的元素  
        deleteids="";  
        for (var i=0, l=deletenodes.length; i<l; i++) {  
        	deleteids+=deletenodes[i].id+",";  
        }  
        if (deleteids.length > 0 ) deleteids = deleteids.substring(0, deleteids.length-1);  
        
        //给父窗体中所属分类赋值  
         $("#addDeptIds",parent.document).val(ids);
         $("#deleteDeptIds",parent.document).val(deleteids);
         $("#deptName",parent.document).val(names);
         winClose();
   }  
   	//关闭按钮
   function  winClose()  
	{  
		var parentBody = $(window.parent.document);
		parentBody.find('#prepay_cav_popup_userpopbox').hide();
		parentBody.find('#prepay_cav_popup_userframe').hide();
	}
</SCRIPT>  
</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据表</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
	</div>
	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<li class="click"><span><img
						src="../BgAssets/images/t01.png" /></span>添加</li>
				<li class="click"><span><img
						src="../BgAssets/images/t02.png" /></span>修改</li>
				<li><span><img src="../BgAssets/images/t03.png" /></span>删除</li>
				<li><span><img src="../BgAssets/images/t04.png" /></span>统计</li>
			</ul>


			<ul class="toolbar1">
				<li><span><img src="../BgAssets/images/t05.png" /></span>设置</li>
			</ul>

		</div>

		<table class="tablelist">
			<thead>
				<tr>
					<th>编号<i class="sort"><img src="../BgAssets/images/px.gif" /></i></th>
					<th>角色名</th>
					<th>备注</th>
					<th>创建时间</th>
					<th>修改时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${UserRoleList}" var="e" varStatus="stat">
					<tr>
						<td>${e.id }</td>
						<td>${e.cname}</td>
						<td>${e.remark }</td>
						<td>${e.create_date }</td>
						<td>${e.update_date }</td>
						<td><a class="tablelink" data-toggle="modal"
							data-target="#myModal" onclick="cc(${e.id })" >编辑信息</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<div class="pagin">
			<div class="message">
				共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"><a href="javascript:;"><span
						class="pagepre"></span></a></li>
				<li class="paginItem"><a href="javascript:;">1</a></li>
				<li class="paginItem current"><a href="javascript:;">2</a></li>
				<li class="paginItem"><a href="javascript:;">3</a></li>
				<li class="paginItem"><a href="javascript:;">4</a></li>
				<li class="paginItem"><a href="javascript:;">5</a></li>
				<li class="paginItem more"><a href="javascript:;">...</a></li>
				<li class="paginItem"><a href="javascript:;">10</a></li>
				<li class="paginItem"><a href="javascript:;"><span
						class="pagenxt"></span></a></li>
			</ul>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"  >
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">角色权限管理</h4>
				</div>
				<div class="modal-body">
				 <ul id="treeDemo" class="ztree"></ul> 
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" onclick="GetCheckedAll()">提交更改</button>
				</div>
				</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
					
				
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
