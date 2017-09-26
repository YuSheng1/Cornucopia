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
<link rel="stylesheet" href="../assets/css/index.min.css" />
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jquery.min.js"></script>
<style type="text/css">
 *{list-style: none;margin:0;padding: 0;text-decoration: none;}
    .box{
        position: relative;
        width: 20%;
        height: 30px;
        top:50px;
        left:50px;
        overflow-y: hidden;
    }
    #box-ul{
        position: absolute;
        top:0;
        left:0;
    }
    #box-ul li{height:30px;line-height: 30px;}
</style>
<script type="text/javascript">
window.onload = function () {

    function getStyle(obj,styleName){           //获取元素当前style函数,currentStyle针对ie,getComputedStyle针对其他浏览器
        if(obj.currentStyle){
            return obj.currentStyle[styleName];
        }else{
            return getComputedStyle(obj,false)[styleName];
        }
    }

    function timerFuc() {                       //定时器函数，五秒钟滚动一条数据
        clearInterval(timer);
        timer = setInterval(function () {
            if(i == box.children.length-1) {
                box.style.top = '0px';
                i = 0;
            }
            animateTop(box,(++i)*(-30),30);     //此处第一个的30是li标签的高度,修改的时候这里得注意,第二个是speed
        },2000);
    }

    function animateTop(obj,topEnd,speed) {      //滚动函数,object为对象,topEnd为top最终值,speed为滚动速度
        clearInterval(obj.timer);
        obj.timer = setInterval(function () {
            var cur = parseInt(getStyle(obj,'top').slice(0,-2));
            var curspeed = Math.ceil((cur - topEnd)/10);
            obj.style.top = cur - curspeed +'px';
            if(curspeed == 0){
                clearInterval(obj.timer);
            }
        },speed)
    }


    var i = 0;
    var timer;
    var box = document.getElementById('box-ul');
    var node = document.getElementById('box-ul').firstElementChild.cloneNode(true);     //此处需先克隆节点以便下一步的追加节点操作，类似于jq的clone操作，这地方需要注意，如果不克隆直接获取Element对象会有什么影响，请实践后进行思考。
    box.appendChild(node);
    timerFuc();                 //初始化需执行定时器函数

    box.onmouseover = function () {
        clearInterval(timer);
    };
    box.onmouseout = function () {
        timerFuc();
    }
};
function fun(id){
	window.open("/Cornucopia/push/cha1?id="+id,"","width=400,height=400,top=300,left=1050")
}
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
									<a href="/Cornucopia/item/Login1">登录</a>
									<a href="/Cornucopia/item/Register">注册</a>
								</c:if>
								<c:if test="${not empty Lname}"> 欢迎您: ${Lname}
 							<a href="/Cornucopia/item/Login1">退出登陆</a>
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
									<a href=""><img src="../assets/images/4.jpg" alt=""
										style="margin-top: -18px" /></a>
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
				<!--nav end-->
			</div>
		</div>
	</div>
	<!--===========layout-container================-->
	<div class="layout-container">
		<div class="index-page">
			<div data-am-widget="tabs" class="am-tabs am-tabs-default">
				<div class="am-tabs-bd">
					<div data-tab-panel-0 class="am-tab-panel am-active">
						<div class="index-banner">
							<div class="index-mask">
								<div class="container">
									<div class="am-g">
										<div class="am-u-md-10 am-u-sm-centered">
											<h1 class="slide_simple--title">盈+理财，让你的钱聪明起来</h1>
											<p class="slide_simple--text am-text-left">
											<h3>我们要求高收益的同时更注重资金的安全，月月钱滚钱，月月可提现!</h3>
											</p>
											<div class="slide_simple--buttons">
												<button type="button" class="am-btn am-btn-danger">了解更多</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<div class="panel panel-primary"
		style="margin-left: 502px; width: 700px; height: 30px; margin-top: 10px;">
		<div style="margin-left: 20px; width: 100px; margin-top: 4px;">
			<img alt="" src="../assets/images/gg.jpg"
				style="width: 20px; height: 20px;">
			<h3 class="panel-title" style="margin-left: 20px; margin-top: -18px;">最新公告:</h3>
		</div>
		<div class="box" style="margin-left: 80px;margin-top: -73px;">
    <ul id="box-ul">
    <c:forEach items="${list}" var="s" varStatus="stat">
        <li><a href="#" onclick="fun(${s.id})">${s.title}</a></li>
        </c:forEach>
    </ul>
