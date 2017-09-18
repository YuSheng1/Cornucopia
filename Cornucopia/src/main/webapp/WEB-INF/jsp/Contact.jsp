<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<!-- //获取系统时间必须导入的 -->
<%@ page import="java.text.*"%>
<!--  获取系统时间必须导入的 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>企业网站模板</title>
<link rel="stylesheet" href="../assets/css/amazeui.css" />
<link rel="stylesheet" href="../assets/css/common.min.css" />
<link rel="stylesheet" href="../assets/css/contact.min.css" />

<script type="text/javascript" src="/resources/web/layer/layer.js"></script>
<script src="/resources/web/echart/dist/echarts.js"></script>
</head>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<link href="../assets/resources/css/common.css" rel="stylesheet">
<link href="../assets/resources/css/jw.css" rel="stylesheet">
<link href="../assets/resources/css/iconfont.css" rel="stylesheet">
<script src="../assets/resources/js/echarts.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
<script type="text/javascript">
<%String datetime = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()); //获取系统时间%>
<%String datetime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间%>
</script>
</head>
<body>
	<div class="layout">
		<!--===========layout-header================-->
		<div class="layout-header am-hide-sm-only">
			<!--topbar start-->
			<div class="topbar">
				<div class="container">
					<div class="am-g">
						<div class="am-u-md-3">
							<div class="topbar-left">
								<i class="am-icon-globe"></i>
								<div class="am-dropdown" data-am-dropdown>
									<button class="am-btn am-btn-primary am-dropdown-toggle"
										data-am-dropdown-toggle>
										Language<span class="am-icon-caret-down"></span>
									</button>
									<ul class="am-dropdown-content">
										<li><a href="#">English</a></li>
										<li class="am-divider"></li>
										<li><a href="#">中文</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="am-u-md-9">
							<div class="topbar-right am-text-right am-fr">
								加入我们 <i class="am-icon-facebook"></i> <i class="am-icon-twitter"></i>
								<i class="am-icon-google-plus"></i> <i class="am-icon-pinterest"></i>
								<i class="am-icon-instagram"></i> <i class="am-icon-linkedin"></i>
								<i class="am-icon-youtube-play"></i> <i class="am-icon-rss"></i>
								<c:if test="${empty Lname}">
									<a href="/Cornucopia/item/Login">登录</a>
									<a href="/Cornucopia/item/Register">注册</a>
								</c:if>
								<c:if test="${not empty Lname}"> 欢迎您: ${Lname}
 <a href="/Cornucopia/item/Login">退出登陆</a>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--topbar end-->


			<div class="header-box" data-am-sticky>
				<!--header start-->
				<div class="container">
					<div class="header">
						<div class="am-g">
							<div class="am-u-lg-2 am-u-sm-12">
								<div class="logo">
									<a href=""><img src="../assets/images/4.jpg" alt="" /></a>
								</div>
							</div>
							<div class="am-u-md-10">
								<div class="header-right am-fr">
									<div class="header-contact">
										<div class="header_contacts--item">
											<div class="contact_mini">
												<i style="color: #7c6aa6" class="contact-icon am-icon-phone"></i>
												<strong>0575-84085869</strong> <span>周一~周五, 8:00 -
													20:00</span>
											</div>
										</div>
										<div class="header_contacts--item">
											<div class="contact_mini">
												<i style="color: #7c6aa6"
													class="contact-icon am-icon-envelope-o"></i> <strong>13197176376@163.com</strong>
												<span>随时欢迎您的来信！</span>
											</div>
										</div>
										<div class="header_contacts--item">
											<div class="contact_mini">
												<i style="color: #7c6aa6"
													class="contact-icon am-icon-map-marker"></i> <strong>汉水华城</strong>
												<span>樊城区长虹路27号</span>
											</div>
										</div>
									</div>
									<a href="/Cornucopia/item/Contact" class="contact-btn">
										<button type="button"
											class="am-btn am-btn-secondary am-radius">联系我们</button>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--header end-->


				<!--nav start-->
				<div class="nav-contain">
					<div class="nav-inner">
						<ul class="am-nav am-nav-pills am-nav-justify">
							<li class=""><a href="/Cornucopia/item/Index">首页</a></li>
							<li><a href="#">网上体验中心</a> <!-- sub-menu start-->
								<ul class="sub-menu">
									<li class="menu-item"><a href="/Cornucopia/item/Product1">产品展示1</a></li>
									<li class="menu-item"><a href="/Cornucopia/item/Product2">产品展示2</a></li>
									<li class="menu-item"><a href="/Cornucopia/item/Product3">产品展示3</a></li>
								</ul> <!-- sub-menu end--></li>
							<li><a href="/Cornucopia/AGSub/subject">产品中心</a></li>
							<li><a href="/Cornucopia/item/Solution">下载中心</a></li>
							<li><a href="/Cornucopia/item/News">新闻中心</a> <!-- sub-menu start-->
								<ul class="sub-menu">
									<li class="menu-item"><a href="/Cornucopia/item/NewsC">盈+商学院</a></li>
									<li class="menu-item"><a href="html/404-dark.html">行业动态</a></li>
									<li class="menu-item"><a href="html/404-light.html">精彩专题</a></li>
								</ul> <!-- sub-menu end--></li>
							<li><a href="/Cornucopia/item/About">盈+商学院</a></li>
							<li><a href="/Cornucopia/item/Join">投研中心</a></li>
							<li><a href="/Cornucopia/item/Contact">我的加法库</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="breadcrumb-box">
		<div class="am-container">
			<ol class="am-breadcrumb">
				<li><a href="/Cornucopia/item/Index">首页</a></li>
				<li class="/Cornucopia/item/Contact">联系我们</li>
			</ol>
		</div>
	</div>
	</div>

	<script type="text/javascript">
    $(function(){
        function showIn(url){
            var info="<div class='mydig'><div class='bg'></div><div class='imgbox'><a href="+url+"></a></div></div>";
            $('body').append(info);
        }
            if (1!=null&&1==0){
                showIn("/account/bbinInfo/getBbinInfo");
            }

    });

