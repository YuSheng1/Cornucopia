<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
</head>
<body  style="background:#f0f9fd;">
    <div class="place" style="color: blue;font-size: 20px">
    <span>位置：</span>
    <ul class="placeul">
    <li >海外配置</li>
    </ul>
    </div> 
    <div class="tools">
  <ul class="toolbar1"> 
        <li class="click"><span><img src="../BgAssets/images/t01.png" /></span>
        <a href="/Cornucopia/BgOver/toadd">
        <input type="button" id="butselect" value="新增"></a></li>    
     
  </ul>  
     
     <div class="xline"></div>
  </div>
 
    <table class="tablelist">
    <thead>
    <tr>
    <th>序号</th>
    <th>标题</th>
    <th>子标题</th>
    <th>状态</th>
    <th>排序值</th>
    <th>图标</th>
    <th>添加时间</th>
    <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${list }" var="l" varStatus="c">
    <tbody> 
    <tr>
    <td>${c.index+1 }</td>
    <td>${l.title }</td>
    <td>${l.child_title }</td>
    <td>
    <c:if test="${l.status==0 }">已发布</c:if>
    <c:if test="${l.status==1 }">慕集中</c:if>
    <c:if test="${l.status==2 }">已发布</c:if>
    </td>
    <td>${l.sortColum }</td>
    <td>${l.oversea_icon }</td>
     <td>${l.addTime }</td>
          <td>
          <a href="/Cornucopia/BgOver/listAlll?id=${l.id}">查看预约</a>
          <a href="/Cornucopia/BgOver/toupdate?id=${l.id}">查看编辑</a> 
    </c:forEach>
    </table>
  
</body>
</html>
