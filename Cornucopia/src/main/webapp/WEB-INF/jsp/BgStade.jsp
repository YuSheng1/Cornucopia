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
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
    
    <form action="/Cornucopia/BgItem/BgStade" method="post">
	交易号：<input type="text" name="trade_no" placeholder="交易号">
		手机号：11<input type="text" name="pay_channel_order_no" placeholder="手机号">
		交易类型：<select name="trade_type">
<option value="-1">全部</option>
		<option value="MOBILE_RECHARGE">MOBILE_RECHARGE</option>
						<option value="FINANCE">FINANCE</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		交易状态：<select name="trade_status">
<option value="-1">全部</option>
		<option value="2">订单已完成</option>
						<option value="0">订单未完成</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		订单时间：<input type="date" name="create_date" placeholder="订单时间">
		<input type="submit" value="搜索"  class="btn btn-primary">
	</form>
    <table class="tablelist">
			<thead>
				<tr>
					<th>编号<i class="sort"><img src="../BgAssets/images/px.gif" /></i></th>
					<th>交易号</th>
					<th>交易人手机号</th>
					<th>交易类型</th>
					<th>交易名称</th>
					<th>交易金额</th>
					<th>交易状态</th>
					<th>交易时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="s" varStatus="stat">
					<tr>
						<td>${stat.index+1 }</td>
						<td>${s.trade_no}</td>
						<td>${s.member.mobile_Phone }</td>
						<td>${s.trade_type}</td>
						<td>${s.trade_name}</td>
						<td>${s.amount }</td>
						<c:if test="${s.trade_status==2}"><td style="color: blue;">订单已完成</td></c:if>
						<c:if test="${s.trade_status==0}"><td  style="color: red;">订单未完成</td></c:if>
						<td>${s.create_date }</td>
				</c:forEach>
			</tbody>
		</table>   
		
</body>
</html>
