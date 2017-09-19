<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!-- //获取系统时间必须导入的 -->
<%@ page import="java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="../BgAssets/editor/kindeditor.js"></script>
<script type="text/javascript">
<%String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间%>

function update(title,tid,text,id){
	$("#title").val(title);
	$("#text").val(text);
	$("#error").val(tid);
	 /* $("#id").val(id); */
}
</script>
</head>
<body>
<form action="" method="post" target="rightFrame"></form>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="container" style="margin-top: 50px;">
        <div class="row">
        
            <div class="col-lg-4 col-lg-offset-4">
            
                <div class="panel panel-default">
                
                    <div class="panel-heading">
                        <h3 class="panel-title">修改标题信息</h3>
                            
                    </div>

                    <div class="panel-body">
                       	<form  id="formupdate" method="post"  action="/Cornucopia/BgNews/update">
                            <div class="form-group">
                                <label>标题:</label>
                                 <input type="text" class="form-control" placeholder="请输入标题名称"  name="title" id="title"  >
                            </div>
                            <div class="form-group">
                                <label>类&nbsp;别:</label>
                              <select id="error" name="error" class="form-control" >
                               <c:forEach items="${tlist}" var="list" >
          						<option class="form-control" id="oid" value="${list.tid}"  selected="selected"  >${list.name}</option>
          				</c:forEach>
       					 </select>
        			                    </div>
                            <!-- <input style="display: none;"name="id"   id="id"> -->
					<input style="display: none;"name="updTime" value="<%=datetime%>">
					<textarea id="text" name="text" style="width:700px;height:250px;visibility:hidden;"></textarea>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary" >立即修改</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
		<!-- /.modal -->
	</div>
</body>
</html>