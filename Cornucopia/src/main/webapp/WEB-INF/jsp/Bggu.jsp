<%@ page language="java" contentType="text/html; charset=UTF-8"
	  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<script type="text/javascript" src="../BgAssets/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../BgAssets/js/select-ui.min.js"></script>
<script type="text/javascript" src="../BgAssets/editor/kindeditor.js"></script>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
</head>
<script type="text/javascript">
	function clean() {
		$("#name").val(null);
		$("#type").val("");
		$("#status").val("");
	}
</script>
<body style="background:#f0f9fd;">
	<div class="place" style="color: blue; font-size: 20px">
		<span>位置：</span>
		<ul class="placeul">
			<li>固收类/P2P</li>
		</ul>
	</div>
	<div class="tools">
		<form action="/Cornucopia/BgSubject/list2" method="post" role="form">
			<label>名称</label><input name="name" type="text" class="scinput" /> 
				<label>类型<b>*</b></label>
						<select class="select2" name="type" id="type">
							<option value="">全部</option>
							<option value="0">固收类</option>
							<option value="1">P2P车贷</option>
							<option value="2">P2P房贷</option>
						</select>
					     <label>状态<b>*</b></label> 
						<select class="select2" name="status" id="status">
							<option value="">全部</option>
							<option value="0">募集中</option>
							<option value="1">未发布</option>
							<option value="2">回款中</option>
							<option value="3">还款完成</option>
						</select>
						
						
		 	 <input type="submit" class="btn btn-primary" value="查询">

			 <button type="reset" class="btn btn-primary" onclick="clean();">
			 
			 <span><img src="../BgAssets/images/t02.png"/></span>重置,
				</button>
				<a href="/Cornucopia/BgSubject/togusave">
				<button type="button" class="btn btn-primary" >
					<span><img src="../BgAssets/images/t01.png" /></span>新增
				</button>
				</a>
		    </form>

	  </div>
 
	<table class="tablelist">
		<thead>
			<tr>
				<th>序号</th>
				<th>合同编号</th>
				<th>类型</th>
				<th>名称</th>
				<th>标的总金额</th>
				<th>已投总金额</th>
				<th>投资期限</th>
				<th>投资金额</th>
				<th>年化收益</th>
				<th>状态</th>
				<th>可使用体检金</th>
				<th>添加时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${lists }" var="list" varStatus="c">
			<tbody>
				<tr>
					<td>${c.index+1 }</td>
					<td>${list.serial_no }</td>
					<td><c:if test="${list.type==0 }">固收类</c:if> <c:if
							test="${list.type==1 }">P2P车贷</c:if> <c:if
							test="${list.type==2 }">P2P房贷</c:if></td>
					<td>${list.name }</td>
					<td>${list.amount }</td>
					<td>${list.amount }</td>
					<td>${list.period }</td>
					<td>${list.floor_amount }</td>
					<td>${list.year_rate }%</td>
					<td><c:if test="${list.status==0 }">未发布</c:if> <c:if
							test="${list.status==1 }">募集中</c:if> <c:if
							test="${list.status==2 }">已发布</c:if></td>
					<td><c:if test="${list.exper_status==0 }">否</c:if> <c:if
							test="${list.exper_status==1 }">是</c:if></td>
					<td>${list.create_date }</td>
					<td>
					<a href="/Cornucopia/BgSubject/toupdate?id=${list.id}">
					<input type="button" id="but" value="编辑"></a>
					 <a href="/Cornucopia/BgSubject/listAllmen?id=${list.id}">
					 <input type="button" id="but1" value="查看投资">
					 </a>
					 </td>
				</tr>
			</tbody>
		</c:forEach>
	</table>



</body>
</html>
