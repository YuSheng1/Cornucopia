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

function update(title,tid,id){
	$("#title").val(title);
	$("#error").val(tid);
	 /* $("#id").val(id); */
}

	
</script>
<script type="text/javascript">
$(function () {
    $('#form').bootstrapValidator({feedbackIcons: {valid: 'glyphicon glyphicon-ok',invalid: 'glyphicon glyphicon-remove',validating: 'glyphicon glyphicon-refresh' },
        fields: {
        	title: {
                message: '标题验证失败',
                validators: {
                    notEmpty: {
                        message: '标题不能为空'
                    },
                    threshold :  3 ,
                remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
                    url: '/Cornucopia/BgNews/boo',
                    message: '标题已存在',//提示消息
                    delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                    type: 'POST',//请求方式
                     
                },
            }
            },
        }
    });
});

$(function () {
    $('#formupdate').bootstrapValidator({feedbackIcons: {valid: 'glyphicon glyphicon-ok',invalid: 'glyphicon glyphicon-remove',validating: 'glyphicon glyphicon-refresh' },
        fields: {
        	title: {
                message: '标题验证失败',
                validators: {
                    notEmpty: {
                        message: '标题不能为空'
                    },
                    threshold :  3 ,
                remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
                    url: '/Cornucopia/BgNews/boo',
                    message: '标题已存在',//提示消息
                    delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                    type: 'POST',//请求方式
                     
                },
            }
            },
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
					<li class="click"><span><img
							src="../BgAssets/images/t01.png" /></span><a class="tablelink"
						data-toggle="modal" data-target="#myModal1">添加</a></li>
			</ul>
		</div>
    <table class="tablelist">
			<thead>
				<tr>
					<th>序号<i class="sort"><img src="../BgAssets/images/px.gif" /></i></th>
        <th>标题</th>
        <th>所属类别</th>
        <th>排序</th>
        <th>添加时间</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="list" varStatus="stat">
        <tr>
        <td>${stat.index+1}</td>
        <td>${list.title}</td>
        <td>${list.newsType.name}</td>
        <td>${list.id}</td>
        <td>${list.addTime}</td>
        <td>
		<h6   onclick="update('${list.title}','${list.newsType.id}','${list.id}')" class="tablelink" data-toggle="modal" data-target="#myModal2"  > 
		       <img src="../BgAssets/images/t02.png" />修改类别信息</h6>
		       <h6 class="tablelink" data-toggle="modal" data-target="#myModal3" onclick="del(${list.id})"> <img src="../BgAssets/images/t03.png" />删除标题</h6>
			</td>
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
                        <h3 class="panel-title">修改标题信息<button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button></h3>
                            
                    </div>

                    <div class="panel-body">
                       	<form  id="formupdate" method="post"  action="/Cornucopia/BgNews/update">
                            <div class="form-group">
                                <label>标题:</label>
                                 <input type="text" class="form-control" placeholder="请输入标题名称"  name="title" id="title"  >
                            </div>
                            <div class="form-group">
                                <label>类&nbsp;别:</label>
                              <select id="error" name="error" class="form-control" >
                               <c:forEach items="${tlist}" var="list" >
          <option class="form-control" id="oid" value="${list.id}"  selected="selected"  >${list.name}</option>
          	</c:forEach>
        </select>
                            </div>
                            <!-- <input style="display: none;"name="id"   id="id"> -->
	<input style="display: none;"name="updTime" value="<%=datetime%>">
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
                       	<form id="form" method="post"  action="/Cornucopia/BgNews/add">
                            <div class="form-group">
                                <label>标题名:</label>
                                 <input type="text" class="form-control" placeholder="请输入标题名称" name="title">
                            </div>
                             <div class="form-group">
                              <label>类&nbsp;别:</label>
                              <select id="error" name="error" class="form-control" >
                              <c:forEach items="${tlist }" var="list" >
          <option class="form-control" id="oid" value="${list.id}"  selected="selected"  >${list.name}</option>
          	</c:forEach>
        </select>
                            </div>
	                      <input style="display: none;" name="addTime" value="<%=datetime%>">
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
                        <h3 class="panel-title">删除标题<button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button></h3>
                    </div>

                    <div class="panel-body">
                       	<form id="form" method="post"  action="/Cornucopia/BgNews/del">
                       	<h4 align="center"   style="font-style: normal;">是否要删除该标题</h4></br></br>
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
    function del(id){
    	$("#delid").val(id);
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
