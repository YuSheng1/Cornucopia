<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ page import="java.util.*"%>
<!-- //获取系统时间必须导入的 -->
<%@ page import="java.text.*"%>
<!--  获取系统时间必须导入的 -->
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
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />

<script type="text/javascript">

$(function () {
    $('#form').bootstrapValidator({feedbackIcons: {valid: 'glyphicon glyphicon-ok',invalid: 'glyphicon glyphicon-remove',validating: 'glyphicon glyphicon-refresh' },
        fields: {
            cname: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    threshold :  3 ,
                remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
                    url: '/Cornucopia/PM_RolesItem/boo',
                    message: '用户已存在',//提示消息
                    delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                    type: 'POST',//请求方式
                     
                },
            }
            },
            remark: {
                 validators: {
                     notEmpty: {
                         message: '备注不能为空'
                     }
                 }
             }
            
        }
    });
    $('#formupdate').bootstrapValidator({feedbackIcons: {valid: 'glyphicon glyphicon-ok',invalid: 'glyphicon glyphicon-remove',validating: 'glyphicon glyphicon-refresh' },
        fields: {
            remark: {
                 validators: {
                     notEmpty: {
                         message: '备注不能为空'
                     }
                 }
             }
            
        }
    });
});
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
<%String datetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间%>
 var cid=0;
 function cc(id) {  
	 cid=id;
     var setting = {  
        check: {  
            enable: true,  
            chkStyle: "checkbox",  
            chkboxType : { "Y" : "ps", "N" : "ps" }  
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
        }   
    };  
 $.fn.zTree.init($("#treeDemo"), setting); 
 }
 //获取所有选中节点的值
 function GetCheckedAll() {
     var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
     var nodes = treeObj.getCheckedNodes(true);
     var msg = "";
     for (var i = 0; i < nodes.length; i++) {
         msg += nodes[i].id+",";
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
</SCRIPT>
<script type="text/javascript">
    function update(cname,remake,id,createdate){
    	$("#cname1").val(cname);
    	$("#remark").val(remake);
    	$("#id").val(id);
    	<!--用于验证有没有这个角色-->
    	$("#createdate1").val(createdate);
    	
    }
    function del(id){
    	$("#delid").val(id);
    }



</script>
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
				<shiro:hasPermission name="添加角色">
					<li class="click"><span><img
							src="../BgAssets/images/t01.png" /></span><a class="tablelink"
						data-toggle="modal" data-target="#myModal1">添加</a></li>
				</shiro:hasPermission>
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
					<shiro:hasPermission name="修改角色权限">
					<th>修改权限</th>
					</shiro:hasPermission>
					<shiro:hasPermission name="修改角色信息">
					<th>修改角色信息</th>
					</shiro:hasPermission>
					<shiro:hasPermission name="删除角色">
					<th>删除角色</th>
					</shiro:hasPermission>
				
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
						<shiro:hasPermission name="修改角色权限">
						<td>
						<h6 class="tablelink" data-toggle="modal" data-target="#myModal" onclick="cc(${e.id })"> <img src="../BgAssets/images/t05.png" />修改权限</h6>
							</td>
							</shiro:hasPermission>
							<shiro:hasPermission name="修改角色信息">
						<td>
						<h6 onclick="update('${e.cname}','${e.remark }',${e.id },'${e.create_date }')" class="tablelink" data-toggle="modal" data-target="#myModal2" > <img src="../BgAssets/images/t02.png" />修改角色信息</h6>
							</td>
						</shiro:hasPermission>
						<shiro:hasPermission name="删除角色">
						<td>
						<h6 class="tablelink" data-toggle="modal" data-target="#myModal3" onclick="del(${e.id })"> <img src="../BgAssets/images/t03.png" />删除角色</h6>
						</td>
							</shiro:hasPermission>
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
	<!-- 树插件 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
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
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							onclick="GetCheckedAll()">提交更改</button>
					</div>
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- 添加-->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="container" style="margin-top: 50px;">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">添加角色<button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button></h3>
                    </div>

                    <div class="panel-body">
                       	<form id="form" method="post"  action="/Cornucopia/PM_RolesItem/add">
                            <div class="form-group">
                                <label>用户名:</label>
                                 <input type="text" class="form-control" placeholder="请输入角色名称" name="cname">
                            </div>
                            <div class="form-group">
                                <label>角色备注:</label>
                               <input  type="text" class="form-control" placeholder="备注" name="remark" />
                            </div>
	<input style="display: none;" name="createdate"
									value="<%=datetime%>"> <input style="display: none;"
									name="updatedate" value="<%=datetime%>">

                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">立即添加</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
		<!-- /.modal -->
	</div>
	
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="container" style="margin-top: 50px;">
        <div class="row">
        
            <div class="col-lg-4 col-lg-offset-4">
            
                <div class="panel panel-default">
                
                    <div class="panel-heading">
                        <h3 class="panel-title">修改角色信息<button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button></h3>
                            
                    </div>

                    <div class="panel-body">
                       	<form  id="formupdate" method="post"  action="/Cornucopia/PM_RolesItem/update">
                            <div class="form-group">
                                <label>用户名:</label>
                                 <input type="text" class="form-control" placeholder="请输入角色名称" readonly name="cname1" id="cname1"  >
                            </div>
                            <div class="form-group">
                                <label>角色备注:</label>
                               <input  type="text" class="form-control" placeholder="备注" name="remark"  id="remark"/>
                            </div>
	<input style="display: none;"name="update_date" value="<%=datetime%>">
    <input style="display: none;"name="id"   id="id">
            <input style="display: none;" name="createdate1"   id="createdate1" value="">

                            <div class="form-group">
                                <button type="submit" class="btn btn-primary" >立即修改</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
		<!-- /.modal -->
	</div>
		<!-- 删除-->
		<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="container" style="margin-top: 50px;">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">删除角色<button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button></h3>
                    </div>

                    <div class="panel-body">
                       	<form id="form" method="post"  action="/Cornucopia/PM_RolesItem/del">
                       	<h4 align="center"   style="font-style: normal;">是否要删除该角色</h4></br></br>
                       	 <input style="display: none;"name="delid"   id="delid">
                                 <button type="button" class="btn btn-default" data-dismiss="modal">取消操作</button>
                                <button type="submit" class="btn btn-primary" style="margin-left: 50px;">立即删除</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
