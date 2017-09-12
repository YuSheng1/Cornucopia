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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
<script language="javascript">
<%String datetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间%>
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
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
    $('form').bootstrapValidator({message: 'This value is not valid',feedbackIcons: {valid: 'glyphicon glyphicon-ok',invalid: 'glyphicon glyphicon-remove',validating: 'glyphicon glyphicon-refresh' },
        fields: {
            title: {
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
            content: {
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
</head>
<body>

	<div class="place">
    <span>公告管理</span>
    </div>
    
    <div class="rightinfo">
    <div class="tools">
    <table>
    <tr>
    <td>
    <ul class="forminfo">
   	 <li><label>标题:</label><input name="" type="text" class="dfinput" placeholder="公告标题"/></li>
    </ul>
    </td>
    <td>
    <div class="tools">
    <ul class="toolbar">
					<li class="click"><span><img
							src="../BgAssets/images/t01.png" /></span><a class="tablelink"
						data-toggle="modal" data-target="#myModal1">添加</a></li>
					<li><span><img src="../BgAssets/images/t03.png" /></span>搜索</li>
			</ul>
	</div>
     </td>
     </tr>
    </table>
    <!-- 
    	<ul class="toolbar">
        <li class="click"><span><img src="../BgAssets/images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="../BgAssets/images/t02.png" /></span>修改</li>
        <li><span><img src="../BgAssets/images/t03.png" /></span>删除</li>
        <li><span><img src="../BgAssets/images/t04.png" /></span>统计</li>
        </ul>
         -->
        
        <!-- 
        <ul class="toolbar1">
        <li><span><img src="../BgAssets/images/t05.png" /></span>设置</li>
        </ul>
         -->
    
    </div>
    
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">序号</th>
    <th>类别</th>
    <th>公告标题</th>
    <th>添加时间</th>
    <th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach items="${plist }" var="e" varStatus="stat">
		<tr>
		<td>${e.id }</td><td>公告</td><td>${e.title }</td><td>${e.create_date }</td>
		<td><a href="">查看</a>
		<li><span><img src="../BgAssets/images/t03.png" /></span><a href="/Cornucopia/push/delete&id=${e.id }">删除</a></li>
		</td>
		</tr>
	</c:forEach>
    
    </tbody>
    
    </table>
   
   <!-- 添加-->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="container" style="margin-top: 50px;">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">添加公告<button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button></h3>
                    </div>

                    <div class="panel-body">
                       	<form id="form" method="post"  action="/Cornucopia/push/save">
                            <div class="form-group">
                                <label>公告标题:</label>
                                 <input type="text" class="form-control" placeholder="请输入公告标题" name="title">
                            </div>
                            <div class="form-group">
                                <label>公告内容:</label>
                               <input  type="text" class="form-control" placeholder="内容" name="content" />
                            </div>
	<input style="display: none;" name="create_date"
									value="<%=datetime%>">

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

     
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>