<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/Cornucopia/BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/Cornucopia/BgAssets/js/jquery.js"></script>
</head>
<body>
    <div class="place" style="color: blue;font-size: 20px">
    <span>位置：</span>
    <ul class="placeul">
    <li >投资记录</li>
    </ul>
    </div> 
    <div class="tools">
  <ul class="toolbar1"> 
        <li class="click"><span><img src="../BgAssets/images/t01.png" /></span>
        <a href="/Cornucopia/finance/listFunds">
        <input type="button" id="butselect" value="返回"></a></li>    
     
  </ul>  
     
     <div class="xline"></div>
  </div>
 
    <table class="tablelist">
    <thead>
    <tr>
         <th>序号</th>
         <th>姓名</th>
         <th>联系电话</th>
         <th>地址</th>
         <th><center>状态</center></th>
         <th><center>签署拍照图</center></th>
         <th><center>查看文档</center></th>
         <th>预约时间</th>
         <th>操作</th>
      </tr>
    </thead>
      <c:forEach items="${seeList }" var="see" varStatus="stat">
    <tbody>
      <tr>
         <td>${stat.index+1 }</td>
         <td>${see.member.name }</td>
         <td>${see.phone }</td>
         <td>${see.addr }</td>
         <td id="status" name="status">
         <center>
         <c:if test="${see.status==0 }">签署拍照</c:if>
            <c:if test="${see.status==1 }"><font color="green">已签署</font></c:if>
               <c:if test="${see.status==2 }"><font color="red">审核中</font></c:if>
                  <c:if test="${see.status==3 }"><font color="red">签署失败</font></c:if>
            </center>
         </td>
         <td><center><a href="javascript:photo()">查看</a></center></td>
         <td>
         <center>
          <c:if test="${see.status==1 }">（签署成功）私募合同|风险揭示书</c:if>
           <c:if test="${see.status!=1 }">------</c:if>
           </center>
          </td>
         <td>${see.create_date }</td>
         <td>
         <a href="/Cornucopia/finance/toListTrue?id=${see.id }">
         <input id="button1" type="button" class="btn btn-primary" value="签署" >
         </a>
           <input id="button2" type="button" class="btn btn-primary" value="签署失败" onclick="funFalse(${see.id})">
          
        </td> 
      </tr>
      </c:forEach>
    </table>
    
    <script type="text/javascript">

	function photo(){
		alert("拍照图为空！");
	}
   function funFalse(id){
	   var se=confirm("确定要签署失败？");
	    if(se==true){
		window.location.href="/Cornucopia/finance/fpsListFalse/"+id;		
	    }
	}
    
 	   
</script>

</body>
</html>
