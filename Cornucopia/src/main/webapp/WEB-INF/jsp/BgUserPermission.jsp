<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ page import="java.util.*"%>
<!-- //获取系统时间必须导入的 -->
<%@ page import="java.text.*"%>
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
<script src="../assets/js/bootstrap-select.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
<link href="../assets/css/bootstrap-select.css" rel="stylesheet" />

<script type="text/javascript">
<%String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间%>
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});

function add(cname,id,uid){
	$("#cname1").val(cname);
	$("#name").val(cname);
	 $("#error").val(uid);
	
}
	
</script>
<script type="text/javascript">
$(function () {
    $('#form').bootstrapValidator({feedbackIcons: {valid: 'glyphicon glyphicon-ok',invalid: 'glyphicon glyphicon-remove',validating: 'glyphicon glyphicon-refresh' },
        fields: {
        	user_name: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    threshold :  3 ,
                remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
                    url: '/Cornucopia/PM_UsersItem/boo',
                    message: '用户已存在',//提示消息
                    delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                    type: 'POST',//请求方式
                     
                },
            }
            },
            name: {
                 validators: {
                     notEmpty: {
                         message: '昵称不能为空'
                     }
                 }
             },
             mobile_Phone: {
                 message: 'The phone is not valid',
                 validators: {
                     notEmpty: {
                         message: '手机号码不能为空'
                     },
                     stringLength: {
                         min: 11,
                         max: 11,
                         message: '请输入11位手机号码'
                     },
                     regexp: {
                         regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                         message: '请输入正确的手机号码'
                     },
                     threshold :  11 ,
                     remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
                         url: '/Cornucopia/PM_UsersItem/booPhone',
                         message: '手机号已经被注册',//提示消息
                         delay :  5000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                         type: 'POST',//请求方式
                          
                     },
                 }
             },
             password: {
                 message: '密码无效',
                 validators: {
                     notEmpty: {
                         message: '密码名不能为空'
                     },
                     stringLength: {
                         min: 4,
                         max: 30,
                         message: '密码长度必须在4到30之间'
                     },
                     identical: {//相同
                         field: 'repassword',
                         message: '两次密码不一致'
                     },
                     different: {//不能和用户名相同
                         field: 'user_name',
                         message: '不能和用户名相同'
                     },
                     regexp: {//匹配规则
                         regexp: /^[a-zA-Z0-9_\.]+$/,
                         message: '用户名不能为中文'
                     }
                 }
             },
             repassword: {
                 message: '密码无效',
                 validators: {
                     notEmpty: {
                         message: '密码名不能为空'
                     },
                     stringLength: {
                         min: 4,
                         max: 30,
                         message: '密码长度必须在4到30之间'
                     },
                     identical: {//相同
                         field: 'password',
                         message: '两次密码不一致'
                     },
                     different: {//不能和用户名相同
                         field: 'user_name',
                         message: '不能和用户名相同'
                     },
                     regexp: {//匹配规则
                         regexp: /^[a-zA-Z0-9_\.]+$/,
                         message: '密码不能为中文'
                     }
                 }
             }
            
        }
    });
});
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
				<shiro:hasPermission name="添加管理用户">
					<li class="click"><span><img
							src="../BgAssets/images/t01.png" /></span><a class="tablelink"
						data-toggle="modal" data-target="#myModal1">添加</a></li>
				</shiro:hasPermission>
			</ul>
		</div>
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>用户名</th>
         <th>昵称</th>
          <th>密码</th>
           <th>密码盐</th>
           <th>电话</th>
           <th>状态</th>
        <th>是否删除</th>
        <th>身份</th>
        <th>创建时间</th>
         <th>修改时间</th>
          <th>角色</th>
              <shiro:hasPermission name="修改管理用户角色">
          <th>更改用户角色</th>
                 </shiro:hasPermission>
                   <shiro:hasPermission name="删除管理用户">
          <th>删除管理用户</th>
                 </shiro:hasPermission>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${UsersList}" var="e" >
        <tr>
        <td>${e.user_name }</td>
        <td>${e.name}</td>
        <td>${e.password }</td>
        <td>${e.salt }</td>
        <td>${e.mobile_Phone}</td>
        <td>${e.status }</td>
        <td>${e.del_flag}</td>
        <td>${e.identity}</td>
        <td>${e.create_date}</td>
        <td>${e.update_date}</td>
        <td>${e.userrole.cname}</td>
        <shiro:hasPermission name="修改管理用户角色">
       <td> <h6 class="tablelink" data-toggle="modal" data-target="#myModal2" onclick="add('${e.user_name }',${e.id },'${e.userrole.id}')"> <img src="../BgAssets/images/t05.png" />修改用户角色</h6></td>
       </shiro:hasPermission>
       <shiro:hasPermission name="删除管理用户">
     <td> <h6 class="tablelink" data-toggle="modal" data-target="#myModal3" onclick="del(${e.id},'${e.user_name }')"> <img src="../BgAssets/images/t03.png" />删除角色</h6>
      </td> </shiro:hasPermission>
        </tr> 
        </c:forEach>
        </tbody>
    </table>
    
    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
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
                       	<form  id="formupdate" method="post"  action="/Cornucopia/PM_UsersItem/update">
                            <div class="form-group">
                                <label>用户名:</label>
                                 <input type="text" class="form-control" placeholder="请输入角色名称" readonly name="cname1" id="cname1"  >
                            </div>
                            <div class="form-group">
                                <label>角&nbsp;色:</label>
                              <select id="error" name="error" class="form-control" >
                               <c:forEach items="${UserRole}" var="u" >
          <option class="form-control" id="oid" value="${u.id}"  selected="selected"  >${u.cname}</option>
          	</c:forEach>
        </select>
                            </div>
	<input style="display: none;"name="update_date" value="<%=datetime%>">
    <input style="display: none;"name="name"   id="name">
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
                       	<form id="form" method="post"  action="/Cornucopia/PM_UsersItem/add">
                            <div class="form-group">
                                <label>用户名:</label>
                                 <input type="text" class="form-control" placeholder="请输入角色名称" name="user_name">
                            </div>
                            <div class="form-group">
                                <label>昵称:</label>
                               <input  type="text" class="form-control" placeholder="请输入用户昵称" name="name" />
                            </div>
                            <div class="form-group">
                                <label>密码:</label>
                               <input  type="text" class="form-control" placeholder="请输入密码" name="password" />
                            </div>
                             <div class="form-group">
                                <label>确认密码:</label>
                               <input  type="text" class="form-control" placeholder="确认密码" name="repassword" />
                            </div>
                            <div class="form-group">
                                <label>手机号码:</label>
                               <input  type="text" class="form-control" placeholder="请输入手机号码" name="mobile_Phone" />
                            </div>
                             <div class="form-group">
                              <label>角&nbsp;色:</label>
                              <select id="error" name="error" class="form-control" >
                              <c:forEach items="${UserRole}" var="u" >
          <option class="form-control" id="oid" value="${u.id}"  selected="selected"  >${u.cname}</option>
          	</c:forEach>
        </select>
                            </div>
	                      <input style="display: none;" name="create_date" value="<%=datetime%>">
	                       <input style="display: none;"name="update_date" value="<%=datetime%>">

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
                       	<form id="form" method="post"  action="/Cornucopia/PM_UsersItem/del">
                       	<h4 align="center"   style="font-style: normal;">是否要删除该角色</h4></br></br>
                       	 <input style="display: none;"name="delid"   id="delid">
                       	  <input style="display: none;"name="delname"   id="delname">
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
    function del(id,delname){
    	$("#delid").val(id);
    	$("#delname").val(delname);
    }
  
	$('.tablelist tbody tr:odd').addClass('odd');
	$(window).on('load', function () {
	    $('#usertype').selectpicker({
	        'selectedText': 'cat'
	    });
	});
	</script>
</body>
</html>
