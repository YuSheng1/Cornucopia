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
  <link rel="stylesheet" href="../assets/css/join.min.css" />
    <link rel="stylesheet" href="../assets/css/product.min.css" />
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
              <li><a href="/Cornucopia/AGSub/subject">产品中心</a></li>
              <li><a href="/Cornucopia/item/Solution">下载中心</a></li>
              <li>
                <a href="/Cornucopia/item/News">新闻中心</a>
                <!-- sub-menu start-->
                
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
    </div>
    
    

    <div class="breadcrumb-box" style="margin-top: 10px;">
        <div class="am-container">
          <ol class="am-breadcrumb">
            <li><a href="/Cornucopia/item/Index">首页</a></li>
            <li class="/Cornucopia/item/News">新闻中心</li>
          </ol>
        </div>
      </div>
    </div>
    <div class="section" style="margin-top: -150px;">
      <div class="container">

        <div class="join-container" style="margin-left: 130px">
          <div class="am-g">
            <div class="am-u-md-9">
            
              <div class="careers--vacancies">
                <div class="am-panel-group" id="accordion">
                  <div class="am-panel am-panel-default">
                    <div class="am-panel-hd">
                      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-1'}">
                        理财大讲堂
                      </h4>
                    </div>
                    <div id="do-not-say-1" class="am-panel-collapse am-collapse am-in">
                      <div class="am-panel-bd">
                        <div class="vacancies--item_content js-accordion--pane_content" style="">
														<h5>什么是投资理财？</h5>
														<p>理财是理一生的财，不是解决燃眉之急的金钱问题而已。
														而是一个可持续循环的过程。 理财是现金流量管理，
														每一个人一出生就需要用钱（现金流出）、也需要赚钱来产生现金流入。
														因此不管是否有钱，每一个人都需要理财。 理财也涵盖了风险管理。
														因为未来的更多流量具有不确定性，包括人身风险、财产风险与市场风险，
														都会影响到现金流入（收入中断风险）或现金流出（费用递增风险）。</p>
														<h5>如何投资理财？</h5>
														<p>投资其实就是一种形式而已，但是随着人类社会不断的进步，
														社会发展中越来越多的人开始关注投资，而且投资知识也有人想了解。
														 投资理财现在慢慢的在走进我们的生活，我们可以享受亲民化的理财产品，
														 来给我们的财富做合理的资产配资，现在一些社区金融的理财产品还是很适合我们进行投资理财的。
														  风险投资有很多的要素，比如有风险资本、投资人、投资对象、投资期限、投资目的和投资方式。
														  投资者将对资本的投向及领域需要有个全面的了解，一些的投资领域也是蕴含着重大的失败的风险的，
														  所以就叫做风险投资，从这个投资行为来说专业化的投资，一般都能找到具有潜能的企业。 
														  风险投资同业也成为了很多的新兴企业的福星，对于一些高科技的创新企业来说是一笔非常宝贵的资源，
														  高科技的创新需要的就是资金方面的支持，保证让其商品化，产业化，从而到达了一定的受益。
														  风险企业投入的权益一般会占企业的三成以上，双方也都是互惠互利的。
														  投资怎样获得回报，通过上市、转让股权的方式来实现增值。</p>
														<h5>投资理财一般步骤</h5>
														<p>首先：专业理财分析师都是有很好的心态的，你看看金融市场中是不是很喧闹呢?
														但是分析师照样可以安静的一个人在那里分析市场，所以不会受到其他人的干扰，
														所以要想做一个技术高超的理财分析师，我们就要学会控制好自己的心态，
														以后在做单的时候遇到大风大浪是不会有很多的心理变化的。
														 其次：精准的分析来源于我们的收集和判断，一个行情能不能做进去，我们之前就要进行分析，
														 那么怎么分析呢?分析师都会按照消息面的数据进行查询，可以查询之前的数据和预估数值进行对比，
														 另外需要在市场中找出一些重要人物对相关的消息所抛出的言论，综合分析后就会有一个比较明朗的界限。
														  再者：做单干净利索，一个单子分析好了后，也看到点位到了相应的点数了，
														  这个时候我们的投资分析师就会毫不犹豫的进场，根据不同的点位进行相应的参数设置，
														  那么投资理财分析师是不会有很大的顾忌做单的，不会和其他投资者一样，进去会不会有亏损的担忧。
														  单子只要坐进去到了相应的点位也不会留恋就直接出仓。</p>
														<h5>财富的4321定律</h5>
														<p>财富的4321定律：即财产的合理配置的比例是，家庭总收入的五分之二用于房贷等长期固定资产的投资；
														30%用于家庭日常生活开支；五分之一用于灵活的银行存款以备应急之需；
														剩下的少部分用于保险保障或者风险系数与收益系数都比较高的股票、期货投资。</p>
														<h5>财富的72定律</h5>
														<p>财富的 72定律：投资理财所获得的收益，一般不取出，而继续投入理财本金，实现利滚利的高收益财，
														本金增值一倍所需要的时间等于72除以年收益率。假如在银行存款1万元，年利率是2%，
														那末经过多少年才能增值为2万元？只要用72除以2得36，便可=大概知道银行存款需36年才能翻番。
														投资的关键之处，对个人及家庭亲人身体健康的投资：即使你所投资的项目有100%的收益每一年，
														但却健康情况很差，那投资赚再多的财富又有什么用呢。对身体健康的投资保持有健康的身体是人生的根基
														，而健康是生命的基本保证和追求人生理想的前提条件，是最大的财富。有健康，才有生命的保证，
														才能实现财富的意义。投资切忌鼠目寸光，而要有高远的战略眼光：短线投资目光不能短视，
														长线投资也要有辩证的发展眼光，今天的朝阳产业也许明天会变为夕阳产业。选择好的投资，
														小钱会生大钱。反之，则可能会像"肉包子打狗，有去无回"。金钱在于运动：金钱的本质在于流动，
														钱是不能休眠的。当今经济社会发展日新月异，资金只能在投资流通中才能不断实现保值和增值。
														投资失误是损失，资金停滞不动也是损失。投资组合考虑的时候，应考虑到家庭资产的情况，
														风险程度，时间投资期限，变现能力，投资灵活性，都要进行综合考虑，
														保证在家庭有紧迫需求时能马上变换出需要的资金。风险忍受度原则即"生活风险忍受度"，
														保障本金是投资理财的重中之重，一切投资都需要遵守此规则。理财的前提必须是要有人一定的财可理，
														而且应该有定期的稳定收入源，不然，无基本之财怎么理。接着，建立一个家庭资产情况一览表，
														你需要随时清楚地掌握了解家庭的财产数额和资产性质，同时也要了解相应的财产法规。
														其次，理财需要多元化理财，理财所用的资本要多元化投资，切不可将许多鸡蛋放在一个篮子里，
														分散风险，扩宽理财渠道，增加收益。然后，投资理财的周期长短相结合，
														合理安排，做到流动性好，防止关键时期有钱而不能使用。最后，很重要的是，
														理财不过是为是财富的增值或者保值，有钱的最终目的是让生活过得更加幸福美满，
														衣食无忧，财富在适当时期应该制定适当的方案用于消费。如果只为理财而理财，那就不没有了实际的意义。</p>
													</div>
                      </div>
                    </div>
                  </div>
                  <div class="am-panel am-panel-default">
                    <div class="am-panel-hd">
                      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-2'}">
                        常见问题
                      </h4>
                    </div>
                    <div id="do-not-say-2" class="am-panel-collapse am-collapse">
                      <div class="am-panel-bd">
                        <h5> 什么是固定收益类理财产品?：</h5>
                        <p>固定收益类理财产品，是指收益率和期限固定的产品。
                        	其特点是：收益固定、投资期限明确(一般为1年到2年)，
                        	通常都通过资产抵押、担保公司等来保证资金安全性，安全系数较高。</p>
						<h5>如何选择固定收益类理财产品?</h5>
						<p>固定收益类理财产品因其独特的优势，现今比较抢手，
						可以四步来选择固定收益类理财产品：第一步，选择信誉良好的理财机构发行的产品，
						相对来说这些机构风控措施应该不错。第二步，优选自己熟悉的投资领域的固定收益类品种，
						比如投资标的为房地产;最后，结合自身理财需求和自身风险承受能力来选择适合自己的固定收益类理财产品。</p>
 						<h5>保本型理财产品与固定收益产品有什么区别?</h5>
						<p>保本型理财产品，并不是说全保本，购买时除了关注产品的安全性、
						收益性，还要注意有些产品对本金的保证条件。比如有些产品只保证90%的本金;
						有些产品对本金的保证设有“保本期限”，比如在1年内本金能100%保证。倘若提前赎回，本金可能会受到损失。</p>
                      </div>
                    </div>
                  </div>
                  <div class="am-panel am-panel-default">
                    <div class="am-panel-hd">
                      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-3'}">
                        帮助中心
                      </h4>
                    </div>
                    <div id="do-not-say-3" class="am-panel-collapse am-collapse">
                      <div class="am-panel-bd">
                        <h5>官网操作对于浏览器有什么要求吗？</h5>
                     	<p>建议使用IE、360浏览器、Chrome浏览器等主流浏览器登录。</p>
                     	<h5>平台是正规的吗？</h5>
                     	<p>放心，平台是合法合规的，具体包括以下6点：<br>

