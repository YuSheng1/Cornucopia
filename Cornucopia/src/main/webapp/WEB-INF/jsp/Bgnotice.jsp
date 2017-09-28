<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

 <script type="text/javascript"  src="/Cornucopia/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript"  src="/Cornucopia/utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript"  src="/Cornucopia/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
    
<script language="javascript">
<%String datetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间%>

</script>
<script type="text/javascript">
$(function () {
    $('#form').bootstrapValidator({message: 'This value is not valid',feedbackIcons: {valid: 'glyphicon glyphicon-ok',invalid: 'glyphicon glyphicon-remove',validating: 'glyphicon glyphicon-refresh' },
        fields: {
            title: {
                message: '标题验证失败',
                validators: {
                    notEmpty: {
                        message: '标题不能为空'
                    },
                    threshold :  3 ,
                remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
                    url: '/Cornucopia/push/boo',
                    message: '标题已存在',//提示消息
                    delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                    type: 'POST',//请求方式
                     
                },
            }
            },
            content: {
                 validators: {
                     notEmpty: {
                         message: '内容不能为空',
                     }
                 }
             }
            
        }
    });
});

</script>

</head>
<body>
<form method="post" id="form1	">
	<div class="place">
    <span>公告管理</span>
    </div>
    
    <div class="rightinfo">
    <div class="tools">
    <tr>
    <td>
    <div class="tools">
   
	<ul class="toolbar">
    <form  id="form1" method="post"  action="/Cornucopia/push/list">
   	 <label>标题:</label><input name="title1" type="text" class="dfinput" placeholder="公告标题"/>	 	
            <button type="submit" class="btn btn-primary">搜索</button>  
	</form>
    </ul>
     <ul class="toolbar1">
					<li class="click"><span><img
							src="../BgAssets/images/t01.png" /></span><a class="tablelink"
						data-toggle="modal" data-target="#myModal1">添加</a></li>
			</ul>
	</div>
     </td>
     </tr>
    
    </div>
    
    
    <table class="imgtable ">
    
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
		<td>
	<ul class="menuson">
        <li><a class="btn btn-primary" style="width: 80px;" href="/Cornucopia/push/cha?id=${e.id}" target="rightFrame">查看</a></li>
        <li><a class="btn btn-primary" style="width: 80px;" href="/Cornucopia/push/updatebyid?id=${e.id}" target="rightFrame">编辑</a></li>
    
    </ul>
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
                               <div>
									<!-- 加载编辑器的容器 -->  
									标题内容
									<script id="container" name="content" type="text/plain" ></script>  
									<!-- 配置文件 -->  
									<!-- 编辑器源码文件 -->  
									<!-- 实例化编辑器 -->  
									<script type="text/javascript">  
									    var ue = UE.getEditor('container');  
									</script> 
								</div>
									<input style="display: none;" name="create_date"
									value="<%=datetime%>">
										<input style="display: none;" name="create_date1"
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
	
    <div class="pagin" style="text-align: center;">
    <div class="message">共<i class="blue">${pb.total1 }</i>条记录，当前显示第&nbsp;<i class="blue">${pb.page1 }</i>页</div> 
    	<a class="btn btn-primary" style="width: 80px;" href="/Cornucopia/push/list?flag=first&page1=${pb.page1 }">首页</a>
		<a class="btn btn-primary" style="width: 80px;" href="/Cornucopia/push/list?flag=up&page1=${pb.page1 }">上一页</a>
		<a class="btn btn-primary" style="width: 80px;" href="/Cornucopia/push/list?flag=next&page1=${pb.page1 }">下一页</a>
		<a class="btn btn-primary" style="width: 80px;" href="/Cornucopia/push/list?flag=last&page1=${pb.page1 }">末页</a>
    </div>
    </div>
</form>
     
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>