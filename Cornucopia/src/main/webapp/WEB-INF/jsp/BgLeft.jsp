<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../BgAssets/js/jquery.js"></script>

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
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="../BgAssets/images/leftico01.png" /></span>理财产品
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="/Cornucopia/BgSubject/list1" target="rightFrame">固收类</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/finance/listFunds" target="rightFrame">私募/股权类</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgOver/list" target="rightFrame">海外配置</a><i></i></li>
      </ul>    
    </dd>
    <dd>
    <div class="title">
    <span><img src="../BgAssets/images/leftico02.png" /></span>钱包管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="/Cornucopia/BgItem/BgStade" target="rightFrame">钱包缴费记录</a><i></i></li>
        </ul>     
    </dd> 
    
    
      <dd><div class="title"><span><img src="../BgAssets/images/leftico04.png" /></span>学院管理</div>
    <ul class="menuson">
        <li class="active"><cite></cite><a href="/Cornucopia/BgType/BgConsultation" target="rightFrame">咨询分类</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgNews/BgTration" target="rightFrame"">咨询管理</a><i></i></li>
    </ul>
    
    </dd>  
    
    <dd><div class="title"><span><img src="../BgAssets/images/leftico04.png" /></span>权限管理</div>
        <ul class="menuson">
        <li><cite></cite><a href="/Cornucopia/BgItem/BgUserPermission" target="rightFrame">用户管理</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgItem/BgUserRoles" target="rightFrame">角色管理</a><i></i></li>
        </ul>    

    <dd><div class="title"><span><img src="../BgAssets/images/leftico04.png" /></span>会员管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="/Cornucopia/BgItem/BgAccountManagement" target="rightFrame">账号管理</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgItem/BgCardBinding" target="rightFrame">绑卡管理</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgItem/BgServicePlan" target="rightFrame">付息计划</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgItem/BgRechargeRecord" target="rightFrame">充值管理</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/Wi/findTask" target="rightFrame">体现管理</a><i></i></li>
    </ul>
    
    </dd>  
    
     <dd><div class="title"><span><img src="../BgAssets/images/leftico04.png" /></span>盈+统计</div>
    <ul class="menuson">
        <li><cite></cite><a href="#" target="rightFrame">财务统计</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/backYingJiaUsersComprehensiveStatistics/login" target="rightFrame">用户综合统计</a><i></i></li>
    </ul>
    
    </dd>  
    
    <dd><div class="title"><span><img src="../BgAssets/images/leftico04.png" /></span>盈+设置</div>
    <ul class="menuson">
        <li><cite></cite><a href="/Cornucopia/push/list" target="rightFrame">公告管理</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/feed/list" target="rightFrame">意见反馈</a><i></i></li>
    </ul>
    
    </dd> 
    
    <dd><div class="title"><span><img src="../BgAssets/images/leftico04.png" /></span>系统设置</div>
    <ul class="menuson">
        <li><cite></cite><a href="/Cornucopia/BgItem/PsssWorld" target="rightFrame">密码设置</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgItem/BgLogin"  onclick="func()" target="rightFrame">安全退出</a><i></i></li>
    </ul>
    
    </dd> 
    
    </dl>
    <script type="text/javascript">
	function func(){
		window.top.location.replace('/Cornucopia/BgItem/BgLogin');
	}
	</script>
</body>
</html>
