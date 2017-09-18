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
	<ul id="myTab" class="nav nav-tabs">
		<li><a href="#yuyue" data-toggle="tab">账户详情</a></li>
		<li><a href="#jine" data-toggle="tab">充值记录 </a></li>
		<li><a href="#tikuan" data-toggle="tab">提款记录 </a></li>
		<li><a href="#tiyan" data-toggle="tab">投资记录 </a></li>
		<li><a href="#aqxx" data-toggle="tab">钱包记录</a></li>
		<li><a href="#qian" data-toggle="tab">用户财富</a></li>
	</ul>

	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade" id="yuyue">
			<table class="table">
				<caption>
					<h4>账户详情</h4>
				</caption>
				<thead>
					<tr>
						<th>编号<i class="sort"><img
								src="../BgAssets/images/px.gif" /></i></th>
						<th>手机号</th>
						<th>昵称</th>
						<th>姓名</th>
						<th>身份证</th>
						<th>邀请码</th>
						<th>注册时间</th>
					</tr>
				</thead>
				<tbody>
					<tr class="active">
						<td>${memberslist.id }</td>
						<td>${memberslist.mobile_Phone}</td>
						<td>${memberslist.name }</td>
						<td>${memberslist.member_name }</td>
						<td>${memberslist.identity }</td>
						<td>${memberslist.invitationCode }</td>
						<td>${memberslist.create_date }</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="tab-pane fade" id="qian">
			<table class="table">
				<caption>
					<h4>用户财富</h4>
				</caption>
				<thead>
					<tr>
						<th>可用余额<i class="sort"><img
								src="../BgAssets/images/px.gif" /></i></th>
						<th>冻结余额</th>
						<th>累计收益</th>
						<th>投资总额</th>
						<th>红包金额</th>
						<th>体验金</th>
					</tr>
				</thead>
				<tbody>
					<tr class="active">
						<td>${MAccount.useable_balance }</td>
						<td>${MAccount.imuseale_balance}</td>
						<td>${MAccount.total_profit }</td>
						<td>${MAccount.invest_amount }</td>
						<td>${MAccount.bonus_amount }</td>
						<td>${MAccount.bbin_amount }</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="tab-pane fade" id="jine">
			<table class="table">
				<caption>
					<h4>充值记录</h4>
				</caption>
				<thead>
					<tr>
						<th>订单号</th>
						<th>充值金额</th>
						<th>充值状态</th>
						<th>充值时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${memberDepositRecord}" var="m" varStatus="stat">
						<tr class="active">
							<td>${m.serial_number}</td>
							<td>${m.amount}</td>
							<td><c:if test="${ m.status==0}">充值失败</c:if> <c:if
									test="${ m.status==1}">充值成功</c:if></td>
							<td>${ m.create_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="tikuan">
			<table class="table">
				<caption>
					<h4>提款记录</h4>
				</caption>
				<thead>
					<tr>
						<th>订单号</th>
						<th>提款日期</th>
						<th>提款金额</th>
						<th>提款状态</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${membeWithdrawRecord}" var="mw" varStatus="stat">
						<tr class="active">
							<td>${mw.serial_number}</td>
							<td>${mw.create_date}</td>
							<td>${mw.amount}</td>
							<td><c:if test="${mw.status==0}">待审核</c:if> <c:if
									test="${mw.status==1}">已打款</c:if> <c:if test="${mw.status==2}">打款中</c:if>
								<c:if test="${mw.status==3}">审核失败</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="tiyan">
			<table class="table">
				<caption>
					<h4>投资记录</h4>
				</caption>
				<thead>
					<tr>
						<th>订单编号</th>
						<th>标的名称</th>
						<th>金额</th>
						<th>预期收益</th>
						<th>状态</th>
						<th>购买时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${subjectPurchaseRecorList}" var="sj"
						varStatus="stat">
						<tr class="success">
							<td>${sj.serial_number }</td>
							<td>${sj.subject.name}</td>
							<td>${sj.amount}</td>
							<td>${sj.interset }</td>
							<td><c:if test="${ sj.ispayment==0}">投资中</c:if> <c:if
									test="${ sj.ispayment==1}"> 已还款</c:if></td>
							<td>${sj.create_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="aqxx">
			<table class="table">
				<caption>
					<h4>钱包记录</h4>
				</caption>
				<thead>
					<tr>
						<th>订单编号</th>
						<th>标的名称</th>
						<th>金额</th>
						<th>类型</th>
						<th>状态</th>
						<th>时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${memberTradeRecord}" var="mt" varStatus="stat">
						<tr class="success">
							<td>${mt.id}</td>
							<td>${mt.trade_no}</td>
							<td>${mt.amount}</td>
							<td>${mt.trade_type }</td>
							<td><c:if test="${ mt.fund_flow==0}">流出</c:if> <c:if
									test="${ mt.fund_flow==1}">流入</c:if></td>
							<td>${mt.trade_name}</td>
							<td>${s.create_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
