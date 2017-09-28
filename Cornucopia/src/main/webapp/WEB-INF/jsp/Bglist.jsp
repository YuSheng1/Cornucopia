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
    <li >海外预约</li>
    </ul>
    </div> 
    <div class="tools">
  <ul class="toolbar1"> 
        <li class="click"><span><img src="../BgAssets/images/t01.png" /></span>
        <a href="/Cornucopia/BgOver/list">
        <input type="button" id="butselect" value="返回"></a></li>    
     
  </ul>  
     
     <div class="xline"></div>
  </div>
 
    <table class="tablelist">
    <thead>
    <tr>
    <th>序号</th>
    <th>姓名</th>
    <th>电话</th>
    <th>地址</th>
    <th>预约时间</th>
    </tr>
    </thead>
    <c:forEach items="${lists }" var="li" varStatus="c">
    <tbody> 
    <tr>
    <td>${c.index+1 }</td>
    <td>${li.name }</td>
    <td>${li.phone }</td>
    <td>${li.addr }</td>
    <td>${li.create_date }</td>
    </tr> 
    </tbody>
    </c:forEach>
    </table>
    
    
</body>
</html>
