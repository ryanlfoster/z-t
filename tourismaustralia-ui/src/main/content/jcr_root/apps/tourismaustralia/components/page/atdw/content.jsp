<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.page.atdw.AtdwPage" %>

<c:set var="atdw" value="<%=new AtdwPage(slingRequest) %>"/>

<h1>${atdw.atdwProduct.title}</h1>
<c:if test="${not empty atdw.atdwProduct.category }">
	<div>${atdw.atdwProduct.category}</div>
</c:if>
<c:if test="${not empty atdw.atdwProduct.website }">
	<div>${atdw.atdwProduct.website}</div>
</c:if>
<c:if test="${not empty atdw.atdwProduct.city }">
	<div>${atdw.atdwProduct.city}</div>
</c:if>
<c:if test="${not empty atdw.atdwProduct.region }">
	<div>${atdw.atdwProduct.region}</div>
</c:if>
<c:if test="${not empty atdw.atdwProduct.state }">
	<div>${atdw.atdwProduct.state}</div>
</c:if>
<c:if test="${not empty atdw.atdwProduct.image }">
	<div><img src='${atdw.atdwProduct.image}'/></div>
</c:if>
<c:if test="${atdw.atdwProduct.tqual }">
	<div><img src='/etc/designs/tourismaustralia/imgs/TQUAL_RGB_Pos.jpg'/></div>
</c:if>

<cq:include path="mainparsys" resourceType="foundation/components/parsys" />