<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!-- //获取系统时间必须导入的 -->
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>企业网站模板</title>
<link rel="stylesheet" href="../assets/css/amazeui.css" />
<link rel="stylesheet" href="../assets/css/common.min.css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/bootstrap-select.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
<link href="../assets/css/bootstrap-select.css" rel="stylesheet" />
</head>
<script type="text/javascript">
	
<%String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间%>
	$(function() {
		$('#form').bootstrapValidator({
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				member_name : {
					message : '用户名验证失败',
					validators : {
						notEmpty : {
							message : '姓名不能为空'
						},
						stringLength : {
							min : 6,
							max : 30,
							message : '用户名长度必须在6到30之间'
						}
					}
				},
				name : {
					validators : {
						notEmpty : {
							message : '昵称不能为空'
						},
						threshold : 3,
						remote : {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
							url : '/Cornucopia/AgUserItem/nc',
							message : '昵称已存在',//提示消息
							delay : 2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
							type : 'POST',//请求方式

						}
					}
				},
				invitedCode : {
					validators : {
						threshold : 12,
						remote : {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
							url : '/Cornucopia/AgUserItem/zhuce',
							message : '邀请码不存在',//提示消息
							delay : 4000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
							type : 'POST',//请求方式

						}
					}
				},
				identity : {
					message : '身份证验证失败',
					validators : {
						notEmpty : {
							message : '身份证不能为空'
						},
						stringLength : {
							min : 18,
							max : 18,
							message : '请输入18位身份证号码'
						},
						regexp : {
							regexp : /^[4]{0-9}[0-9]{16}[xX1-9]{0-9}$/,
							message : '请输入正确的身份证号码'
						},
						threshold : 3,
						remote : {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
							url : '/Cornucopia/AgUserItem/sfid',
							message : '身份证号已存在',//提示消息
							delay : 8000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
							type : 'POST',//请求方式

						}
					}
				},
				mobile_Phone : {
					message : 'The phone is not valid',
					validators : {
						notEmpty : {
							message : '手机号码不能为空'
						},
						stringLength : {
							min : 11,
							max : 11,
							message : '请输入11位手机号码'
						},
						regexp : {
							regexp : /^1[3|5|8]{1}[0-9]{9}$/,
							message : '请输入正确的手机号码'
						},
						threshold : 11,
						remote : {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
							url : '/Cornucopia/AgUserItem/phone',
							message : '手机号已经被注册',//提示消息
							delay : 5000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
							type : 'POST',//请求方式

						},
					}
				},
				password : {
					message : '密码无效',
					validators : {
						notEmpty : {
							message : '密码名不能为空'
						},
						stringLength : {
							min : 4,
							max : 30,
							message : '密码长度必须在4到30之间'
						},
						different : {//不能和用户名相同
							field : 'name',
							message : '不能和用户名相同'
						},
						regexp : {//匹配规则
							regexp : /^[a-zA-Z0-9_\.]+$/,
							message : '用户名不能为中文'
						}
					}
				},
				repassword : {
					message : '密码无效',
					validators : {
						notEmpty : {
							message : '密码名不能为空'
						},
						stringLength : {
							min : 4,
							max : 30,
							message : '密码长度必须在4到30之间'
						},
						identical : {//相同
							field : 'password',
							message : '两次密码不一致'
						},
						different : {//不能和用户名相同
							field : 'name',
							message : '不能和用户名相同'
						},
						regexp : {//匹配规则
							regexp : /^[a-zA-Z0-9_\.]+$/,
							message : '密码不能为中文'
						}
					}
				}

			}
		});
	});
</script>
<body class="register-container">
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


		<!-- 添加-->

		<div class="container" style="margin-top: 50px;">
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								添加角色
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
							</h3>
						</div>

						<div class="panel-body">
							<form id="form" method="post"
								action="/Cornucopia/AgUserItem/toRegister">
								<div class="form-group">
									<label>真实姓名:</label> <input type="text" class="form-control"
										placeholder="请输入真实姓名，需实名认证" name="member_name">
								</div>
								<div class="form-group">
									<label>身份证号码:</label> <input type="text" class="form-control"
										placeholder="请输入手机号码" name="identity" />
								</div>
								<div class="form-group">
									<label>昵称:</label> <input type="text" class="form-control"
										placeholder="请输入用户昵称，用于登录" name="name" />
								</div>
								<div class="form-group">
									<label>密码:</label> <input type="text" class="form-control"
										placeholder="请输入密码" name="password" />
								</div>
								<div class="form-group">
									<label>确认密码:</label> <input type="text" class="form-control"
										placeholder="确认密码" name="repassword" />
								</div>
								<div class="form-group">
									<label>手机号码:</label> <input type="text" class="form-control"
										placeholder="请输入手机号码" name="mobile_Phone" />
								</div>
								<div class="form-group">
									<label>邀请码:</label> <input type="text" class="form-control"
										placeholder="请输入邀请码! 非必填 " name="invitedCode" />
								</div>
								<input style="display: none;" name="create_date"
									value="<%=datetime%>"> <input style="display: none;"
									name="update_date" value="<%=datetime%>">

								<div class="form-group">
									<button type="submit" class="btn btn-primary">立即添加</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal -->
</body>

</html>
