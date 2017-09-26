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
  <link rel="stylesheet" href="../assets/css/solution.min.css" />
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
                    <a href=""><img src="../assets/images/4.jpg" alt="" style="margin-top: -18px"/></a>
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
        <!--nav end-->
      </div>
    </div>
    </div><br>




    <!--===========layout-container================-->
    <div class="layout-container"  style="margin-left: 170px">
      <div> 
      <table>
       <tr>
        <td class="container">
        <div style="margin-left: 170px">
          <img alt="" src="../assets/images/solution/QQ截图20170907101215.png">
        </div>
        </td>
        <td class="container">
        <div >
          <img style="margin-left: 100px" alt="" src="../assets/images/solution/QQ截图20170907101300.png"><br>
          <img alt="" src="../assets/images/solution/QQ截图20170907101357.png"><br>
          <a href="#">
          <img style="margin-left: 50px" alt="" src="../assets/images/solution/QQ截图20170907101434.png"><br>
          </a>
          <a href="#">
          <img style="margin-left: 53px" alt="" src="../assets/images/solution/QQ截图20170907101454.png"><br>
          </a>
          </div>
        </td>
       </tr>
      </table><br>
          <img style="margin-left: 200px;width: 800;height: 150" alt="" src="../assets/images/solution/QQ截图20170907102122.png">
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