</div>
	</div>





	<div class="section" style="border-bottom: 1px solid #e9e9e9;">
		<div class="container">
			<div class="section--header">
				<h2 class="section--title">我们的服务</h2>
				<p class="section--description">
					来自三阳科技的实力最强颜值最高得的team为您倾心打造，让你用得放心用得开心。在线客服1号康熙二十四小时全心全意为您排忧解答，欢迎致电欢迎骚扰，联系方式15278733243。
				</p>
			</div>

			<!--index-container start-->
			<div class="index-container">
				<div class="am-g">
					<div class="am-u-md-3">
						<div class="service_item">
							<i class="service_item--icon am-icon-diamond"></i>
							<h3 class="service_item--title">多页面工作</h3>
							<div class="service_item--text">
								<p>标签栏可切换，不必为了新内容而被迫跳转界面，多项工作内容并行处理</p>
							</div>
							<footer class="service_item--footer"> <a href="#"
								class="link -blue_light">Learn More>></a></footer>
						</div>
					</div>

					<div class="am-u-md-3">
						<div class="service_item">
							<i class="service_item--icon am-icon-user"></i>
							<h3 class="service_item--title">统一入口</h3>
							<div class="service_item--text">
								<p>集成企业内网所有资源，OA、CRM、ERP、邮件系统，单点登录，无需重复输入密码</p>
							</div>
							<footer class="service_item--footer"> <a href="#"
								class="link -blue_light">Learn More>></a></footer>
						</div>
					</div>

					<div class="am-u-md-3">
						<div class="service_item">
							<i class="service_item--icon am-icon-umbrella"></i>
							<h3 class="service_item--title">一键直达</h3>
							<div class="service_item--text">
								<p>办公流程太多，搜索框输入（或语音输入），可以快速找到核心内容</p>
							</div>
							<footer class="service_item--footer"> <a href="#"
								class="link -blue_light">Learn More>></a></footer>
						</div>
					</div>

					<div class="am-u-md-3">
						<div class="service_item">
							<i class="service_item--icon am-icon-briefcase"></i>
							<h3 class="service_item--title">语音助手</h3>
							<div class="service_item--text">
								<p>不方便打字时，可以直接用语音输入想要的内容，使您的双手得到解放</p>
							</div>
							<footer class="service_item--footer"> <a href="#"
								class="link -blue_light">Learn More>></a></footer>
						</div>
					</div>
				</div>
			</div>
			<!--index-container end-->
		</div>
	</div>


	<



	<div class="section promo_banner-container">
		<!--index-container start-->
		<div class="promo_banner-box">
			<div class="container">
				<h2 class="promo_banner--title">期待您的加入</h2>
				<p class="promo_banner--text">
					我们成立了三年，正用自己的技术力量一步一步改变世界。 <br>
					我们开创了中国首个开源HTML5跨屏前端框架、可见即可得的IDE、无障碍网页我们是全球独一无二的 <br>
					云适配技术，我们的目标是打造极致的网页体验。
					<footer class="promo_banner--footer">
					<button type="button" class="am-btn am-btn-secondary">MORE>></button>
					</footer>
			</div>
		</div>
		<!--index-container end-->
	</div>



	<!--customer-logo start-->
	<div class="customer-logo">
		<div class="container">
			<div class="am-g">
				<div class="am-u-md-2 am-u-sm-4 customer-box">
					<a href="#"> <img class="normal-logo"
						src="../assets/images/index/customer_logo_Microsoft.png" alt="" />
						<img class="am-active" alt=""
						src="../assets/images/index/customer_logo_Microsoft_active.png"
						alt="" />
					</a>
				</div>
				<div class="am-u-md-2 am-u-sm-4 customer-box">
					<a href="#"> <img class="normal-logo"
						src="../assets/images/index/customer_logo_qhdx.png" alt="" /> <img
						class="am-active"
						src="../assets/images/index/customer_logo_qhdx_active.png" alt="" />
					</a>
				</div>
				<div class="am-u-md-2 am-u-sm-4 customer-box">
					<a href="#"> <img class="normal-logo"
						src="../assets/images/index/customer_logo_gmw.png" alt="" /> <img
						class="am-active"
						src="../assets/images/index/customer_logo_gmw_active.png" alt="" />
					</a>
				</div>
				<div class="am-u-md-2 am-u-sm-4 customer-box">
					<a href="#"> <img class="normal-logo"
						src="../assets/images/index/customer_logo_gov.png" alt="" /> <img
						class="am-active"
						src="../assets/images/index/customer_logo_gov_active.png" alt="" />
					</a>
				</div>
				<div class="am-u-md-2 am-u-sm-4 customer-box">
					<a href="#"> <img class="normal-logo"
						src="../assets/images/index/customer_logo_jl.png" alt="" /> <img
						class="am-active"
						src="../assets/images/index/customer_logo_jl_active.png" alt="" />
					</a>
				</div>
				<div class="am-u-md-2 am-u-sm-4 customer-box">
					<a href="#"> <img class="normal-logo"
						src="../assets/images/index/customer_logo_hx.png" alt="" /> <img
						class="am-active"
						src="../assets/images/index/customer_logo_hx_active.png" alt="" />
					</a>
				</div>
			</div>
		</div>
	</div>
	<!--customer-logo end-->


	<div class="section"
		style="margin-top: 0px; background-image: url('../assets/images/pattern-light.png');">
		<div class="container">
			<!--index-container start-->
			<div class="index-container">
				<div class="am-g">
					<div class="am-u-md-4">
						<div class="contact_card">
							<i style="color: #59bcdb"
								class="contact_card--icon am-icon-phone"></i> <strong
								class="contact_card--title">Contact Us</strong>
							<p class="contact_card--text">
								Feel free to call us on <br> <strong>0 (855)
									233-5385</strong> <br> Monday - Friday, 8am - 7pm
							</p>
							<button type="button" class="am-btn am-btn-secondary">Order
								a Call Back</button>
						</div>
					</div>
					<div class="am-u-md-4">
						<div class="contact_card">
							<i style="color: #59bcdb"
								class="contact_card--icon am-icon-envelope-o"></i> <strong
								class="contact_card--title">Our Email</strong>
							<p class="contact_card--text">
								Drop us a line anytime at <br> <strong><a
									href="mailto:info@financed.com">info@financed.com</a>,</strong> <br>
								and we’ll get back soon.
							</p>
							<button type="button" class="am-btn am-btn-secondary">Start
								Writing</button>
						</div>
					</div>
					<div class="am-u-md-4">
						<div class="contact_card">
							<i style="color: #59bcdb"
								class="contact_card--icon am-icon-map-marker"></i> <strong
								class="contact_card--title">Our Address</strong>
							<p class="contact_card--text">
								Come visit us at <br> <strong>Stock Building, New
									York,</strong> <br> NY 93459
							</p>
							<button type="button" class="am-btn am-btn-secondary">See
								the Map</button>
						</div>
					</div>
				</div>
			</div>
			<!--index-container end-->
		</div>
	</div>




	<!--===========layout-footer================-->
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
	<script src="../assets/js/jquery-2.1.0.js" charset="utf-8"></script>
	<script src="../assets/js/amazeui.js" charset="utf-8"></script>
	<script src="../assets/js/common.js" charset="utf-8"></script>



</body>

</html>
