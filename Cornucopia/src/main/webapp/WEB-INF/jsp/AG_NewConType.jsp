<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="../assets/css/amazeui.css" />
  <link rel="stylesheet" href="../assets/css/common.min.css" />
<script type="text/javascript" src="/resources/web/layer/layer.js"></script>
<script src="/resources/web/echart/dist/echarts.js"></script>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<link href="../assets/resources/css/common.css" rel="stylesheet">
<link href="../assets/resources/css/jw.css" rel="stylesheet">
<link href="../assets/resources/css/iconfont.css" rel="stylesheet">
<script src="../assets/resources/js/echarts.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
   <SCRIPT LANGUAGE="javascript">
function fun(id){
	window.open("/Cornucopia/BgType/NewsByIdA?id="+id,"","width=800,height=800,top=100")
}


</SCRIPT> 
</head>
<body>
<p>新闻类别</p><ul class="nav nav-pills nav-stacked">
   <c:forEach items="${news}" var="e" >
   <li class="active"><a  href="" onclick="fun(${e.id})">${e.title}</a></li>
 </c:forEach></ul>
</body>
</body>
</html>