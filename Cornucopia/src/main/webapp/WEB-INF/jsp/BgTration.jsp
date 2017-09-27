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

 <script type="text/javascript"  src="/Cornucopia/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript"  src="/Cornucopia/utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript"  src="/Cornucopia/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

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
    		<form action="/Cornucopia/BgNews/BgTration" method="post">
标题：<input type="text" name="title" class="width=200px" placeholder="标题名称....">
所属类别：<select name="typeId">
<option value="-1">全部</option>
				<c:forEach items="${tlist }" var="list" >
		<option value="${list.id}">${list.name}</option>
		</c:forEach>
		</select>
<input type="submit" value="搜索"  class="btn btn-primary" style="margin-left: 15px;">
								</form>
     <div class="tools" style="margin-left: 400px;margin-top: -35px;">
			<ul class="toolbar" >
					<li class="click" ><span><img
							src="../BgAssets/images/t01.png" /></span><a class="tablelink"
						data-toggle="modal" data-target="#myModal1">添加</a></li>
			</ul>
		</div>
    <table class="tablelist"   id="t_student">
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
		      <h6> <img src="../BgAssets/images/t02.png" /><a href="/Cornucopia/BgNews/updatebyid?id=${list.id}">修改类别信息</a></h6>
		       <h6 class="tablelink" data-toggle="modal" data-target="#myModal3" onclick="del(${list.id})"> <img src="../BgAssets/images/t03.png" />删除标题</h6>
			</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
    
    	  <div class="pagin">
<div class="gridItem" style=" padding: 5px; width: 300px; float: left; text-align: left; height: 30px; line-height:30px; font-size: 15px;" > 
			        共有 <span id="spanTotalInfor" style="color: red;font-weight: bold;"></span> 条记录 ,    
			        当前第 <span id="spanPageNum" style="color: red;font-weight: bold;"></span> 页    , 
			        共 <span id="spanTotalPage" style="color: red;font-weight: bold;"></span> 页
		    </div>
    		<div class="gridItem" style="margin-left:45px;  padding: 5px; width: 400px; float: left; text-align: center; height: 30px; line-height:30px; vertical-align: middle; font-size: 15px;">   
	            <span id="spanFirst" >首页</span> 
	            <span id="spanPre">上一页</span>
	            <span id="spanInput" style="margin: 0px; padding: 0px 0px 4px 0px; height:100%; "> 
                	第<input id="Text1" type="text" class="TextBox" onkeyup="changepage()"   style="height:20px; text-align: center;width:50px" />页 
            	</span>
	            <span id="spanNext">下一页</span> 
	            <span  id="spanLast">尾页</span> 
        	</div>

		</div>
	</div>

    
	
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="container" style="margin-top: 50px;">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">添加标题<button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button></h3>
                    </div>

                    <div class="panel-body">
                       	<form id="form" method="post"  action="/Cornucopia/BgNews/add">
                            <div class="form-group">
                                <label>标题名称:</label>
                                 <input type="text" class="form-control" placeholder="请输入标题名称" name="title">
                            </div>
                            <div class="form-group">
                                <label>类&nbsp;别:</label>
                              <select id="error" name="error" class="form-control" >
                               <c:forEach items="${tlist}" var="list" >
          <option class="form-control" id="oid" value="${list.id}"  selected="selected"  >${list.name}</option>
          	</c:forEach>
        </select>
                            </div>
                               <div>
									<!-- 加载编辑器的容器 -->  
									标题内容
									<script id="container" name="text" type="text/plain" ></script>  
									<!-- 配置文件 -->  
									<!-- 编辑器源码文件 -->  
									<!-- 实例化编辑器 -->  
									<script type="text/javascript">  
									    var ue = UE.getEditor('container');  
									</script> 
								</div>
									<input style="display: none;" name="addTime"
									value="<%=datetime%>">
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary" >立即添加</button>
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
	<script type="text/javascript">
            var theTable = document.getElementById("t_student");
            var txtValue = document.getElementById("Text1").value;
            function changepage() {
                var txtValue2 = document.getElementById("Text1").value;
                if (txtValue != txtValue2) {
                    if (txtValue2 > pageCount()) {

                    }
                    else if (txtValue2 <= 0) {

                    }
                    else if (txtValue2 == 1) {
                        first();
                    }
                    else if (txtValue2 == pageCount()) {
                        last();
                    }
                    else {
                        hideTable();
                        page = txtValue2;
                        pageNum2.value = page;

                        currentRow = pageSize * page;
                        maxRow = currentRow - pageSize;
                        if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;
                        for (var i = maxRow; i < currentRow; i++) {
                            theTable.rows[i].style.display = '';
                        }
                        if (maxRow == 0) { preText(); firstText(); }
                        showPage();
                        nextLink();
                        lastLink();
                        preLink();
                        firstLink();
                   }

                    txtValue = txtValue2;
                }
            }
            
    </script>
	<script src="../assets/js/Pagging.js"></script>
</body>
</html>
