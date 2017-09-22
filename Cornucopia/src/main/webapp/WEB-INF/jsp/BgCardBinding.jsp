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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理系统HTML模板--模板之家 www.cssmoban.com</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
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
		<form action="/Cornucopia/BgItem/BgCardBindingAll" method="post">
		<input type="hidden" name="member_id">
手机号：<input type="text" name="mobile_Phone" class="width=200px" placeholder="手机号">
绑卡姓名：<input type="text" name="member_name" class="width=200px" placeholder="绑卡姓名">
绑卡卡号：<input type="text" name="card_no" class="width=200px" placeholder="绑卡卡号">
注册时间：<input type="date" name="create_date" class="width=200px" placeholder="注册时间">
<input type="submit" value="搜索"  class="btn btn-primary">
								</form>
	<div class="rightinfo">
		<table class="tablelist">
			<thead>
				<tr>
					<th>编号<i class="sort"><img src="../BgAssets/images/px.gif" /></i></th>
					<th>手机号</th>
					<th>绑卡人姓名</th>
					<th>绑卡身份证</th>
					<th>绑卡类型</th>
					<th>银行卡号</th>
					<th>绑卡地址</th>
					<th>状态</th>
					<th>添加时间</th>
				    <th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${mbl}" var="e" varStatus="stat">
					<tr>
						<td>${e.id }</td>
						<td>${e.member.mobile_Phone}</td>
						<td>${e.member.member_name }</td>
						<td>${e.member.identity}</td>
						<td>${e.type }</td>
						<td>${e.card_no }</td>
						<td>${e.cardaddress }</td>
						<td><c:if test="${e.delflag==0}">正常使用</c:if><c:if test="${e.delflag==1}">以废弃</c:if></td>
						<td>${e.create_date }</td>
						<td>
						<h6 class="tablelink" data-toggle="modal" data-target="#myModal2" > <img src="../BgAssets/images/t02.png" />解绑</h6>
							</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	   <div class="pagin">
			<div class="message">
				共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"><a href="javascript:;"><span
				class="pagepre"></span></a></li>
				<li class="paginItem"><a href="javascript:;">1</a></li>
				<li class="paginItem current"><a href="javascript:;">2</a></li>
				<li class="paginItem"><a href="javascript:;">3</a></li>
				<li class="paginItem"><a href="javascript:;">4</a></li>
				<li class="paginItem"><a href="javascript:;">5</a></li>
				<li class="paginItem more"><a href="javascript:;">...</a></li>
				<li class="paginItem"><a href="javascript:;">10</a></li>
				<li class="paginItem"><a href="javascript:;"><span
						class="pagenxt"></span></a></li>
			</ul>
		</div>
	</div>
	
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
