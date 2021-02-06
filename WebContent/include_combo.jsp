<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.stone.teleFee.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>套餐信息</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/index.css" type="text/css" rel="stylesheet" />
</head>
<body class="tn-page-bg">
<div id="tn-content" >
     <!-- 套餐信息展示 -->
     <c:forEach items="${pagination.pageData}" var="combo">
      <div class="tn-grid">
        <div class="tn-box tn-widget tn-widget-content tn-corner-all it-home-box">
          <div class="tn-box-content tn-widget-content tn-corner-all">
          	<!-- 套餐图片展示 -->
            <div class="it-company-keyimg tn-border-bottom tn-border-gray"> 
            <a href="ComboServlet?type=select&id=${combo.id}"> 
            <img src="images/${combo.img}" width="990"> </a> </div>
            <!-- 套餐展示 -->
            <div class="it-home-present">
             <div class="it-present-btn"> 
             <a class=" tn-button tn-button-home-apply" href="ComboServlet?type=select&id=${combo.id}"> 
             <span class="tn-button-text">更换套餐</span> </a> </div>
              <div class="it-present-text" style="padding-left:185px;">
                <div class="it-line01 it-text-bom">
                  <p class="it-text-tit">套餐编号</p>
                  <p class="it-line01 it-text-explain"> <span class="tn-icon it-home-arrow"></span> 
                  
                  
                  <b>${combo.id}</b> </p>
                </div>
                <div class="it-line01 it-text-top">
                  <p class="it-text-tit">套餐名称</p>
                  <p class="it-line01 it-text-explain"> <span class="tn-icon it-home-arrow"></span> 
                  <b>${combo.name}</b> </p>
                </div>
              </div>
              <div class="it-present-text">
                <div class="it-line01 it-text-bom">
                  <p class="it-text-tit">套餐价格</p>
                  <p class="it-line01 it-text-explain"> <span class="tn-icon it-home-arrow"></span> 
                   <b>${combo.price}</b> </p>
                </div>
                <div class="it-line01 it-text-top">
                  <p class="it-text-tit">套餐信息</p>
                  <p class="it-line01 it-text-explain"> <span class="tn-icon it-home-arrow"></span> 
                  <b>${combo.description}</b> </p>
                </div>
              </div>
            </div>
            </div>
          </div>
        </div>
      </c:forEach>
    <!-- 信息分页 -->
   <div class="page01">
	   <div class="page02">&nbsp;</div>
	   <div class="page03"><a href="index.jsp?type=pageList&pageNo=1">首页 </a></div>
	   <c:if test="${pagination.hasPreviousPage}">
	   <div class="page03">
	   <a href='index.jsp?type=pageList&pageNo=${pagination.pageNo-1}'>上一页 </a></div></c:if>
	   <c:if test="${pagination.hasNextPage}">
	   <div class="page03"><a href="index.jsp?type=pageList&pageNo=${pagination.pageNo+1}">下一页 </a></div></c:if>
	   <div class="page03"><a href="index.jsp?type=pageList&pageNo=${pagination.totalPages}">尾页</a></div>
	   <div class="page03">当前是第${pagination.pageNo}页，共${pagination.totalPages}页</div>
   </div>
  </div>
</body>
</html>