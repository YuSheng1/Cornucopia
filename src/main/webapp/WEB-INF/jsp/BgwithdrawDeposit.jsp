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
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
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
		<table class="tablelist">
			<thead>
				<tr>
					<th>编号<i class="sort"><img src="../BgAssets/images/px.gif" /></i></th>
					<th>提款人</th>
					<th>提款金额</th>
					<th>提款时间</th>
					<th>提款流水号</th>
					<th>提款任务流程ID</th>
					<th>任务ID</th>
					<th>审核</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${cashFlowProcessVo}" var="c" varStatus="stat">
					<tr>

						<td>${stat.index+1}</td>
						<td>${c.mname}</td>
						<td class="mid">${c.money}</td>
						<td>${c.cashWithdrawalTime}</td>
						<td>${c.serialNumbe}</td>
						<td>${c.lid}</td>
						<td>${c.rid}</td>
						<td><a  href="/Cornucopia/Wi/findRW?rid=${c.rid}&roles=${url}&mname=${c.mname}&serialNumbe=${c.serialNumbe}&money=${c.money}">
								<img src="../BgAssets/images/t05.png" />审核通过
							</a>
							<a  href="/Cornucopia/Wi/delete?rid=${c.deploymentId}&roles=${url}&mname=${c.mname}&serialNumbe=${c.serialNumbe}&money=${c.money}">
								<img src="../BgAssets/images/t05.png" />审核驳回
							</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script type="text/javascript">
		$(function(){
			$(".mid").each(function(){
				var c=$(this).html();
				c=parseInt(c);
				$(this).html(c);
			});
		});

		
		</script>
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
