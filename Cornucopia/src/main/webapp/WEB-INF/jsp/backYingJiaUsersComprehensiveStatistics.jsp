<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>后台-->盈+统计-->用户综合统计</title>
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/bootstrap-select.js"></script>
<script src="../assets/js/jquery.metisMenu.js"></script>
<script src="../assets/js/easypiechart.js"></script>
<link href="/yingJiaFinancing/css/bootstrap.min.css" rel="stylesheet" />
<link href="../assets/css/font-awesome.css" rel="stylesheet" />
<script src="../assets/js/jquery.metisMenu.js"></script>
<script src="../assets/js/easypiechart.js"></script>
<script src="../assets/js/custom-scripts.js"></script>
</head>
<body>
	<script type="text/javascript">
		function fun() {
			var phone = $('#phone').val();
			if (phone.length != 11) {
				document.getElementById('s').style.display = 'block';
			} else {
				document.forms[0].action = "/Cornucopia/backYingJiaUsersComprehensiveStatistics/login";
				document.forms[0].submit();
			}
		}
	</script>
	<div id="page-wrapper">
		<h4 class="glyphicon glyphicon-play">用户综合统计</h4>
		<hr>
		<form class="form-inline" role="form" method="post">
			&nbsp;&nbsp;<span style="float: left">手机号码：</span> <input type="text"
				class="form-control" placeholder="号码11位"
				style="width: 150px; float: left;" maxlength="11" id="phone"
				name="phone" value="${phone }"> &nbsp;&nbsp; <span id="s"
				style="display: none; color: red; float: left;"> 手机号码必须为11位</span> <br>
			<br> &nbsp;&nbsp;开始时间： <input type="date" class="form-control"
				style="width: 120px" name="start" value="${start }">
			&nbsp;&nbsp;结束时间： <input type="date" class="form-control"
				style="width: 120px" name="end" value="${end }">
			&nbsp;&nbsp;交易类型： <select class="form-control" name="qtrade_type">
				<option value="-1">全部</option>
				<option value="手机充值">手机充值</option>
				<option value="支付宝充值">支付宝充值</option>
				<option value="邀请奖励">邀请奖励</option>
				<option value="注册奖励">注册奖励</option>
				<option value="投资记录">投资记录</option>
			</select> &nbsp;&nbsp; <input type="button" class="btn btn-default btn-info"
				value="查询" onclick="fun()"> &nbsp; <input type="reset"
				class="btn btn-default btn-info" value="重置"><br> <a>
				<br>
			</a>
			<div>
				<table class="table table-bordered" style="width: 45%; float: left;">
					<caption></caption>
					<thead>
						<tr class="info">
							<th>基本信息</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>真实姓名</td>
							<td>${member.member_name}</td>
							<td>身份证号</td>
							<td>${member.identity}</td>
						</tr>
						<tr>
							<td>手机</td>
							<td>${member.mobile_Phone }</td>
							<td>注册时间</td>
							<td>${member.create_date }</td>
						</tr>
						<tr>
							<td>微信账号</td>
							<td>${member.weixinAccount }</td>
							<td>QQ账号</td>
							<td>${member.qqNumber }</td>
						</tr>
						<tr>
							<td>邀请码</td>
							<td>${member.invitationCode }</td>
							<td>被邀请码</td>
							<td>${member.invitedCode }</td>
						</tr>
					</tbody>
				</table>
				<table class="table table-bordered"
					style="width: 45%; float: left; margin-left: 15px;">
					<caption></caption>
					<thead>
						<tr class="info">
							<th>资金信息</th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>充值金额</td>
							<td>${damount}</td>
							<td>提现金额</td>
							<td>${wamount}</td>
						</tr>
						<tr>
							<td>投资金额</td>
							<td>${account.invest_amount }</td>
							<td>收益金额</td>
							<td>${account.total_profit }</td>
						</tr>
						<tr>
							<td>冻结金额</td>
							<td>${account.imuseale_balance }</td>
							<td>可用金额</td>
							<td>${account.useable_balance }</td>
						</tr>
						<tr>
							<td>红包金额</td>
							<td>${amount }</td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
			<table class="table table-bordered" id="t_student">
				<caption>
					<h4>交易记录</h4>
				</caption>
				<thead>
					<tr class="info">
						<th>序号</th>
						<th>交易编号</th>
						<th>交易类型</th>
						<th>金额</th>
						<th>具体项目</th>
						<th>交易状态</th>
						<th>交易时间</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tradeList }" var="t" varStatus="stat">
						<tr>
							<td>${stat.index+1 }</td>
							<td>${t.trade_no }</td>
							<td>${t.trade_type }</td>
							<td>${t.amount }</td>
							<td>${t.trade_name }</td>
							<c:if test="${t.trade_status==0 }">
								<td>投资中</td>
							</c:if>
							<c:if test="${t.trade_status==1 }">
								<td>完成</td>
							</c:if>
							<td>${t.create_date }</td>
							<td>${t.trade_name }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<div class="pagin">
		<div class="gridItem"
			style="padding: 5px; width: 300px; float: left; text-align: left; height: 30px; line-height: 30px; font-size: 15px;">
			共有 <span id="spanTotalInfor" style="color: red; font-weight: bold;"></span>
			条记录 , 当前第 <span id="spanPageNum"
				style="color: red; font-weight: bold;"></span> 页 , 共 <span
				id="spanTotalPage" style="color: red; font-weight: bold;"></span> 页
		</div>
		<div class="gridItem"
			style="margin-left: 45px; padding: 5px; width: 400px; float: left; text-align: center; height: 30px; line-height: 30px; vertical-align: middle; font-size: 15px;">
			<span id="spanFirst">首页</span> <span id="spanPre">上一页</span> <span
				id="spanInput"
				style="margin: 0px; padding: 0px 0px 4px 0px; height: 100%;">
				第<input id="Text1" type="text" class="TextBox"
				onkeyup="changepage()"
				style="height: 20px; text-align: center; width: 50px" />页
			</span> <span id="spanNext">下一页</span> <span id="spanLast">尾页</span>
		</div>

	</div>
	<script type="text/javascript">
		var theTable = document.getElementById("t_student");
		var txtValue = document.getElementById("Text1").value;
		function changepage() {
			var txtValue2 = document.getElementById("Text1").value;
			if (txtValue != txtValue2) {
				if (txtValue2 > pageCount()) {

				} else if (txtValue2 <= 0) {

				} else if (txtValue2 == 1) {
					first();
				} else if (txtValue2 == pageCount()) {
					last();
				} else {
					hideTable();
					page = txtValue2;
					pageNum2.value = page;

					currentRow = pageSize * page;
					maxRow = currentRow - pageSize;
					if (currentRow > numberRowsInTable)
						currentRow = numberRowsInTable;
					for (var i = maxRow; i < currentRow; i++) {
						theTable.rows[i].style.display = '';
					}
					if (maxRow == 0) {
						preText();
						firstText();
					}
					showPage();
					nextLink();
					lastLink();
					preLink();
					firstLink();
				}

				txtValue = txtValue2;
			}
		}
	</script>
	<script src="../assets/js/Pagging.js"></script>
	<script>
		$("#uu a").mouseenter(function() {
			$(this).css({
				"background-color" : "#A7EADE",
				"color" : "black"
			});
		});

		$("#uu a").mouseleave(function() {
			$(this).css({
				"background-color" : "#17191B",
				"color" : "#B5B5B5"
			});
		});
	</script>

</body>

</html>