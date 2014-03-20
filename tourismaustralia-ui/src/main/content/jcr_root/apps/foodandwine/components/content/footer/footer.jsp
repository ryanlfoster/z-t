<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.footer.Footer" %>

<c:set var="footer" value="<%=new Footer(slingRequest) %>"/>

<div class="footer-container">
		<div class="footer">
			<div class="row">
				<div class="footer-restaurant-australia-elements">
					<c:if test="${not empty footer.imageTopLogoPath}">
						<a href="#" class="btn-restaurant-australia-logo icon-font-logo">
							<img class="type-spacing-30" src="${footer.imageTopLogoPath}" alt=""> 
						</a>	
					</c:if>
					<a class="footer-restaurant-australia-elements-link type-spacing-15">${footer.urlTitle}</a>
					<div
						class="footer-restaurant-australia-elements-biline-container type-spacing-60">
						<div class="footer-restaurant-australia-elements-biline">${footer.byline}</div>
						<hr>
					</div>
				</div>
			</div>
			<div class="row l-padding-lr-10">
				<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3 l-footer-align">
					<div class="footer-col">
						<p class="footer-heading">${footer.headingLeft}</p>
						<ul class="footer-text-list l-list-clean">
							<c:forEach items="${footer.linksLeft}" var="link">
								<li><a href="${link.pagePath}">${link.linkText}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3 l-footer-align">
					<div class="footer-col">
						<p class="footer-heading">${footer.headingMiddle}</p>
						<ul class="footer-text-list l-list-clean">
							<c:forEach items="${footer.linksMiddle}" var="link">
								<li><a href="${link.pagePath}">${link.linkText}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-3 col-lg-3 l-footer-align">
					<div class="footer-col">
						<p class="footer-heading">${footer.headingRight}</p>
						<ul class="footer-social-list type-spacing-15">
							<c:forEach items="${footer.linksRight}" var="link">
								<li><a href="${link.pagePath}" class="btn-share"><span>
								<c:if test="${not empty link.iconImage}">
									<img src="${link.iconImage}" alt="" />
								</c:if>${link.linkText}</span></a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div
					class="col-xs-12 col-sm-12 col-md-12 col-lg-3 l-footer-align l-footer-logo-align">
					<div class="footer-col footer-logo-fixed-height">
						<div class="footer-ta-logo-container">
							<c:if test="${not empty footer.imageBottomLogoPath}">
								<a href="#">
									<img class="type-spacing-15" src="${footer.imageBottomLogoPath}" alt="">
								</a>
							</c:if>
							<div class="footer-ta-logo-copyright">© Tourism Australia
								${footer.copyrightYear}</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</div>
