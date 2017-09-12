<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../BgAssets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../BgAssets/js/jquery.js"></script>
</head>
<body>
    <div class="place" style="color: blue;font-size: 20px">
    <span>位置：</span>
    <ul class="placeul">
    <li >私募/股权类</li>
    </ul>
    </div>
    
   
   
    <div class="tools">
  
  <label style="font-size: 18px"> 名称：</label><input name="name" type="text" class="dfinput" />
   
  <label style="font-size: 18px"> 类型：</label><input name="name" type="text" class="dfinput" />
          
  <label style="font-size: 18px"> 状态：</label><input name="name" type="text" class="dfinput" />
  
  <ul class="toolbar1"> 
         <li><span><img src="../BgAssets/images/t04.png" /></span>
         <input type="button" id="butselect" value="查询"></li>
        <li class="click"><span><img src="../BgAssets/images/t01.png" /></span>
        <input type="button" id="butselect" value="新增"></li>    
     
  </ul>  
     
     <div class="xline"></div>
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
    <tbody> 
    <tr>
    <td class="imgtd"><img src="../BgAssets/images/img11.png" /></td>
    <td>后台界面<p>ID: 82122</p></td>
    <td>开放浏览</td>
    <td>admin</td>
    <td>已审核</td>
    <td>128</td>
     <td>128</td>
      <td>128</td>
       <td>128</td>
        <td>128</td>
         <td>128</td>
          <td>
          <input type="button" id="but" value="编辑查看">
          <input type="button" id="but1" value="未签署">
          </td>
    </tr>
    
   
  
    
    </tbody>
    
    </table>
    
    
</body>
</html>
