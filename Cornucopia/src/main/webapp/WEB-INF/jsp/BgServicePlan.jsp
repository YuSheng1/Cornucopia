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
					<th>合同编号</th>
					<th>标的类别</th>
					<th>标的名称</th>
					<th>标的金额</th>
					<th>已投人数</th>
					<th>标的期限</th>
					<th>年化收益</th>
					<th>标的状态</th>
					<th>可体验金购买</th>
					<th>付息列表</th>
				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${subject}" var="s" varStatus="stat">
					<tr>
						<td>${s.id }</td>
						<td>${s.serial_no}</td>
						<td>${s.type }</td>
						<td>${s.name }</td>
						<td>${s.amount }</td>
						<td>${s.bought }</td>
						<td>${s.period }</td>
						<td>${s.year_rate }</td>
						<td><c:if test="${s.status==1}">投资中</c:if><c:if test="${s.status==0}">投资已结束</c:if></td>
						<c:if test="${s.exper_status==0}"><td  style="color: red;" >不可购买</td></c:if><c:if test="${s.exper_status==1}"><td  style="color: blue;" >可购买</td></c:if>
						<td>
						<a class="tablelink"  href="/Cornucopia/BgItem/BgServicePlanById?subjectId=${s.id }" > <img src="../BgAssets/images/t01.png" />付息列表</a>
						<c:if test="${s.exper_status==1}">
						<a class="tablelink"  href="/Cornucopia/BgItem/SubjectBbinPurchassRecordById?subjectId=${s.id }" > <img src="../BgAssets/images/t01.png" />体验金付息列表</a>
						</c:if></td>
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
