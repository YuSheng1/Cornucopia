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
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="../BgAssets/images/leftico01.png" /></span>管理信息
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="/Cornucopia/BgItem/BgIndex" target="rightFrame">首页模版</a><i></i></li>
        <li class="active"><cite></cite><a href="/Cornucopia/BgItem/BgRight.html" target="rightFrame">数据列表</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgItem/BgImgTable" target="rightFrame">图片数据表</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgItem/Bgform" target="rightFrame">添加编辑</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgItem/BgImgList" target="rightFrame">图片列表</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgItem/BgTools" target="rightFrame">常用工具</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgItem/BgTab" target="rightFrame">Tab页</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="../BgAssets/images/leftico02.png" /></span>其他设置
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#">编辑内容</a><i></i></li>
        <li><cite></cite><a href="#">发布信息</a><i></i></li>
        <li><cite></cite><a href="#">档案列表显示</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="../BgAssets/images/leftico03.png" /></span>编辑器</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">自定义</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="../BgAssets/images/leftico04.png" /></span>日期管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">自定义</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>
    
    </dd>   
    
    <dd><div class="title"><span><img src="../BgAssets/images/leftico04.png" /></span>学院管理</div>
    <ul class="menuson">
        <li class="active"><cite></cite><a href="/Cornucopia/BgItem/BgConsultation" target="rightFrame">咨询分类</a><i></i></li>
        <li><cite></cite><a href="/Cornucopia/BgItem/BgTration" target="rightFrame"">咨询管理</a><i></i></li>
    </ul>
    
    </dd>  
    
    </dl>
</body>
</html>
