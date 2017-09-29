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
<link href="../assets/css/bootstrap.css" rel="stylesheet">
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
	var cid = 0;
	function cc(id) {
		cid = id;
		var setting = {
			check : {
				enable : true,
				chkStyle : "checkbox",
				chkboxType : {
					"Y" : "ps",
					"N" : "ps"
				}
			},
			//获取json数据  
			async : {
				enable : true,
				url : "Ztree", // Ajax 获取数据的 URL 地址    
				autoParam : [ "id", "name" ], //ajax提交的时候，传的是id值  
				otherParam : {
					"id" : id
				}
			},
			data : { // 必须使用data    
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
				onAsyncSuccess : function(event, treeId, treeNode, msg) {
				},
			}

		};
		$.fn.zTree.init($("#treeDemo"), setting);
	}
</SCRIPT>
<script type="text/javascript">  
$(function(){  
    var flag = 0;  
    $("#txt1").blur(function(){  
        if(flag!=0 && flag!=1 ) return;  
        if($.trim($("#txt1").val())==""){  
            flag = 1;  
            $("#msg1").html("名字不能为空！");  
            $("#txt1").focus();  
            return;  
        }else{  
            flag = 0;  
        }  
    });  
    
    $("#txt2").blur(function(){  
        if(flag!=0 && flag!=2 ) return;  
        if($.trim($("#txt2").val())==""){  
            flag = 2;  
            $("#msg2").html("2中不能为空！");  
            $("#txt2").focus();  
            return;  
        }
          else {  
            flag = 0;  
        }  
    });   
    $("#txt3").blur(function(){  
        if(flag!=0 && flag!=3 ) return;  
        if($.trim($("#txt3").val())==""){  
            flag = 3;  
            $("#msg3").html("3中不能为空！");  
            $("#txt3").focus();  
            return;  
        }else{  
            flag = 0;  
        }  
    });   
    
  
    //优化后代码：  
    $(".e").each(function(index, element) {  
        $(this).change(function(){  
            $(".f").html("");  
        });  
    });  
});  
function upperCase()
{
var phone = document.getElementById('phone').value;
if(!(/^1[34578]\d{9}$/.test(phone))){ 
	  $("#msg6").html("请输入数字！");
    return false; 
} 
}
</script>  
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
			<form action="/Cornucopia/BgSubject/save" method="post">
				<ul class="forminfo">
					<li><label>名称：<b>*</b></label> <input name="name" type="text" id="txt1"
						class="form-control" style="width: 518px;" />
						<span id="msg1" class="f" style="color: red" class="e"></span></li>
					<li>
						<div class="vocation">
						<label>类型:<b>*</b></label>
							<select class="select1" name="type">
								<option value="0">固收类</option>
								<option value="1">P2P车贷</option>
								<option value="2">P2P房贷</option>
							</select>
						</div></li>
						<br><br><br><br>
					<li><label>合同编号：<b>*</b></label> <input name="serial_no"
						type="text" class="form-control" style="width: 518px;" required="required"/></li>
					<br>
					<li><label>借款用途：<b>*</b></label> <input name="purpose"
						type="text" class="form-control" style="width: 518px;" / required="required"></li>
					<li><label>起投金额：<b>*</b></label> <input name="floor_amount"
						type="text" class="form-control" style="width: 518px;" id="phone"
						onblur="upperCase()"/>
						<span id="msg6" class="f" style="color: red" class="e"></span>
						</li>
						</li>
					<li>
						<div class="vocation">
						<label>保障方式:<b>*</b></label>
							<select class="select1" name="safeGuard_way">
								<option value="1">企业担保</option>
								<option value="2">银行担保22</option>
							</select>
						</div></li>
						
						<br><br><br><br><br>
					<li><label>年化收益：<b>*</b></label> <input name="year_rate"
						type="text" class="form-control" style="width: 518px;" id="phone"
						onblur="upperCase()"
				         />
						<span id="msg6" class="f" style="color: red" class="e"></span>
						</li>
					<li>
						<div class="vocation">
						<label>是否可用:</label>
							<select class="select1" name="exper_status">
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</div>
						</li>
						<br><br><br><br>	
					<li><label>募集开始时间</label><input name="raise_start1"
						type="date" class="form-control" style="width: 518px;" required="required"/></li>
					<li><label>募集结束时间</label><input name="end_start1" type="date"
						class="form-control" style="width: 518px;" required="required"/></li>
					<li>
						<div class="vocation">
						<label>状态:<b>*</b></label>
							<select class="select1" name="status">
								<option value="0">未发布</option>
								<option value="1">募集中</option>
								<option value="2">已发布</option>
							</select>
						</div></li>
						<br><br><br><br>
						
						<br>
					<li><label>以购人数：<b>*</b></label><input name="bought"
						type="text" class="form-control" style="width: 518px;" onblur="upperCase()" id="phone"  />
						<span id="msg6" class="f" style="color: red" class="e" required="required"></span>
						</li>

					</li>

					<li>
						<div>
							<label>标开始时间：<b>*</b></label><input name="start_date1"
								type="date" class="form-control" style="width: 518px;"required="required" />
						</div>
					</li>

					<li><label>借款人姓名：<b>*</b></label><input name="borrowername"
						type="text" class="form-control" style="width: 518px;" id="txt1"/>
						<span id="msg1" class="f" style="color: red" class="e" required="required"></span>
						</li>
					<li>
						<div>

							<li><label>标结束时间：<b>*</b></label> <input name="end_date1"
								type="date" class="form-control" style="width: 518px;" required="required" /></li>
						</div>
					</li>
					<li>
						<div>
							<label> 总金额：<b>*</b></label><input name="borrowername"
								type="text" class="form-control" style="width: 518px;"onblur="upperCase()" id="phone" 
								required="required"
								 />
								 <span id="msg6" class="f" style="color: red" class="e"></span>
						</div>
					</li>
					<input style="display: none;" name="create_date"
						value="<%=datetime%>">
					<br>
					<div class="xline">
						<span>产品速揽</span>
					</div>
					<li><textarea id="content7" name="comment"
							style="width: 700px; height: 250px; visibility: hidden;"></textarea>
					</li>
					<div class="xline">
						<span>项目详情</span>
					</div>
					<li><textarea id="content6" name="projectDetails"
							style="width: 700px; height: 250px; visibility: hidden;"></textarea>
					</li>

					<div class="xline">
						<span>安全保障</span>
					</div>
					<li><textarea id="content5" name="safetyControl"
							style="width: 700px; height: 250px; visibility: hidden;"></textarea>
					</li>
					<div class="xline">
						<span>特定属性</span>
					</div>

					<li><label>责权编号：<b>*</b></label> <input name="child_title"
						type="text" class="form-control" style="width: 518px;" required="required" /></li>


					<li><label>企业认证：<b>*</b></label> <input name="child_title"
						type="text" class="form-control" style="width: 518px;" required="required" /></li>


					<li><label>责权人：<b>*</b></label> <input name="child_title"
						type="text" class="form-control" style="width: 518px;"required="required" /></li>

					<li><label>保障平台：<b>*</b></label> <input name="child_title"
						type="text" class="form-control" style="width: 518px;"required="required" /></li>
				    <li><label>图标：<b>*</b></label> 
                     <div>
					<img  src="/Cornucopia/BgAssets/images/img06.png"><input type="radio" name="oversea_icon" value="/Cornucopia/BgAssets/images/img06.png">
					<img  src="/Cornucopia/BgAssets/images/img07.png"><input type="radio" name="oversea_icon" value="/Cornucopia/BgAssets/images/img07.png">	
					<img  src="/Cornucopia/BgAssets/images/img09.png"><input type="radio" name="oversea_icon" value="/Cornucopia/BgAssets/images/img09.png">		
					</div>
					</li>

					<li><input type="submit" class="btn btn-primary" value="添    加" /></li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>
