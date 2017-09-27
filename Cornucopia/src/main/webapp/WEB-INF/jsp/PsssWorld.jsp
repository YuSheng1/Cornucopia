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
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
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
</script>
<script type="text/javascript">
$(function () {
    $('#formupdate').bootstrapValidator({feedbackIcons: {valid: 'glyphicon glyphicon-ok',invalid: 'glyphicon glyphicon-remove',validating: 'glyphicon glyphicon-refresh' },
        fields: {
             ps1: {
                 message: 'The phone is not valid',
                 validators: {
                     notEmpty: {
                         message: '密码不能为空'
                     },
                     stringLength: {
                         min: 6,
                         max: 11,
                         message: '请输入6-11位密码'
                     },
                     threshold :  11 ,
                     remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
                         url: '/Cornucopia/BgItem/PsssWorldYZ',
                         message: '旧密码错误',//提示消息
                         delay :  5000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                         type: 'POST',//请求方式
                          
                     },
                 }
             },
             ps2: {
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
                         field: 'ps3',
                         message: '两次密码不一致'
                     },
                     different: {//不能和用户名相同
                         field: 'ps1',
                         message: '不能和旧密码相同'
                     },
                     regexp: {//匹配规则
                         regexp: /^[a-zA-Z0-9_\.]+$/,
                         message: '用户名不能为中文'
                     }
                 }
             },
             ps3: {
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
                         field: 'ps2',
                         message: '两次密码不一致'
                     },
                     different: {//不能和用户名相同
                         field: 'ps1',
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
function func(){
	window.top.location.replace('/Cornucopia/BgItem/BgLogin');
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
                       	<form  id="formupdate" method="post"  action="/Cornucopia/PM_UsersItem/updatePassworld">
                            <div class="form-group">
                                <label>请输入旧密码</label>
                                 <input type="text" class="form-control" placeholder="请输入旧密码" style="width: 300px;"  name="ps1" id="ps1"  >
                            </div>
                            <div class="form-group">
                                <label>请输入新密码</label>
                                 <input type="text" class="form-control" placeholder="请输入新密码" style="width: 300px;"  name="ps2" id="ps2"  >
                            </div>
                            <div class="form-group">
                                <label>确认新密码</label>
                                 <input type="text" class="form-control" placeholder="确认新密码" style="width: 300px;"  name="ps3" id="ps3"  >
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary" onclick="func()">立即修改</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
		<!-- /.modal -->
</body>
</html>
