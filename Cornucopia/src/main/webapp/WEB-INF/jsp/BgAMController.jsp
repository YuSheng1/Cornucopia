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
<link href="../BgAssets/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<script type="text/javascript" src="../BgAssets/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../BgAssets/js/select-ui.min.js"></script>
<script type="text/javascript" src="../BgAssets/editor/kindeditor.js"></script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">系统设置</a></li>
		</ul>
	</div>

	<div class="formbody">
		<div id="usual1" class="usual">
			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">账户详情</a></li>
					<li><a href="#tab2">充值记录</a></li>
					<li><a href="#tab3">提款记录</a></li>
					<li><a href="#tab4">投资记录</a></li>
					<li><a href="#tab5">钱包记录</a></li>
					<li><a href="#tab6">用户财富</a></li>
					<li><a  href="#tab7" >邀请记录</a></li>
				</ul>
			</div>
			<div id="tab1" class="tabson">
				<table class="tablelist">
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
			<div id="tab2" class="tabson">
				<ul class="seachform">
					<li><label>综合查询</label><input name="" type="text"
						class="scinput" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn" value="查询" /></li>
				</ul>
				<table class="tablelist">
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
							<c:if test="${ m.status==0}"><td style="color: red">充值失败</td></c:if> <c:if
									test="${ m.status==1}"><td style="color: blue">充值成功</td></c:if>
							<td>${ m.create_date}</td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
			</div>
			<div id="tab3" class="tabson">
				<ul class="seachform">
					<li><label>综合查询</label><input name="" type="text"
						class="scinput" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn" value="查询" /></li>
				</ul>
				<table class="tablelist">
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
							<c:if test="${mw.status==0}"><td style="color: green">待审核</td></c:if> <c:if
									test="${mw.status==1}"><td style="color: blue">已打款</td></c:if> <c:if test="${mw.status==2}"><td style="color: green">审核中</td></c:if>
								<c:if test="${mw.status==3}"><td style="color: red">审核失败</td></c:if>
						</tr>
					</c:forEach>
				</tbody>
				</table>
			</div>
			<div id="tab4" class="tabson">
				<ul class="seachform">
					<li><label>综合查询</label><input name="" type="text"
						class="scinput" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn" value="查询" /></li>
				</ul>
				<table class="tablelist">
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
							<c:if test="${ sj.ispayment==0}"><td style="color: red">投资中</td></c:if> <c:if
									test="${ sj.ispayment==1}"><td style="color: blue">已还款</td></c:if>
							<td>${sj.create_date}</td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
			</div>
			<div id="tab5" class="tabson">
				<ul class="seachform">
					<li><label>综合查询</label><input name="" type="text"
						class="scinput" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn" value="查询" /></li>
				</ul>
				<table class="tablelist">
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
							<c:if test="${ mt.fund_flow==0}"><td style="color: blue">流出</td></c:if> <c:if
									test="${ mt.fund_flow==1}"><td style="color: red">流入</td></c:if>
							<td>${mt.trade_name}</td>
							<td>${s.create_date}</td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
			</div>
					<div id="tab6" class="tabson">
				<ul class="seachform">
					<li><label>综合查询</label><input name="" type="text"
						class="scinput" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn" value="查询"  /></li>
				</ul>
			
				<table class="tablelist">
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
			<div id="tab7" class="tabson">
				<ul class="seachform">
					<li><label>综合查询</label><input name="" type="text"
						class="scinput" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn" value="查询" /></li>
				</ul>
				<table class="tablelist">
					<thead>
					<tr>
						<th>被邀请人姓名</th>
						<th>奖励类型</th>
						<th>奖励金额</th>
						<th>奖励时间</th>
						<th>奖励状态</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${AwardRecords}" var="awr" varStatus="stat">
						<tr class="success">
							<td>${awr.bname}</td>
							<c:if test="${ awr.type==0}"><td style="color: blue">注册奖励</td></c:if> <c:if
									test="${ awr.type==1}"><td style="color: green">投资奖励</td></c:if>
							<td>${awr.money}</td>
							<td>${awr.date}</td>
							<c:if test="${ awr.isAward==0}"><td style="color: red">未奖励</td></c:if> <c:if
									test="${ awr.isAward==1}"><td style="color: blue">已奖励</td></c:if>
						</tr>
					</c:forEach>
				</tbody>
				</table>
			</div>
		</div>
		<script type="text/javascript">
			$("#usual1 ul").idTabs();
		</script>
		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>
	</div>


	

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
