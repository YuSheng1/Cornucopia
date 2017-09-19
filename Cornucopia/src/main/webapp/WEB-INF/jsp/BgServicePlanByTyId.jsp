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
<script type="text/javascript">
<%String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间%>
</script>
</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="/Cornucopia/BgItem/BgServicePlan">付息列表</a></li>
			<li><a href="#">体验金付息内容</a></li>
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
					<th>流水号</th>
					<th>投资人手机号</th>
					<th>投资人姓名</th>
					<th>投资人身份证</th>
					<th>投资金额</th>
					<th>还款金额</th>
					<th>投资时间</th>
					<th>还款时间</th>
					<th>还款状态</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${SubjectBbinPurchassRecord}" var="s" varStatus="stat">
					<tr><td>${s.id}</td>
						<td>${s.serial_number }</td>
						<td>${s.member.mobile_Phone}</td>
						<td>${s.member.member_name }</td>
						<td>${s.member.identity}</td>
						<td>${s.amount }</td>
						<td>${s.interest}</td>
						<td>${s.create_date }</td>
						<td>${s.last_profit_day}</td>
						<td><c:if test="${dateString>=s.last_profit_day}"><a class="tablelink"  href="/Cornucopia/BgItem/BgServicePlanById?subjectId=${s.id }" > <img src="../BgAssets/images/t01.png" />还款</a></c:if><c:if test="${dateString<s.last_profit_day}">投资中</c:if></td>
						<%-- <td>
						<a class="tablelink"  href="/Cornucopia/BgItem/BgServicePlanById?subjectId=${s.id }" > <img src="../BgAssets/images/t01.png" />付息列表</a>
						<c:if test="${s.exper_status==1}">
						<a class="tablelink"  href="/Cornucopia/BgItem/SubjectBbinPurchassRecord?subjectId=${s.id }" > <img src="../BgAssets/images/t01.png" />体验金付息列表</a>
						</c:if></td> --%>
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
