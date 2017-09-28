<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<link href="../BgAssets/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<script type="text/javascript" src="../BgAssets/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../BgAssets/js/select-ui.min.js"></script>
<script type="text/javascript" src="../BgAssets/editor/kindeditor.js"></script>
<script type="text/javascript">
	function clean() {
		$("#name").val(null);
		$("#type").val("");
		$("#status").val("");
	}
</script>
</head>
<body>
    <div class="place" style="color: blue;font-size: 20px">
    <span>位置：</span>
    <ul class="placeul">
    <li >私募/股权类</li>
    </ul>
    </div>
   
   <div class="tools">
		<form action="/Cornucopia/finance/listll" method="post" role="form">
			<label>名称</label><input name="name" type="text"
				class="scinput" /> 
				<label>类型<b>*</b></label>
					
						<select class="select2" name="type" id="type">
						<option  value="">全部</option>
				         <option value="1">私募类</option>
				         <option value="2">股权类</option>
						</select>
					    <label>状态<b>*</b></label>
						<select class="select2" name="status" id="status">
						 <option value="">全部</option>
				         <option value="0" >未发布</option>
				         <option value="1" >募集中</option>
				         <option value="2" >已结束</option>
						</select>
						
						
				<input type="submit" class="btn btn-primary" value="查询">

				<button type="reset" class="btn btn-primary" onclick="clean();">
				
				<span><img src="../BgAssets/images/t02.png" /></span>重置
				</button>
				<a href="/Cornucopia/finance/tosave">
				<button type="button" class="btn btn-primary" >
					<span><img src="../BgAssets/images/t01.png" /></span>新增
				</button>
				</a>
		</form>

	</div>

    <table class="imgtable">
    <thead>
    <tr>
    <th>序号</th>
    <th>名称</th>
    <th>类型</th>
    <th>状态</th>
    <th>年化收益</th>
    <th>返佣比例</th>
    <th>开始日期</th>
    <th>结束日期</th>
    <th>投资期限</th>
    <th>起投金额</th>
    <th>添加时间</th>
    <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${list }" var="f" varStatus="stat">
   <tbody>
      <tr>
         <td>${stat.index+1 }</td>
         <td>${f.name }</td>
         <td> 
          <c:if test="${f.type=='1' }">私募类</c:if>
          <c:if test="${f.type=='2' }">股权类</c:if> 
          <c:if test="${f.type!='1' }">
          <c:if test="${f.type!='2' }">${f.type }</c:if>
          </c:if> 
         </td>
         <td>
         <c:if test="${f.status==0 }">未发布</c:if>
           <c:if test="${f.status==1 }">募集中</c:if>
             <c:if test="${f.status==2 }">已结束</c:if>
         </td>
         <td>${f.year_rate }</td>
         <td>${f.ratio }</td>
         <td>${f.start_date }</td>
         <td>${f.start_date }</td>
         <td>${f.period }</td>
         <td>${f.floor_amount }</td>
         <td>${f.create_date}</td>       
         <td>
            <a href="/Cornucopia/finance/fpsList?id=${f.id }">
             <input type="button" class="btn btn-primary" value="签署情况" >
             </a>
          <a href="/Cornucopia/finance/toUpdate?id=${f.id }">
             <input type="button" class="btn btn-primary" value="编辑修改" >
             </a>
        </td> 
      </tr>
   </tbody>
   </c:forEach>
   </table>
    
    <script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
</body>
</html>
