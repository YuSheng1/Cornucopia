<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jquery.ztree.all-3.5.js"></script>
<script src="../BgAssets/js/bootstrapValidator.min.js"></script>
<link href="../assets/css/metroStyle.css" rel="stylesheet" />
<link href="../BgAssets/css/bootstrapValidator.min.css" rel="stylesheet" />
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
    
    <form action="/Cornucopia/BgItem/BgStade" method="post">
	交易号：<input type="text" name="trade_no" placeholder="交易号">
		手机号：11<input type="text" name="pay_channel_order_no" placeholder="手机号">
		交易类型：<select name="trade_type">
<option value="-1">全部</option>
		<option value="MOBILE_RECHARGE">MOBILE_RECHARGE</option>
						<option value="FINANCE">FINANCE</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		交易状态：<select name="trade_status">
<option value="-1">全部</option>
		<option value="2">订单已完成</option>
						<option value="0">订单未完成</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		订单时间：<input type="date" name="create_date" placeholder="订单时间">
		<input type="submit" value="搜索"  class="btn btn-primary">
	</form>
    <table class="tablelist"   id="t_student">
			<thead>
				<tr>
					<th>编号<i class="sort"><img src="../BgAssets/images/px.gif" /></i></th>
					<th>交易号</th>
					<th>交易人手机号</th>
					<th>交易类型</th>
					<th>交易名称</th>
					<th>交易金额</th>
					<th>交易状态</th>
					<th>交易时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="s" varStatus="stat">
					<tr>
						<td>${stat.index+1 }</td>
						<td>${s.trade_no}</td>
						<td>${s.member.mobile_Phone }</td>
						<td>${s.trade_type}</td>
						<td>${s.trade_name}</td>
						<td>${s.amount }</td>
						<c:if test="${s.trade_status==1}"><td style="color: blue;">订单已完成</td></c:if>
						<c:if test="${s.trade_status==2}"><td style="color: blue;">订单已完成</td></c:if>
						<c:if test="${s.trade_status==0}"><td  style="color: red;">订单未完成</td></c:if>
						<td>${s.create_date }</td>
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