1）资金流向保障

为最大程度的保障投资人资金安全，特与多家知名第三方支付平台合作，为您的资金保驾护航；<br>

2）不自保自融

所有的项目均有实际借款企业需求，引入第三方承保机构；<br>

3）利率市场化

不盲目追求高利率，平台还可持续发展道路；<br>

4）维护反洗钱法规

投资人、融资人均需通过实名认证、投资人身份证、银行卡信息必须一致，融资人重要信息充分披露，资金账户流水清晰可寻；<br>

5）充分信息披露

融资信息披露详尽，风险揭示充分，投资人在投资前就能对项目有详尽的了解，资金流转信息透明；<br>

6）获得相关权威认证与认可

平台获得权威认证和政府的认可。</p>
                     	<h5>忘记注册手机号怎么办？</h5>
                     	<p>您可以联系客服人员，提供身份证号为您进行查询。
                     	如未查询到，则表示该身份证号码未在平台上实名。
                     	请您用目前的手机号码进行注册，如提示已注册，请直接登录或点击忘记密码找回密码后登录。</p>
                      </div>

                    </div>
         <div class="am-panel am-panel-default">
                    <div class="am-panel-hd">
                      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-4'}">
                        操作指引
                      </h4>
                    </div>
                    <div id="do-not-say-4" class="am-panel-collapse am-collapse">
                      <div class="am-panel-bd">
                       如果您对盈+理财网站操作流程不太熟悉，
                        请参考为您制作的网站操作流程指引：
                        <button class="btn" onclick="window.location = '/Cornucopia/item/Register'">我来给您带路！</button>
                      
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
