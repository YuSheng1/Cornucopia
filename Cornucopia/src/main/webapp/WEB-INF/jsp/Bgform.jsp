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
</head>
<body>
    <div class="place" style="color: blue;font-size: 20px">
    <span>位置：</span>
    <ul class="placeul">
    <li >海外配置</li>
    </ul>
    </div> 
    <div class="tools">
  <ul class="toolbar1"> 
        <li class="click"><span><img src="../BgAssets/images/t01.png" /></span>
        <input type="button" id="butselect" value="新增"></li>    
     
  </ul>  
     
     <div class="xline"></div>
  </div>
 
    <table class="imgtable">
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
    <c:forEach items="${list }" var="list" varStatus="c">
    <tbody> 
    <tr>
    <td>${c.index+1 }</td>
    <td>${list.title }</td>
    <td>${list.child_title }</td>
    <td>${list.status }</td>
    <td>${list.sortColum }</td>
    <td>${list.oversea_icon }</td>
     <td>${list.addTime }</td>
          <td>
          <input type="button" id="but1" value="查看预约">
          <input type="button" id="but" value="编辑查看">
          </td>
    </tr> 
    </tbody>
    </c:forEach>
    </table>
    
    
</body>
</html>
