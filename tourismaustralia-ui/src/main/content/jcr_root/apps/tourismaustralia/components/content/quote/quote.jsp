<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.quote.Quote"%>

<c:set var="quote" value="<%=new Quote(slingRequest) %>" />

<!-- quote start -->
<div class="quote">
	<div class="row l-center-1200">
		<div class="quote-social-image">
			<div class="image-social-image">
				<img src="${quote.imageSrc}" alt="" />
			</div>
		</div>
		<div class="quote-content">
			<hr class="quote-hr" />
			<p class="quote-text">
			    <c:if test="${not empty quote.quoteText}">
					&#8220;${quote.quoteText}&#8221;
				</c:if>	
			</p>
			<div class="quote-byline">${quote.byline}</div>
			<hr class="quote-hr" />
		</div>
	</div>
</div>
<!-- quote end -->