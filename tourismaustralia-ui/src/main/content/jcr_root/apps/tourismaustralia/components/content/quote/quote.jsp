<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.quote.Quote"%>

<c:set var="quote" value="<%=new Quote(slingRequest) %>" />

<!-- quote start -->
<div class="quote">
	<div class="row l-center-1200">
		<div class="quote-social-image">
			<div class="image-social-image">
				<img src="/etc/designs/tourismaustralia/clientlibs/imgs/placeholders/image_social_image.jpg" alt="" />
			</div>
		</div>
		<div class="quote-content">
			<hr class="quote-hr" />
			<p class="quote-text">&#8220;${quote.quoteText}&#8221;</p>
			<div class="quote-byline">${quote.byline} ${quote.quoteDate}</div>
			<hr class="quote-hr" />
		</div>
	</div>
</div>
<!-- quote end -->