<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>后台-->盈+统计-->用户综合统计</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/bootstrap-select.js"></script>
<script src="../assets/js/jquery.metisMenu.js"></script>
<script src="../assets/js/easypiechart.js"></script>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="../assets/css/font-awesome.css" rel="stylesheet" />
<script src="../assets/js/jquery.metisMenu.js"></script>
<script src="../assets/js/easypiechart.js"></script>
</head>
<body>
		<div id="page-wrapper" style="min-height: 1000px;">
		<h4 class="glyphicon glyphicon-play">财务统计</h4>
		<form id="accountForm" class="form-inline" role="form" method="post" action="/Cornucopia/backYingJiaFinanceStatistics/login">
<!-- 			&nbsp;&nbsp;开始时间： -->
<%-- 	         <input type="text" class="form-control" placeholder="开始时间" style="width: 100px" name="start" value="${start }"> --%>
<!-- 	         &nbsp;&nbsp;结束时间： -->
<%-- 	         <input type="text" class="form-control" placeholder="结束时间" style="width: 100px" name="end" value="${end }"> --%>
<!-- 	         &nbsp;&nbsp; -->
<!-- 	         <input type="submit" class="btn btn-default btn-info" value="查询"> -->
<!-- 	         &nbsp; -->
<!-- 	         <input type="reset" class="btn btn-default btn-info" value="重置"> -->
<!-- 	         &nbsp;&nbsp; -->
<!-- 	         <a class="btn btn-default btn-info" href="/yingJiaFinancing/backYingJiaFinanceStatistics/login?mons='0'">当月</a> -->
<!-- 	         &nbsp; -->
<!-- 	         <a class="btn btn-default btn-info" href="/yingJiaFinancing/backYingJiaFinanceStatistics/login?mons='1'">上一个月</a> -->
<!-- 	         &nbsp; -->
<!-- 	         <a class="btn btn-default btn-info" href="/yingJiaFinancing/backYingJiaFinanceStatistics/login?mons='3'">最近三个月</a> -->
	         <br>
	         <hr>
	         <div>
	         	<!--平台总资产  -->
                 <div style="float:left;border: 1px solid white;width: 32%">
                    <span class="glyphicon glyphicon-gbp" style="color: #0195b3; font-size: 68px;text-align:center; display:block;"><font id="f1" size="6px"></font></span><br/>
                    <span><font size="5px" style="color: #0195b3;text-align:center; display:block;">平台总资产:</font></span>
                    <span style="text-align:center; display:block;">(用户历史充值总额+用户总利润)</span>
                 </div>
               <!--平台余额  -->
                 <div style="float:left;border: 1px solid white;width: 32%">
                    <span class="glyphicon glyphicon-gbp" style="color: #0195b3; font-size: 68px;text-align:center; display:block;"><font id="f2" size="6px"></font></span><br/>
                    <span><font size="5px" style="color: #0195b3;text-align:center; display:block;">平台余额:</font></span>
                    <span style="text-align:center; display:block;">(总资产-总支出)</span>
                 </div>
               <!--平台总净值/第三方账户余额  -->
                 <div style="float:left;border: 1px solid white;width: 32%">
                    <span class="glyphicon glyphicon-gbp" style="color: #0195b3; font-size: 68px;text-align:center; display:block;"><font id="f3" size="6px"></font></span><br/>
                    <span><font size="5px" style="color: #0195b3;text-align:center; display:block;">平台总净值/第三方账户余额:</font></span>
                    <span style="text-align:center; display:block;">(历史充值-总提现)</span>
                 </div>
	         </div>
	         
	         <div style="clear: both;"></div><p>&nbsp;</p>
	          <div>
				 <div class="card-header" style="border: 1px solid white;width:45%; float: left; ">
				    <span><font size="5px" style="color: #0195b3">用户充值总额:</font></span>
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    <span><font id="f4" size="5px" style="color: #0195b3"></font>元</span>
				    <br/>
				    <span>(富友充值+贝付充值)</span>
				 </div>
				 <div class="card-header" style="border: 1px solid white;width:45%;margin-left: 650px;  ">
					 <div>
					    <span><font size="5px" style="color: #0195b3">用户总收益:</font></span>
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <span><font id="f5" size="5px" style="color: #0195b3"></font>元</span>
					    <br/>
					    <span>(投资总收益+用户总红包)</span>
					 </div>
					</div>
				 </div>
	         <div>
	         <table class="table table-bordered" style="width: 15%; float:left;" >
			   <caption></caption>
			   <thead>
			      <tr class="info">
			      	<th>账户</th>
			      	<th>充值</th>
			      </tr>
			   </thead>
			   <tbody>
			      <tr>
			      	<td>富友</td>
			       	<c:forEach items="${depositList }" var="d">
			      	<c:if test="${d.pay_channel_name=='FUIOU' }" >
			      	<td><span id="df">${d.samount }</span></td>
			      	</c:if>
			      	</c:forEach>
			      </tr>
			      <tr>
			      	<td>贝付</td>
			      	<c:forEach items="${depositList }" var="d">
			      	<c:if test="${d.pay_channel_name=='BEIFU' }" >
			      	<td>
			      	<span id="db">${d.samount }</span>
			      	</td>
			      	</c:if>
			      	</c:forEach>
			      </tr>
			      <tr>
			      	<td>支付宝</td>
			      	<c:forEach items="${depositList }" var="d">
			      	<c:if test="${d.pay_channel_name=='支付宝充值'}" >
			      	<td>
			      	<span id="dz">
			      	<c:if test="${d.samount!=null }" >${d.samount}</c:if>
			      	</span>
			      	</td>
			      	</c:if>
			      	</c:forEach>
			      </tr>
			      <tr>
			      	<td>总计</td>
			      	<td id="dsum"></td>
			      </tr>
			   </tbody></table>
			    <table class="table table-bordered" style="width: 10%; float:left;" >
			   <caption></caption>
			   <thead>
			      <tr class="info">
			      	<th>取现</th>
			      </tr>
			   </thead>
			   <tbody>
			   <c:forEach items="${withdrawList }" var="w">
			      <tr>
			      	<td>
			      	<c:if test="${w.channel_name=='FUIOU' }" >
			      	<span id="wf">${w.wamount }</span>
			      	</c:if>
			      	<c:if test="${w.channel_name=='BEIFU' }" >
			      	<span id="wb">${w.wamount }</span>
			      	</c:if>
			      	<c:if test="${w.channel_name=='支付宝提现' }" >
			      	<span id="wz">${w.wamount }</span>
			      	</c:if>
			      	</td>
			      </tr>
			      </c:forEach>
			      <tr>
			      	<td id="wsum"></td>
			      </tr>
			   </tbody></table>
			   <table class="table table-bordered" style="width: 10%; float:left;" >
			   <caption></caption>
			   <thead>
			      <tr class="info">
			      	<th>余额</th>
			      </tr>
			   </thead>
			   <tbody>
			   	<tr>
			   		<td id="yb"></td>
			    </tr>
			    <tr>
			   		<td id="yf"></td>
			    </tr>
			    <tr>
			   		<td id="yz"></td>
			    </tr>
			    <tr>
			    <td id="ysum"></td>
			    </tr>
			   </tbody></table>
			   <table class="table table-bordered" style="width: 30%; float:left;margin-left: 10px;" >
			   <caption></caption>
			   <thead>
			      <tr class="info">
			      	<th>项目</th>
			      	<th>金额</th>
			      </tr>
			   </thead>
			   <tbody>
			      <tr>
			      <td>固收理财</td>
			      <td id="pu"><fmt:formatNumber type="number" value="${purchase }" maxFractionDigits="2"/> </td>
			      </tr>
			      <tr>
			      <td>私募基金</td>
			      <td id="pl"><fmt:formatNumber type="number" value="${placement }" maxFractionDigits="2"/></td>
			      </tr>
			      <tr>
			      <td>合计</td>
			      <td id="psum"></td>
			      </tr>
			   </tbody></table>
			   <table class="table table-bordered" style="width: 30%; float:left;margin-left: 10px;" >
			   <caption></caption>
			   <thead>
			      <tr class="info">
			      	<th>项目</th>
			      	<th>金额</th>
			      </tr>
			   </thead>
			   <tbody>
			   <c:forEach items="${awardList }" var="a">
			      <tr>
			      <td>
			      <c:if test="${a.type==0 }">
			           邀请注册红包
			      </c:if>
			      <c:if test="${a.type==1 }">
			           投资奖励红包
			      </c:if>
			      </td>
			      <td>
			      <c:if test="${a.type==0 }">
			      <span id="ay">${a.amount }</span>
			      </c:if>
			      <c:if test="${a.type==1 }">
			      <span id="az">${a.amount }</span>
			      </c:if>
			      </td>
			      </tr>
			      </c:forEach>
			      <tr>
			      <td>合计</td>
			      <td id="asum"></td>
			      </tr>
			   </tbody></table>
	         </div>
	         <div class="card-header" style="border: 1px solid white;float: left;height: 60px;width:100%;">
				 <div>
				    <div  style="float: left;">
					    <span><font size="5px" style="color: #0195b3">平台总支出:</font></span>
					    <span>(总投资+总消费+总提现)</span>
				    </div>
				    <div style="float: right; margin-right: 100px;">
				    	<span><font id="f6" size="5px" style="color: #0195b3"></font>元</span>
				    </div>
				 </div>
			 </div>
	         <div style="clear: both;"></div>
	         <div>
	          <table class="table table-bordered" style="width: 30%; float:left;margin-left: 10px;" >
			   <caption></caption>
			   <thead>
			      <tr class="info">
			      	<th>项目</th>
			      	<th>金额</th>
			      </tr>
			   </thead>
			   <tbody>
			      <tr>
			      <td>固收理财</td>
			      <td id="tpu"><fmt:formatNumber type="number" value="${purch}" maxFractionDigits="2"/></td>
			      </tr>
			      <tr>
			      <td>私募基金</td>
			      <td id="tpl"><fmt:formatNumber type="number" value="${place}" maxFractionDigits="2"/></td>
			      </tr>
			      <tr>
			      <td>合计</td>
			      <td id="tsum"></td>
			      </tr>
			   </tbody></table>
			    <table class="table table-bordered" style="width: 30%; float:left;margin-left: 10px;" >
			   <caption></caption>
			   <thead>
			      <tr class="info">
			      	<th>项目</th>
			      	<th>余额</th>
			      </tr>
			   </thead>
			   <tbody>
			       <c:forEach items="${payList }" var="pay" >
			        <tr>
			         <td>
			         <c:if test="${pay.type=='MOBILE' }">手机充值</c:if>
			         <c:if test="${pay.type=='OIL' }">加油卡充值</c:if>
			         </td>
			         <td>
			         <c:if test="${pay.type=='MOBILE' }">
			         <span id="pm">${pay.price }</span>
			         </c:if>
			         <c:if test="${pay.type=='OIL' }">
			         <span id="po">${pay.price }</span>
			         </c:if>
			         
			      </tr>
			      </c:forEach>
			      <tr>
			      	<td>生活缴费</td>
			      	<td><span id="ps">${lifePay }</span></td>
			      </tr>
			      <tr>
			      <td>合计</td>
			      <td id="paySum"></td>
			      </tr>
			   </tbody></table>
			    <table class="table table-bordered" style="width: 30%; float:left;margin-left: 10px;" >
			   <caption></caption>
			   <thead>
			      <tr class="info">
			      	<th>项目</th>
			      	<th>余额</th>
			      </tr>
			   </thead>
			   <tbody>
			   <c:forEach items="${withdrawList }" var="w">
			      <tr>
			      	<td>
			        <c:if test="${w.channel_name=='FUIOU' }" >
			      	富友账户</c:if>
			      	<c:if test="${w.channel_name=='BEIFU' }" >
			      	贝付账户</c:if>
			      	<c:if test="${w.channel_name=='支付宝提现' }" >
			      	支付宝账户</c:if>
			      	</td>
			      	<td>
			      	<c:if test="${w.channel_name=='FUIOU' }" >
			      	<span id="fw">${w.wamount }</span>
			      	</c:if>
			      	<c:if test="${w.channel_name=='BEIFU' }" >
			      	<span id="bw">${w.wamount }</span>
			      	</c:if>
			      	<c:if test="${w.channel_name=='支付宝提现' }" >
			      	<span id="zw">${w.wamount }</span>
			      	</c:if>
			      </tr>
			   </c:forEach>
			      <tr>
			      <td>合计</td>
			      <td id="sumw"></td>
			      </tr>
			   </tbody></table>
	         </div>
	     </form>
		</div>


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
	<script type="text/javascript">
	$(document).ready(function(){
		    //充值提现总计
			var ddf=$("#df").text();
			var ddb=$("#db").text();
			var ddz=$("#dz").text();
			var zd=parseFloat(ddf)+parseFloat(ddb)+parseFloat(ddz);
			$("#dsum").html(zd);
			var wwf=$("#wf").text();
			var wwb=$("#wb").text();
			var wwz=$("#wz").text();
			var zw=parseFloat(wwf)+parseFloat(wwb)+parseFloat(wwz);
			$("#wsum").html(zw);
			//充值提现余额
			var yyb=parseFloat(ddb)-parseFloat(wwb);
			$("#yb").html(yyb);
			var yyf=parseFloat(ddf)-parseFloat(wwf);
			$("#yf").html(yyf);
			var yyz=parseFloat(ddz)-parseFloat(wwz);
			$("#yz").html(yyz);
			var zy=parseFloat(yyf)+parseFloat(yyb)+parseFloat(yyz);
			$("#ysum").html(zy.toFixed(2));
			
			//总收益
			var ppu=$("#pu").html();
			var ppl=$("#pl").html();
			var zp=parseFloat(ppu)+parseFloat(ppl);
			$("#psum").html(zp.toFixed(2));
			
			//红包总计
			var aay=$("#ay").text();
			var aaz=$("#az").text();
			var za=parseFloat(aay)+parseFloat(aaz);
			$("#asum").html(za.toFixed(2));
			
			//总投资
			var ttpu=$("#tpu").html();
			var ttpl=$("#tpl").html();
			var zt=parseFloat(ttpu)+parseFloat(ttpl);
			$("#tsum").html(zt.toFixed(2));
			
			//总消费
			var ppm=$("#pm").text();
			var ppo=$("#po").text();
			var pps=$("#ps").text();
			var zpay=parseFloat(ppm)+parseFloat(ppo)+parseFloat(pps);
			$("#paySum").html(zpay.toFixed(2));
			
			//总提现 
			var fww=$("#fw").text();
			var bww=$("#bw").text();
			var zww=$("#zw").text();
			var sw=parseFloat(fww)+parseFloat(bww)+parseFloat(zww);
			$("#sumw").html(sw.toFixed(2));
			
			//平台总支出金额
			var ff6=zt+zpay+sw;
			$("#f6").html(ff6.toFixed(2));
			
			//用户充值总额
			$("#f4").html(zd.toFixed(2));
			
			//用户总收益
			var ff5=zp+za;
			$("#f5").html(ff5.toFixed(2));
			
			//平台总资产
			var f4=$("#f4").text();
			var f5=$("#f5").text();
			$("#f1").html((parseFloat(f4)+parseFloat(f5)).toFixed(2));
			
			//平台余额
			var f1=$("#f1").text();
			var f6=$("#f6").text();
			$("#f2").html((parseFloat(f1)-parseFloat(f6)).toFixed(2));
			
			//平台总净值
			$("#f3").html((parseFloat(f4)-parseFloat(f6)).toFixed(2));
		});
	</script>

</body>

</html>