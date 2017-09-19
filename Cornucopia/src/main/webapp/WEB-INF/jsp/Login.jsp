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
<title>企业网站模板</title>
<link rel="stylesheet" href="../assets/css/amazeui.css" />
<link rel="stylesheet" href="../assets/css/common.min.css" />
<link rel="stylesheet" href="../assets/css/contact.min.css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
</head>
<script type="text/javascript">
	$(function() {
		$('#formupdate').bootstrapValidator({
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				Lname : {
					message : '用户名验证失败',
					validators : {
						notEmpty : {
							message : '用户名不能为空'
						}
					}
				},
				Lpassworld : {
					validators : {
						notEmpty : {
							message : '备注不能为空'
						}
					}
				}

			}
		});
	});
</script>
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
								<a href="/Cornucopia/item/Login1">登录</a> <a
									href="/Cornucopia/item/Register">注册</a>
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

		<!--mobile header end-->
	</div>
	<div class="section" style="margin-top: -151px;">
		<div class="container">


			<div class="section-container">
				<div class="am-g">
					<!--contact-left start-->
					<div class="am-u-md-5">
						<ul class="contact-left">
							<li class="contact-box-item">
								<div class="contact_item">
									<i class="contact_item--icon am-icon-phone"></i>
									<h3 class="contact_item--title">联系我们</h3>
									<p class="contact_item--text">
										联系电话： <strong>84</strong>, <br> Monday - Friday, 8am -
										7pm
									</p>
								</div>
							</li>
							<li class="contact-item">
								<div class="contact_item">
									<i class="contact_item--icon am-icon-envelope-o"></i>
									<h3 class="contact_item--title">Drop a Line</h3>
									<p class="contact_item--text">
										service@yunshipei.com, <br />期待您的来信...
									</p>
								</div>
							</li>
							<li class="contact-item">
								<div class="contact_item">
									<i class="contact_item--icon am-icon-map-marker"></i>
									<h3 class="contact_item--title">Visit Us</h3>
									<p class="contact_item--text">北京市海淀区海淀大街27号天使大厦（原亿景大厦）三层西侧
									</p>
								</div>
							</li>
						</ul>
					</div>
				</div>


			</div>
			<!--contact-right end-->
		</div>
	</div>
				<!-- 用户登陆 -->
						<!--contact-right start-->
							<div class="row" style="margin-top: -10px;margin-left: 130px;">
            <div class="col-lg-4 col-lg-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">用户登录
          </h3>
                    </div>
                    <div class="panel-body">
                       	<form id="formupdate" method="post"  action="/Cornucopia/AgUserItem/toMain">
                            <div class="form-group">
                                <label>用户名:</label>
                                 <input type="text" class="form-control"  name="Lname" id="Lname">
                            </div>
                            <div class="form-group">
                                <label>角色备注:</label>
                               <input  type="text" class="form-control"  name="Lpassworld" id="Lpassworld"/>
                            </div>
<font color="red" style="font-size: 15px">${message}</font>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">立即添加</button>
                            </div>
                            
                        </form>
                    </div>
                </div>
            </div>
    </div>
					
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
	

</body>

</html>
