<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.articleImage.ArticleImage"%>

<c:set var="articleImage" value="<%=new ArticleImage(slingRequest) %>" />

<div class='imagewithdescription'>
	<a href="${articleImage.articleImageLinkPage}" target="${articleImageLinkPage.external ? '_blank' : '_self' }" class="imagewithdescription-inner">
		<div class="responsive-image" data-picture="" data-alt="" >
			<div data-src="${articleImage.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			<div data-src="${articleImage.imagePath}.adapt.720.medium.jpg" data-media="(min-width: 481px)"></div>
			<div data-src="${articleImage.imagePath}.adapt.683.high.jpg" data-media="(min-width: 769px)"></div>
			<div data-src="${articleImage.imagePath}.adapt.683.high.jpg" data-media="(min-width: 993px)"></div>
			<noscript>
				<img src='${hero.imagePath}.adapt.1663.high.jpg'>
			</noscript>
			
			<noscript>
				<img src='${articleImage.imagePath}.adapt.1663.high.jpg' alt=''>
			</noscript>
		</div>
		<!--[if (lt IE 9) & (!IEMobile)]>
            <img src='${articleImage.imagePath}.adapt.1663.high.jpg' alt=''>
        <![endif]-->
		
		<div class="imagewithdescription-description">
			<p class="imagewithdescription-description-head"><strong><em>${articleImage.captionBold}</em></strong></p>
			<p class="imagewithdescription-description-copy"><em>${articleImage.imageCaption}</em></p>
		</div>
	</a>
</div>