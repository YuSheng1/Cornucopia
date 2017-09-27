<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<!-- //获取系统时间必须导入的 -->
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<script type="text/javascript" src="../BgAssets/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../BgAssets/js/select-ui.min.js"></script>
<script type="text/javascript" src="../BgAssets/editor/kindeditor.js"></script>
<link href="../assets/css/bootstrap-select.css" rel="stylesheet" />
<script type="text/javascript"  src="/Cornucopia/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript"  src="/Cornucopia/utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript"  src="/Cornucopia/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
    
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
<%String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间%>

</script>
</head>
<body>
<form id="form1" method="post"  action="/Cornucopia/BgNews/update">
<h1>
查看内容
</h1>

	<ul class="forminfo">
		<li><input type="hidden" name="id" value="${news.id }"></li>
		<li><input style="display: none;"id="addTime" name="addTime" value="<%=datetime%>"></li>
    	<li><label>标题：</label><input name="title" type="text" class="dfinput" value="${news.title }"  style="width:518px;"/></li>
          <label>类&nbsp;别:</label>
                              <select  name="newsType.id" >
                              <option id="oid" value="-1"  selected="selected"  >请选择</option>
                               <c:forEach items="${tlist}" var="list" >
          <option  id="oid" value="${list.id}"  selected="selected"  >${list.name}</option>
          	</c:forEach>
        </select>
    </ul>
		<div style="margin-top: 50px">
		<!-- 加载编辑器的容器 -->  
				内容
				<script id="container" name="text" type="text/plain">${news.text }</script>  
				<!-- 配置文件 -->  
				<!-- 编辑器源码文件 -->  
				<!-- 实例化编辑器 -->  
				<script type="text/javascript">  
				    var ue = UE.getEditor('container');  
				</script>  
		</div>
		
		<button type="submit" class="btn btn-primary" >保存修改</button>  
</form>
</body>
</html>