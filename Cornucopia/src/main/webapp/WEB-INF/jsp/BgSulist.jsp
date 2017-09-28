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
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<link href="../assets/resources/css/common.css" rel="stylesheet">
<link href="../assets/resources/css/jw.css" rel="stylesheet">
<link href="../assets/resources/css/iconfont.css" rel="stylesheet">
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
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
 
    <table class="tablelist" id="t_student">
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
    <script src="../assets/js/Pagging.js" charset="utf-8"></script>
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
