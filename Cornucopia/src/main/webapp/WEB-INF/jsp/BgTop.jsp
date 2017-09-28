<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../BgAssets/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(../BgAssets/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="../BgAssets/images/logo.png" title="系统首页" /></a>
    </div>
     
    
    <ul class="nav">
        <li><a href="/Cornucopia/BgItem/BgImgTable" target="rightFrame"><img src="../BgAssets/images/icon02.png" title="财务统计" /><h2>财务统计</h2></a></li>
    <li><a href="/Cornucopia/backYingJiaUsersComprehensiveStatistics/login"  target="rightFrame" class="selected"><img src="../BgAssets/images/icon01.png" title="财务统计" /><h2>用户统计</h2></a></li>
    <li><a href="/Cornucopia/BgItem/BgServicePlan"  target="rightFrame"><img src="../BgAssets/images/icon03.png" title="付息计划" /><h2>付息计划</h2></a></li>
    <li><a href="/Cornucopia/BgItem/BgStade"  target="rightFrame"><img src="../BgAssets/images/icon04.png" title="缴费记录" /><h2>缴费记录</h2></a></li>
    <li><a href="/Cornucopia/BgItem/BgUserPermission"  target="rightFrame"><img src="../BgAssets/images/icon06.png" title="用户管理" /><h2>用户管理</h2></a></li>
    </ul>
 
            
    <div class="topright">    
    <ul>
    <li><span><img src="../BgAssets/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="/Cornucopia/BgItem/BgLogin " target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>欢迎你${string}<shiro:principal type="java.lang.String"/></span>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div>
</body>
</html>