</script>

	<table height="160" class="peopleInfo" width="970" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td align="left" valign="middle" class="info"><a
				href="/Cornucopia/AG_UserPlay/Contact">
					<div class="img">
						<img src="../BgAssets/images/头像.png">
					</div>
					<h2>${Lname}<span>您好!</span>
					</h2>
			</a>
				<div class="safe">
					账户安全&nbsp;&nbsp;<span class="scroll"><em style="width: 50%"></em></span>
				</div>
				<ul class="listIco iconfont">
					<li class=""><a href="#1">&#xe61c;</a><em>&#xe61b;</em></li>
					<li class="active"><a href="#1">&#xe61d;</a><em>&#xe61b;</em></li>
					<!-- <li class=""><a href="#1">&#xe61f;</a><em>&#xe61b;</em></li> -->
					<li class="active"><a href="#1">&#xe61a;</a><em>&#xe61b;</em></li>
					<li class=""><a href="#1">&#xe61e;</a><em>&#xe61b;</em></li>
				</ul></td>
			<td align="right"><a href="/web/logout" class="loginOut"><span
					class="iconfont">&#xe618;</span>安全退出</a></td>
		</tr>
	</table>
	<div class="countBox">
		<ul>
			<li><h2>${MAccount.useable_balance}</h2>
				<p>
					账户可用余额(元)<a href="javascript:;" class="glyphicon glyphicon-search"><span>账户可用余额</span><i></i></a>
				</p></li>
			<li><h2>${MAccount.useable_balance+MAccount.total_profit+MAccount.invest_amount}</h2>
				<p>
					账户总资产(元)<a href="javascript:;" class="glyphicon glyphicon-search"><span>可用余额+投资金额+累计收益</span><i></i></a>
				</p></li>
			<li><h2 style="color: #9d8440">${MAccount.invest_amount}</h2>
				<p>
					投资金额(元)<a href="javascript:;" class="glyphicon glyphicon-search"><span>投资中资金</span><i></i></a>
				</p></li>
			<li><h2 style="color: #9d8440">${MAccount.total_profit}</h2>
				<p>
					累计收益(元)<a href="javascript:;" class="glyphicon glyphicon-search"><span>累计收益</span><i></i></a>
				</p></li>
			<li><h2 style="color: #9d8440">${MAccount.imuseale_balance}</h2>
				<p>
					冻结金额(元)<a href="javascript:;" class="glyphicon glyphicon-search"><span>提现冻结金额</span><i></i></a>
				</p></li>
		</ul>
		<a   class="cz"  href="/Cornucopia/AG_UserPlay/GoRecharge" >充值 </a>
		 <a href="#wytk" onclick="fun()" class="tk" data-toggle="tab">提现 </a>
	</div>
	<script type="text/javascript">
		function fun(){
			$(window).scrollTop(300);
		  
		}
