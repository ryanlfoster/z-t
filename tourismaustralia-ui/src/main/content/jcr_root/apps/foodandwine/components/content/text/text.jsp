<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.text.Text" %>

<c:set var="text" value="<%=new Text(slingRequest) %>"/>
<p>${text.textContent}<p>




