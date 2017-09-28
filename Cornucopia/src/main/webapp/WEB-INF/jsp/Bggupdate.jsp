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
<title>无标题文档</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<link href="../BgAssets/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<script type="text/javascript" src="../BgAssets/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../BgAssets/js/select-ui.min.js"></script>
<script type="text/javascript" src="../BgAssets/editor/kindeditor.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  <script type="text/javascript">
    KE.show({
        id : 'content6',
        cssPath : './index.css'
    });
  </script>
  <script type="text/javascript">
    KE.show({
        id : 'content5',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
<SCRIPT type="text/javascript">
<%String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间%>
 var cid=0;
 function cc(id) {  
	 cid=id;
     var setting = {  
        check: {  
            enable: true,  
            chkStyle: "checkbox",  
            chkboxType : { "Y" : "ps", "N" : "ps" }  
        },  
        //获取json数据  
        async : {    
            enable : true,   
            url : "Ztree", // Ajax 获取数据的 URL 地址    
            autoParam : [ "id", "name" ], //ajax提交的时候，传的是id值  
            otherParam: { "id":id}
        },    
        data:{ // 必须使用data    
            simpleData : {    
                enable : true,    
                idKey : "id", // id编号命名     
                pIdKey : "pId", // 父id编号命名      
                rootId : 0  
            }    
            },    
        // 回调函数    
        callback : {    
            onClick : function(event, treeId, treeNode, clickFlag) { 
            },    
            //捕获异步加载出现异常错误的事件回调函数 和 成功的回调函数    
            onAsyncSuccess : function(event, treeId, treeNode, msg){    
            },  
        }   
            
    };  
 $.fn.zTree.init($("#treeDemo"), setting); 
 } 
</SCRIPT>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">修改信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
  
  	<div id="tab1" class="tabson">  
  	<form action="/Cornucopia/BgSubject/update" method="post" >
    
    <div>
    <label>名称：<b>*</b></label>
    <input name="name" type="text" class="scinput"  style="width:518px;" value='${sub.name }'/>
    </div>
    <br>
    <div>
    <label>类型:</label>
    <div class="vocation">
    <select class="select1" name="type" value='${sub.type }'>
    <option value="0">固收类</option>
    <option value="1">P2P车贷</option>
    <option value="2">P2P房贷</option>
    </select>
    </div>
    </div>
   <br>
    <div>
    <label>合同编号：<b>*</b></label>
    <input name="serial_no" type="text" class="scinput"   style="width:518px;" value='${sub.serial_no }'/>
    </div>
<div>
    
    <label>借款用途：<b>*</b></label>
    <input name="purpose" type="text" class="scinput" style="width:518px;" value='${sub.purpose}'/> 
    </div>
   
    <label>起投金额：<b>*</b></label>
    <input name="floor_amount" type="text" class="scinput"  style="width:518px;" value='${sub.floor_amount }'/>
    
    
    <label>保障方式:<b>*</b></label>
    <div class="vocation">
    <select class="select1" name="safeGuard_way" value='${sub.safeGuard_way }'>
    
    <option value="1">企业担保</option>
    <option value="2">银行担保22</option>
    </select>
    </div>
    
    <label>年化收益：<b>*</b></label>
    <input name="year_rate" type="text" class="scinput"  style="width:518px;" value='${sub.year_rate }'/>
    
    <li>
    <label>是否可用:</label>
    <div class="vocation">
    <select class="select1" name="exper_status" value='${sub.exper_status }'>
    <option value="0">否</option>
    <option value="1">是</option>
    </select>
    </div>
    <li>
    <label>募集开始时间</label><input name="raise_start"   type="text" class="scinput"  style="width:518px;" value='${sub.raise_start }'/>
  </li>
  <li>
    <label>募集结束时间</label><input name="raise_end" type="text" class="scinput" style="width:518px; " value='${sub.raise_end }'/>
   
    </li>
    <li>
    <label>状态:<b>*</b></label>
    <div class="vocation">
    <select class="select1" name="status" value='${sub.status }'>
    <option value="0">未发布</option>
    <option value="1">募集中</option>
    <option value="2">已发布</option>
    </select>
    </div>
    </li>
    <li>
    <label>以购人数：<b>*</b></label><input name="bought" type="text" class="scinput"  style="width:518px;" value='${sub.bought }'/>
    </li>
 
    </li>
    
    <li>
    <div>
    <label>标开始时间：<b>*</b></label><input name="start_date" type="text" class="scinput"  style="width:518px;" value="${sub.start_date }"/>
     </div>
    </li>
   
    <li>
    <label>借款人姓名：<b>*</b></label><input name="borrowername" type="text" class="scinput"  style="width:518px;" value='${sub.borrowername}'/>
    </li>
    <li>
    <div>
    
    <li>
    <label>标结束时间：<b>*</b></label>
    <input name="end_date" type="text" class="scinput"  style="width:518px;" value="${sub.end_date }"/>
    </li>
    </div>
    </li>
    <li>
    <div >
    <label>总金额：<b>*</b></label><input name="amount" type="text" class="scinput" style="width:518px;" value="${sub.amount}"/>
    </div>
    </li>
    
    <li><label>基金经理头像：<b>*</b></label> 
                     <div>
					<img  src="/Cornucopia/Upload/2017-09-22-3.bmp"><input type="radio" name="product_manager_pic" value="/Cornucopia/Upload/2017-09-22-3.bmp">
					<img  src="/Cornucopia/Upload/1.bmp"><input type="radio" name="product_manager_pic" value="/Cornucopia/Upload/1.bmp">	
					<img  src="/Cornucopia/Upload/2.bmp"><input type="radio" name="product_manager_pic" value="/Cornucopia/Upload/2.bmp">		
					</div>
					</li>
    <input style="display: none;" name="update_date" value="<%=datetime%>">
    
    <br>
    <div class="xline">
    <span>产品速揽</span>
    </div>
    <li>
    <textarea id="content7" name="comment" style="width:700px;height:250px;visibility:hidden;"></textarea>
    </li>
    <div class="xline">
     <span>项目详情</span>
    </div>
    <li>
    <textarea id="content6" name="projectDetails" style="width:700px;height:250px;visibility:hidden;"></textarea>
    </li>
    
    <div class="xline">
     <span>安全保障</span>
    </div>
    <li>
    <textarea id="content5" name="safetyControl" style="width:700px;height:250px;visibility:hidden;"></textarea>
    </li>   
    <input type="hidden" name="wid" value="${sub.id }">
    <li><input type="submit" class="btn" value="修 改"/></li>
    
    </form>
    </div>     
	</div> 
	<div>
	
	
    
    </div>
</body>
</html>
