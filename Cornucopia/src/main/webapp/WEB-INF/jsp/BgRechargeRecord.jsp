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
	<form action="/Cornucopia/BgItem/BgRechargeRecord" method="post">
	订单编号：<input type="text" name="serial_number" placeholder="订单编号">
	订单状态：<select name="status">
<option value="-1">全部</option>
				<c:forEach items="${MemberDepositRecord }" var="list" >
		<option >${list.status }</option>
		</c:forEach>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		充值渠道流水号：<input type="text" name="pay_channel_order_no" placeholder="充值渠道流水号">
		订单时间：<input type="date" name="create_date" placeholder="订单时间">
		<input type="submit" value="搜索"  class="btn btn-primary">
	</form>
	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<shiro:hasPermission name="添加角色">
					<li class="click"><span><img
							src="../BgAssets/images/t01.png" /></span><a class="tablelink"
						data-toggle="modal" data-target="#myModal1">添加</a></li>
				</shiro:hasPermission>
			</ul>
		</div>

		<table class="tablelist">
			<thead>
				<tr>
					<th>编号<i class="sort"><img src="../BgAssets/images/px.gif" /></i></th>
					<th>订单编号</th>
					<th>手机号</th>
					<th>订单金额</th>
					<th>订单状态</th>
					<th>充值渠道</th>
					<th>充值渠道流水号</th>
					<th>订单时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${MemberDepositRecord}" var="s" varStatus="stat">
					<tr>
						<td>${s.id }</td>
						<td>${s.serial_number}</td>
						<td>${s.member.mobile_Phone }</td>
						<td>${s.amount}</td>
						<c:if test="${s.status==1}"><td style="color: blue;">订单已完成</td></c:if>
						<c:if test="${s.status==0}"><td  style="color: red;">订单未完成</td></c:if>
						<td>${s.pay_channel_name }</td>
						<td>${s.pay_channel_order_no }</td>
						<td>${s.create_date }</td>
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
