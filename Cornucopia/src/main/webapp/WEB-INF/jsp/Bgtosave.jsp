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
    <li><a href="#">添加</a></li>
    </ul>
    </div>
    
    <div class="formbody">
  
  	<div id="tab1" class="tabson">  
  	<form action="/Cornucopia/BgOver/save" method="post" >
    <ul class="forminfo">
    <li><label>名称：<b>*</b></label><input name="title" type="text" class="dfinput"  style="width:518px;"/></li>
   
    <li><label>子标题：<b>*</b></label><input name="child_title" type="text" class="dfinput"   style="width:518px;"/></li>
   
    
    <li><label>描述：<b>*</b></label><input name="description" type="text" class="dfinput"  style="width:518px;"/></li>
    
    <li><label>用户群体：<b>*</b></label><input name="user_type" type="text" class="dfinput"  style="width:518px;"/></li>
    
    <li><label>排序值：<b>*</b></label><input name="sortColum" type="text" class="dfinput"  style="width:518px;"/></li>
     <li><label>状态:<b>*</b></label>
    <div class="vocation">
    <select class="select1" name="status">
    <option value="0">未发布</option>
    <option value="1">募集中</option>
    <option value="2">已发布</option>
 
    </select>
    </div>
    <li><label>开始时间：<b>*</b></label><input name="start_time" type="date" class="dfinput"   style="width:518px;"/></li>
    
    <li><label>结束时间：<b>*</b></label><input name="end_time" type="date" class="dfinput"   style="width:518px;"/></li>
    
    <li><label>图标<b>*</b></label><input name="oversea_icon" type="file"    style="width:518px;"/></li>
    
    <input style="display: none;" name="addTime" value="<%=datetime%>">
    

    <li><label>通知内容<b>*</b></label>
    <textarea id="content7" name="content" style="width:700px;height:250px;visibility:hidden;"></textarea>
    </li>
    <li><input  type="submit" class="btn" value="添    加"/></li>
    </ul>
    </form>
    </div>     
	</div> 
</body>
</html>
