<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.bigtitle.BigTitle" %>
<c:set var="bigTitle" value="<% new BigTitle(slingRequet) %>"/> 