</script>
	<ul id="myTab" class="nav nav-pills nav-stacked"
		style="width: 200px; margin-top: 30px; margin-left: 350px;">
		<h4>我的投资</h4>
		<li class="active"><a href="#touzi" data-toggle="tab"> 投资记录</a></li>
		<li><a href="#yuyue" data-toggle="tab">预约记录</a></li>
		<li><a href="#jine" data-toggle="tab">充值记录 </a></li>
		<li><a href="#shouyi" data-toggle="tab">收益记录 </a></li>
		<li><a href="#tikuan" data-toggle="tab">提款记录 </a></li>
		<li><a href="#tiyan" data-toggle="tab">体验金记录 </a></li>
		<h4>我的账户</h4>
		<li><a href="#aqxx" data-toggle="tab">安全信息 </a></li>
		<li><a href="#wytk" data-toggle="tab">我要提款 </a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="touzi"
			style="margin-left: 600px; margin-top: -450px; width: 700px; height: 800px;">
			<table class="table" width="700px" >
			
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
					<c:forEach items="${subjectPurchaseRecor}" var="s" varStatus="stat">
						<tr class="success">
							<td>${s.serial_number }</td>
							<td>${s.subject.name}</td>
							<td>${s.amount}</td>
							<td>${s.interset }</td>
							<td><c:if test="${ s.ispayment==0}">投资中</c:if>
								<c:if test="${ s.ispayment==1}"> 已还款</c:if></td>
							<td>${s.create_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="yuyue"
			style="margin-left: 600px; margin-top: -450px; width: 700px; height: 600px;">
			<table class="table" width="700px" height="250px;">
				<caption>
					<h4>预约记录</h4>
				</caption>
				<thead>
					<tr>
						<th>标的名称</th>
						<th>金额</th>
						<th>预期收益</th>
						<th>状态</th>
						<th>预约时间</th>
						<th>下载</th>
					</tr>
				</thead>
				<tbody>
					<tr class="active">
						<td>产品1</td>
						<td>产品1</td>
						<td>产品1</td>
						<td>产品1</td>
						<td>23/11/2013</td>
						<td>待发货</td>
					</tr>
					<tr class="success">
						<td>产品1</td>
						<td>产品2</td>
						<td>产品1</td>
						<td>产品1</td>
						<td>10/11/2013</td>
						<td>发货中</td>
					</tr>
					<tr class="warning">
						<td>产品1</td>
						<td>产品3</td>
						<td>产品1</td>
						<td>产品1</td>
						<td>20/10/2013</td>
						<td>待确认</td>
					</tr>
					<tr class="danger">
						<td>产品1</td>
						<td>产品4</td>
						<td>产品1</td>
						<td>产品1</td>
						<td>20/10/2013</td>
						<td>已退货</td>
					</tr>
					<tr class="active">
						<td>产品1</td>
						<td>产品4</td>
						<td>产品1</td>
						<td>产品1</td>
						<td>20/10/2013</td>
						<td>已退货</td>
					</tr>
					<tr class="active">
						<td>产品1</td>
						<td>产品4</td>
						<td>产品1</td>
						<td>产品1</td>
						<td>20/10/2013</td>
						<td>已退货</td>
					</tr>
					<tr class="active">
						<td>产品1</td>
						<td>产品4</td>
						<td>产品1</td>
						<td>产品1</td>
						<td>20/10/2013</td>
						<td>已退货</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="jine"
			style="margin-left: 600px; margin-top: -450px; width: 700px; height: 600px;">
			<table class="table" width="700px">
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
							<td><c:if test="${ m.status==0}">充值失败</c:if>
								<c:if test="${ m.status==1}">充值成功</c:if></td>
							<td>${ m.create_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="shouyi"
			style="margin-left: 600px; margin-top: -450px; width: 700px; height: 600px;">
			<table class="table" width="700px">
				<caption>
					<h4>收益记录</h4>
				</caption>
				<thead>
					<tr>
						<th>订单号</th>
						<th>收益日期</th>
						<th>收益金额</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${subjectPurchaseRecor}" var="s1"
						varStatus="stat">
						<c:if test="${ s1.ispayment==1}">
							<tr class="success">
								<td>${s1.serial_number }</td>
								<td>${s1.create_date}</td>
								<td>${s1.interset }</td>
								<td>${s1.subject.name}</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="tikuan"
			style="margin-left: 600px; margin-top: -450px; width: 700px; height: 600px;">
			<table class="table" width="700px">
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
		<div class="tab-pane fade" id="tiyan"
			style="margin-left: 600px; margin-top: -450px; width: 700px; height: 600px;">
			<table class="table" width="700px">
				<caption>
					<h4>体验金记录</h4>
				</caption>
				<thead>
					<tr>
						<th>产品</th>
						<th>付款日期</th>
						<th>状态</th>
					</tr>
				</thead>
				<tbody>
					<tr class="active">
						<td>产品1</td>
						<td>23/11/2013</td>
						<td>待发货</td>
					</tr>
					<tr class="success">
						<td>产品2</td>
						<td>10/11/2013</td>
						<td>发货中</td>
					</tr>
					<tr class="warning">
						<td>产品3</td>
						<td>20/10/2013</td>
						<td>待确认</td>
					</tr>
					<tr class="danger">
						<td>产品4</td>
						<td>20/10/2013</td>
						<td>已退货</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="aqxx"
			style="margin-left: 600px; margin-top: -450px; width: 700px; height: 600px;">
			<table class="table" width="700px">
				<caption>
					<h4>安全信息</h4>
				</caption>
				<thead>
					<tr>
						<th>产品</th>
						<th>付款日期</th>
						<th>状态</th>
					</tr>
				</thead>
				<tbody>
					<tr class="active">
						<td>产品1</td>
						<td>23/11/2013</td>
						<td>待发货</td>
					</tr>
					<tr class="success">
						<td>产品2</td>
						<td>10/11/2013</td>
						<td>发货中</td>
					</tr>
					<tr class="warning">
						<td>产品3</td>
						<td>20/10/2013</td>
						<td>待确认</td>
					</tr>
					<tr class="danger">
						<td>产品4</td>
						<td>20/10/2013</td>
						<td>已退货</td>
					</tr>
				</tbody>
			</table>
		</div>
		<script type="text/javascript">
		function ss(){
			 var s = $("#error").val(); 
			 var s1 = $("#error1").val(); 
			 var s2 = $("#error2").val(); 
			 var bank = $("#bank").val(); 
			 
			if(s==-1||s1==-1||s2==-1){
			alert("请选择正确的地址");
			return false;
			}
			if(bank==""){
				alert("请填写正确的银行卡号");
				
				return false;
			}
			 var reg=/^[0-9]{16,19}$/ 
			 if(!reg.test(bank)){    
		            alert("对不起，您输入的银行卡不正确!");//请将“英文字母类型”改成你需要验证的属性名称!    
		            return false;
			 }  
			
			alert("绑定成功！ 您的卡号为"+bank);
			return true;
			}
		</script>
		<div class="tab-pane fade" id="wytk"
			style="margin-left: 600px; margin-top: -450px; width: 500px; height: 600px;">
			<caption>
				<h4>我要提款</h4>
			</caption>
			<div style="padding: 50px 50px 10px;">
				<c:if test="${memberBankcards.id==null}">
				<form id="yinhangka" method="post" action="/Cornucopia/AgUserItem/toBank" onsubmit="return ss()">
					  <input type="hidden" name="dz1" class="dz1"/>
					    <input type="hidden" name="dz2" class="dz2"/>
					      <input type="hidden" name="dz3" class="dz3"/>
					<div class="input-group">
						<span class="input-group-addon">绑定银行卡</span> <input type="text"
							class="form-control" placeholder="请输入银行卡号" id="bank" name="card_no">
					</div><br>
							<input type="hidden" value="<%=datetime1%>" name="datebank">
					 <select id="error" name="error"   style="width: 130px;" onchange="fun2()">
					  <option  id="oid1" value="-1"  selected="selected" >请选择</option>
              <c:forEach items="${sysregion}" var="sysregion" >
          <option  id="oid" value="${sysregion.ID}"  >${sysregion.name}</option>
        </c:forEach>
       </select>
       	 <select id="error1" name="error1"   style="width: 130px;" onchange="fun3()">
          <option  id="oid1" value="-1"  selected="selected"  >请选择</option>
       	  </select>
       	 <select id="error2" name="error2"   style="width: 130px;"  onchange="fun5()">
          <option id="oid2" value="-1"  selected="selected"  >请选择</option>
         </select>
        <input type="submit" class="btn btn-default" value="立即绑定">
       
					</form>
				</c:if>
				<c:if test="${memberBankcards.id>0}">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="panel-body">
								<form class="bs-example bs-example-form" role="form"
									id="formupdate" method="post" action="/Cornucopia/Wi/statu">
									<div class="input-group">
										<span class="input-group-addon">账户余额</span>
										<div class="input-group">
											<input type="text" class="form-control" id="kyje"
												value="${MAccount.useable_balance}" readonly="readonly">
											<span class="input-group-addon">.00</span>
										</div>
									</div>
									<br>

									<div class="input-group">
										<span class="input-group-addon" >${memberBankcards.type}</span>
										<input type="text" class="form-control"
											placeholder="${memberBankcards.card_no}" readonly="readonly" name="bank_card">
									</div>
									<br>
									<input type="hidden" value="<%=datetime%>" name="serial_number">
									<input type="hidden" value="<%=datetime1%>" name="date">
									<input type="hidden" value="${memberBankcards.type}" name="bank_name">
								<input type="hidden" value="${memberBankcards.cardaddress}" name="cardaddress">
									
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon">提款金额</span> <input
												type="text" class="form-control" id="tkje" name="amount">
										</div>
									</div>
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon">提款密码</span> <input
												type="text" class="form-control" placeholder="提款密码">
										</div>
									</div>
									<br>
									<button type="submit" class="btn btn-default"
										onclick="func(${MAccount.useable_balance})">申请提现</button>
								</form>
							</div>
						</div>
					</div>

				</c:if>
			</div>
		</div>
	</div>
	<script>
	function fun2(){
		 var s1 = $("#error").val(); 
		 $(".dz1").val($("#error").find("option:selected").text()); 
		 var s2=0;
		 $("#error1").empty(); 
		 $.post("/Cornucopia/AgUserItem/queryInfo",{"id":s1},function(msg){
			 var city=$("#error1");
			 ws2=msg[0].id;
			 for(var i=0;i<msg.length;i++){
				 var option=new Option(msg[i].name,msg[i].id);
				 city.append(option);
				 $(".dz2").val($("#error1").find("option:selected").text()); 
			 }
			 $("#error2").empty(); 
			 fun4(ws2);
		 });
	}function fun4(ws2){
		 $("#error2").empty(); 
		 $("#d3").val($("#error2").find("option:selected").text()); 
		 $.post("/Cornucopia/AgUserItem/queryInfo",{"id":ws2},function(msg){
			 var city=$("#error2");
			 for(var i=0;i<msg.length;i++){
				 //创建一个html标签
				 var option=new Option(msg[i].name,msg[i].id);
				 city.append(option);
				 $(".dz3").val($("#error2").find("option:selected").text()); 
			 }
			 $("#error3").empty(); 
			 fun5();
		 });
	}
	function fun3(){
		 var s1 = $("#error1").val(); 
		 $(".dz2").val($("#error1").find("option:selected").text()); 
		 $("#error2").empty(); 
		 $.post("/Cornucopia/AgUserItem/queryInfo",{"id":s1},function(msg){
			 var city=$("#error2");
			 for(var i=0;i<msg.length;i++){
				 //创建一个html标签
				 var option=new Option(msg[i].name,msg[i].id);
				 city.append(option);
				 $(".dz3").val($("#error2").find("option:selected").text()); 
				 
			 }
		 });
	}
	function fun5(){
		 $(".dz3").val($("#error2").find("option:selected").text()); 
	}
	
	$(function () {
      $('#myTab li:eq(1) a').tab('show');
   });
   function func(box) {
		$('#formupdate').bootstrapValidator({
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				amount : {
					validators : {
						notEmpty : {
							message : '备注不能为空'
						},
						  numeric: {message: '提款金额只能输入数字'},  
				}
			}
			}
		});
	};
   
   </script>

	<!--===========layout-container================-->
	<div class="layout-footer">
		<div class="footer">
			<div style="background-color: #383d61" class="footer--bg"></div>
			<div class="footer--inner">
				<div class="container">
					<div class="footer_main">
						<div class="am-g">
							<div class="am-u-md-3 ">
								<div class="footer_main--column">
									<strong class="footer_main--column_title">关于我们</strong>
									<div class="footer_about">
										<p class="footer_about--text">云适配(AllMobilize Inc.)
											是全球领先的HTML5企业移动化解决方案供应商，由前微软美国总部IE浏览器核心研发团队成员及移动互联网行业专家在美国西雅图创立.
										</p>
										<p class="footer_about--text">
											云适配跨屏云也成功应用于超过30万家企业网站，包括微软、联想等世界500强企业</p>
									</div>
								</div>
							</div>

							<div class="am-u-md-3 ">
								<div class="footer_main--column">
									<strong class="footer_main--column_title">产品中心</strong>
									<ul class="footer_navigation">
										<li class="footer_navigation--item"><a href="#"
											class="footer_navigation--link">Enterplorer 企业浏览器</a></li>
										<li class="footer_navigation--item"><a href="#"
											class="footer_navigation--link">Xcloud 网站跨屏云</a></li>
										<li class="footer_navigation--item"><a href="#"
											class="footer_navigation--link">Amaze UI 前端开发框架</a></li>
										<li class="footer_navigation--item"><a href="#"
											class="footer_navigation--link">Amaze UI 前端开发框架</a></li>
										<li class="footer_navigation--item"><a href="#"
											class="footer_navigation--link">Amaze UI 前端开发框架</a></li>
									</ul>
								</div>
							</div>

							<div class="am-u-md-3 ">
								<div class="footer_main--column">
									<strong class="footer_main--column_title">技术支持</strong>
									<ul class="footer_navigation">
										<li class="footer_navigation--item"><a href="#"
											class="footer_navigation--link">企业移动信息化白皮书</a></li>
										<li class="footer_navigation--item"><a href="#"
											class="footer_navigation--link">企业移动信息化白皮书</a></li>
										<li class="footer_navigation--item"><a href="#"
											class="footer_navigation--link">企业移动信息化白皮书</a></li>
										<li class="footer_navigation--item"><a href="#"
											class="footer_navigation--link">企业移动信息化白皮书</a></li>
										<li class="footer_navigation--item"><a href="#"
											class="footer_navigation--link">企业移动信息化白皮书</a></li>
									</ul>
								</div>
							</div>

							<div class="am-u-md-3 ">
								<div class="footer_main--column">
									<strong class="footer_main--column_title">联系详情</strong>
									<ul class="footer_contact_info">
										<li class="footer_contact_info--item"><i
											class="am-icon-phone"></i><span>服务专线：400 069 0309</span></li>
										<li class="footer_contact_info--item"><i
											class="am-icon-envelope-o"></i><span>yunshipei.com</span></li>
										<li class="footer_contact_info--item"><i
											class="am-icon-map-marker"></i><span>北京市海淀区海淀大街27号天使大厦（原亿景大厦）三层</span></li>
										<li class="footer_contact_info--item"><i
											class="am-icon-clock-o"></i><span>更多模板 <a
												href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
												- Collect from <a href="http://www.cssmoban.com/"
												title="网页模板" target="_blank">网页模板</a></span></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="../assets/js/amazeui.js" charset="utf-8"></script>
	<script type="text/javascript">
	function fun1(sid){
		alert(sid);
	}
	
	</script>
</body>

</html>
