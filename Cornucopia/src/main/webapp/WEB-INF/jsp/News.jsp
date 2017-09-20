<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>企业网站模板</title>
  <link rel="stylesheet" href="../assets/css/amazeui.css" />
  <link rel="stylesheet" href="../assets/css/common.min.css" />
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
                  <button class="am-btn am-btn-primary am-dropdown-toggle" data-am-dropdown-toggle>Language<span class="am-icon-caret-down"></span></button>
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
                加入我们
                <i class="am-icon-facebook"></i>
                <i class="am-icon-twitter"></i>
                <i class="am-icon-google-plus"></i>
                <i class="am-icon-pinterest"></i>
                <i class="am-icon-instagram"></i>
                <i class="am-icon-linkedin"></i>
                <i class="am-icon-youtube-play"></i>
                <i class="am-icon-rss"></i>
                	<c:if test="${empty Lname}">  <a href="/Cornucopia/item/Login1">登录</a> <a
									href="/Cornucopia/item/Register">注册</a></c:if>	
									<c:if test="${not empty Lname}"> 欢迎您: ${Lname}
 <a
									href="/Cornucopia/item/Login1">退出登陆</a>
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
  												<i style="color:#7c6aa6" class="contact-icon am-icon-phone"></i>
  												<strong>0575-84085869</strong>
  												<span>周一~周五, 8:00 - 20:00</span>
  											</div>
  										</div>
                      <div class="header_contacts--item">
  											<div class="contact_mini">
  												<i style="color:#7c6aa6" class="contact-icon am-icon-envelope-o"></i>
  												<strong>13197176376@163.com</strong>
  												<span>随时欢迎您的来信！</span>
  											</div>
  										</div>
                      <div class="header_contacts--item">
  											<div class="contact_mini">
  												<i style="color:#7c6aa6" class="contact-icon am-icon-map-marker"></i>
  												<strong>汉水华城</strong>
  												<span>樊城区长虹路27号</span>
  											</div>
  										</div>
                    </div>
                    <a href="/Cornucopia/item/Contact" class="contact-btn">
                      <button type="button" class="am-btn am-btn-secondary am-radius">联系我们</button>
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
              <li>
                 <a href="#">网上体验中心</a>
                <!-- sub-menu start-->
                <ul class="sub-menu">
                  <li class="menu-item"><a href="/Cornucopia/item/Product1">产品展示1</a></li>
                  <li class="menu-item"><a href="/Cornucopia/item/Product2">产品展示2</a></li>
                  <li class="menu-item"><a href="/Cornucopia/item/Product3">产品展示3</a></li>
                </ul>
                <!-- sub-menu end-->
              </li>
              <li><a href="/Cornucopia/AGSub/subject">产品中心</a></li>
              <li><a href="/Cornucopia/item/Solution">下载中心</a></li>
              <li>
                <a href="/Cornucopia/item/News">新闻中心</a>
                <!-- sub-menu start-->
                <ul class="sub-menu">
                  <li class="menu-item"><a href="/Cornucopia/item/NewsC">盈+商学院</a></li>
                  <li class="menu-item"><a href="html/404-dark.html">行业动态</a></li>
                  <li class="menu-item"><a href="html/404-light.html">精彩专题</a></li>
                </ul>
                <!-- sub-menu end-->
              </li>
              <li><a href="/Cornucopia/item/About">盈+商学院</a></li>
              <li><a href="/Cornucopia/item/Join">投研中心</a></li>
              <li><a href="/Cornucopia/item/Contact">我的加法库</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
 </div>
    <div class="breadcrumb-box" style="margin-top: 10px;">
        <div class="am-container">
          <ol class="am-breadcrumb">
           
          </ol>
        </div>
      </div>
    <div id="myTab" class="nav nav-pills nav-stacked"
		style="width: 200px; margin-top: 30px; margin-left: 350px;">
		<a href="#touzi" data-toggle="tab"> 投资记录</a><br>
		<a href="#yuyue" data-toggle="tab">预约记录</a><br>
		<a href="#jine" data-toggle="tab">充值记录 </a><br>
		<a href="#shouyi" data-toggle="tab">收益记录 </a><br>
		<a href="#tikuan" data-toggle="tab">提款记录 </a><br>
	<a href="#tiyan" data-toggle="tab">体验金记录 </a><br>
		<a href="#aqxx" data-toggle="tab">安全信息 </a><br>
		<a href="#wytk" data-toggle="tab">我要提款 </a><br>
	</div>
	<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade" id="tiyan"
			style="margin-left: 600px; margin-top: -200px; width: 700px; height: 600px;">
			<table class="table" width="700px">
				<caption>
					<h4>体验金记录</h4>
				</caption>
				<a href="#txmm"  class="tk" data-toggle="tab">设置提款密码 </a>
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
			<div class="tab-pane fade" id="txmm"
			style="margin-left: 600px; margin-top: -200px; width: 700px; height: 600px;">
			<table class="table" width="700px">
            <a href="#tiyan" data-toggle="tab">上级</a>/
         <a href="#txmm" data-toggle="tab">本级</a>/
          <a href="#xiaji" data-toggle="tab">下级</a>/
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
					
					<tr class="danger">
						<td>产品4</td>
						<td>20/10/2013</td>
						<td>已退货</td>
					</tr>
				</tbody>
			</table>
		</div>
   </div>
    <!--===========layout-footer================-->
    <div class="layout-footer">
      <div class="footer">
        <div style="background-color:#383d61" class="footer--bg"></div>
        <div class="footer--inner">
          <div class="container">
            <div class="footer_main">
              <div class="am-g">
                <div class="am-u-md-3 ">
                  <div class="footer_main--column">
                    <strong class="footer_main--column_title">关于我们</strong>
                    <div class="footer_about">
												<p class="footer_about--text">
													云适配(AllMobilize Inc.) 是全球领先的HTML5企业移动化解决方案供应商，由前微软美国总部IE浏览器核心研发团队成员及移动互联网行业专家在美国西雅图创立.
												</p>
												<p class="footer_about--text">
                          云适配跨屏云也成功应用于超过30万家企业网站，包括微软、联想等世界500强企业
												</p>
											</div>
                  </div>
                </div>

                <div class="am-u-md-3 ">
                  <div class="footer_main--column">
										<strong class="footer_main--column_title">产品中心</strong>
										<ul class="footer_navigation">
											<li class="footer_navigation--item"><a href="#" class="footer_navigation--link">Enterplorer 企业浏览器</a></li>
											<li class="footer_navigation--item"><a href="#" class="footer_navigation--link">Xcloud 网站跨屏云</a></li>
											<li class="footer_navigation--item"><a href="#" class="footer_navigation--link">Amaze UI 前端开发框架</a></li>
											<li class="footer_navigation--item"><a href="#" class="footer_navigation--link">Amaze UI 前端开发框架</a></li>
											<li class="footer_navigation--item"><a href="#" class="footer_navigation--link">Amaze UI 前端开发框架</a></li>
										</ul>
									</div>
                </div>

                <div class="am-u-md-3 ">
                  <div class="footer_main--column">
										<strong class="footer_main--column_title">技术支持</strong>
										<ul class="footer_navigation">
											<li class="footer_navigation--item"><a href="#" class="footer_navigation--link">企业移动信息化白皮书</a></li>
											<li class="footer_navigation--item"><a href="#" class="footer_navigation--link">企业移动信息化白皮书</a></li>
											<li class="footer_navigation--item"><a href="#" class="footer_navigation--link">企业移动信息化白皮书</a></li>
											<li class="footer_navigation--item"><a href="#" class="footer_navigation--link">企业移动信息化白皮书</a></li>
											<li class="footer_navigation--item"><a href="#" class="footer_navigation--link">企业移动信息化白皮书</a></li>
										</ul>
									</div>
                </div>

                <div class="am-u-md-3 ">
                  <div class="footer_main--column">
										<strong class="footer_main--column_title">联系详情</strong>
										<ul class="footer_contact_info">
											<li class="footer_contact_info--item"><i class="am-icon-phone"></i><span>服务专线：400 069 0309</span></li>
											<li class="footer_contact_info--item"><i class="am-icon-envelope-o"></i><span>yunshipei.com</span></li>
											<li class="footer_contact_info--item"><i class="am-icon-map-marker"></i><span>北京市海淀区海淀大街27号天使大厦（原亿景大厦）三层</span></li>
											<li class="footer_contact_info--item"><i class="am-icon-clock-o"></i><span>更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></span></li>
										</ul>
									</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="../assets/js/jquery-2.1.0.js" charset="utf-8"></script>
  <script src="../assets/js/amazeui.js" charset="utf-8"></script>
</body>

</html>
