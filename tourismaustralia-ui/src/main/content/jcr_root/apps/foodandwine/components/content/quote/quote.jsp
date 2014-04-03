<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.quote.Quote" %>

<c:set var="quote" value="<%=new Quote(slingRequest) %>"/>

<div class="l-center" style="max-width:683px;display:inline-block">
	<h3 class="faw-article-quotes">&#8220;${quote.quoteText}&#8221;</h3>
	<p class="faw-article-copyright"><em>${quote.byline} ${quote.quoteDate}</em></p>
</div>
