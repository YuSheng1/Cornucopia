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
<title>网站后台管理系统HTML模板--模板之家 www.cssmoban.com</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据表</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
	</div>
	<form action="/Cornucopia/BgItem/BgServicePlan" method="post">
	<h4>名称：</h4><input class="form-control" type="text" name="name" placeholder="名称" style="width: 100px;margin-left: 60px;margin-top: -35px;">
	<h4  style="width: 100px;margin-left: 180px;margin-top: -30px;">状态：</h4><select name="status" class="form-control"  style="width: 100px;margin-left: 240px;margin-top: -35px;">
<option class="form-control" value="-1">全部</option>
		<option class="form-control" value="1">投资中</option>
		<option  class="form-control" value="0">投资已结束</option>
		</select>
		<h4 style="width: 100px;margin-left: 350px;margin-top: -30px;" >类型：</h4><select name="type" class="form-control" style="width: 100px;margin-left: 400px;margin-top: -35px;">
<option class="form-control" value="-1">全部</option>
		<option class="form-control" value="0">固收类</option>
		<option class="form-control" value="1">P2P车贷</option>
		</select>
		<input type="submit" value="搜索"  class="btn btn-primary"  style="width: 100px;margin-left: 550px;margin-top: -35px;" >
	</form>
	<div class="rightinfo">
		<table class="tablelist" id="t_student">
			<thead>
				<tr>
					<th>编号<i class="sort"><img src="../BgAssets/images/px.gif" /></i></th>
					<th>合同编号</th>
					<th>标的类别</th>
					<th>标的名称</th>
					<th>标的金额</th>
					<th>已投人数</th>
					<th>标的期限</th>
					<th>年化收益</th>
					<th>标的状态</th>
					<th>可体验金购买</th>
					<th>付息列表</th>
				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${subject}" var="s" varStatus="stat">
					<tr>
						<td>${s.id }</td>
						<td>${s.serial_no}</td>
						<td><c:if test="${s.type==1}">P2P车贷</c:if><c:if test="${s.type==0}">固收类</c:if></td>
						<td>${s.name }</td>
						<td>${s.amount }</td>
						<td>${s.bought }</td>
						<td>${s.period }</td>
						<td>${s.year_rate }</td>
						<td><c:if test="${s.status==1}">投资中</c:if><c:if test="${s.status==0}">投资已结束</c:if></td>
						<c:if test="${s.exper_status==0}"><td  style="color: red;" >不可购买</td></c:if><c:if test="${s.exper_status==1}"><td  style="color: blue;" >可购买</td></c:if>
						<td>
						<a class="tablelink"  href="/Cornucopia/BgItem/BgServicePlanById?subjectId=${s.id }" > <img src="../BgAssets/images/t01.png" />付息列表</a>
						<c:if test="${s.exper_status==1}">
						<a class="tablelink"  href="/Cornucopia/BgItem/SubjectBbinPurchassRecordById?subjectId=${s.id }" > <img src="../BgAssets/images/t01.png" />体验金付息列表</a>
						</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<div class="pagin">
<div class="gridItem" style=" padding: 5px; width: 300px; float: left; text-align: left; height: 30px; line-height:30px; font-size: 15px;" > 
			        共有 <span id="spanTotalInfor" style="color: red;font-weight: bold;"></span> 条记录 ,    
			        当前第 <span id="spanPageNum" style="color: red;font-weight: bold;"></span> 页    , 
			        共 <span id="spanTotalPage" style="color: red;font-weight: bold;"></span> 页
		    </div>
    		<div class="gridItem" style="margin-left:45px;  padding: 5px; width: 400px; float: left; text-align: center; height: 30px; line-height:30px; vertical-align: middle; font-size: 15px;">   
	            <span id="spanFirst" >首页</span> 
	            <span id="spanPre">上一页</span>
	            <span id="spanInput" style="margin: 0px; padding: 0px 0px 4px 0px; height:100%; "> 
                	第<input id="Text1" type="text" class="TextBox" onkeyup="changepage()"   style="height:20px; text-align: center;width:50px" />页 
            	</span>
	            <span id="spanNext">下一页</span> 
	            <span  id="spanLast">尾页</span> 
        	</div>

		</div>
	</div>
	<script type="text/javascript">
            var theTable = document.getElementById("t_student");
            var txtValue = document.getElementById("Text1").value;
            function changepage() {
                var txtValue2 = document.getElementById("Text1").value;
                if (txtValue != txtValue2) {
                    if (txtValue2 > pageCount()) {

                    }
                    else if (txtValue2 <= 0) {

                    }
                    else if (txtValue2 == 1) {
                        first();
                    }
                    else if (txtValue2 == pageCount()) {
                        last();
                    }
                    else {
                        hideTable();
                        page = txtValue2;
                        pageNum2.value = page;

                        currentRow = pageSize * page;
                        maxRow = currentRow - pageSize;
                        if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;
                        for (var i = maxRow; i < currentRow; i++) {
                            theTable.rows[i].style.display = '';
                        }
                        if (maxRow == 0) { preText(); firstText(); }
                        showPage();
                        nextLink();
                        lastLink();
                        preLink();
                        firstLink();
                   }

                    txtValue = txtValue2;
                }
            }
            
    </script>
	<script src="../assets/js/Pagging.js"></script>
</body>
</html>
