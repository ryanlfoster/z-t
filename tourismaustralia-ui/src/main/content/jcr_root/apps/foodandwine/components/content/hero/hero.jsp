<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.hero.Hero"%>

<c:set var="hero" value="<%=new Hero(slingRequest) %>" />


<!-- test background for testing, whow the transparent menu respons -->
<div class='faw-hero-home make-black'>
	<div class="faw-hero-home-bg fullwidth-bg">
		<div class="responsive-image" data-picture="" data-alt="">
			<div data-src="${hero.imagePath}.adapt.1663.low.jpg" data-media="(min-width: 1px)"></div>
			<div data-src="${hero.imagePath}.adapt.1663.medium.jpg" data-media="(min-width: 481px)"></div>
			<div data-src="${hero.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 769px)"></div>
			<div data-src="${hero.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			<noscript>
				<img src='${hero.imagePath}.adapt.1663.high.jpg'>
			</noscript>
		</div>
		<!--[if (lt IE 9) & (!IEMobile)]>
            <img src='{hero.imagePath}.adapt.1663.high.jpg' alt=''>
        <![endif]-->
		</div>
	<div class="faw-hero-home-container">
		<div class="icon-logo-withlines-container">
			<hr class="icon-logo-withlines-hr">
			<span href="#"
				class="icon-logo-withlines-logo btn-restaurant-australia-logo icon-font-logo"></span>
			<hr class="icon-logo-withlines-hr">
		</div>
		<h1>${hero.bigTitle}</h1>
		<hr class="faw-hero-home-hr">
		<div class='calltoaction'>
			<div class="calltoaction-title-container is-mobile">
				<div class="calltoaction-type-sml1">${hero.smallFontText} ${hero.largeFontText} ${hero.smallFont}</div>
			</div>
			<div class="calltoaction-title-container is-desktop">
				<div class="calltoaction-type-sml1">${hero.smallFontText }</div>
				<div class="calltoaction-type-lrg">${hero.largeFontText}</div>
				<div class="calltoaction-type-sml1">${hero.smallFont}</div>
				<hr class="calltoaction-hr">
			</div>
			<a href="${hero.buttonLink}" class="btn-secondary btn-register">${hero.buttonText}</a>
			<p>${hero.byLineText}</p>
			<div class="is-mobile">
				<hr class="calltoaction-hr">
			</div>
		</div>
	</div>
	<div class="faw-video-teaser-wrapper l-position-normal">
		<div class="faw-video-teaser">
			<h5 class="faw-video-teaser-label is-mobile">${hero.textBeforePlayButton} ${hero.textAfterPlayButton}</h5>
			<h5 class="faw-video-teaser-label is-desktop">${hero.textBeforePlayButton}</h5>
			<a href="#"
				class="faw-video-teaser-icon btn-round-video icon-font-video-play"
				data-video-button="home-video"></a>
			<h5 class="faw-video-teaser-label is-desktop">${hero.textAfterPlayButton}</h5>
		</div>
	</div>
	<!-- video container -->
	<div id='home-video' class="video-container">
		<a class="video-close-btn icon-font-cross" href="#"></a>
		<div class="video-table" style="width:80%">
			<div class="video-table-cell">
				<div class="cq-dd-brightcovevideo"
					style="overflow-x: hidden; overflow-y: hidden; text-align: center; width: 100%; text-align: center;">
					<div id="${hero.videoRandomId}"></div>
					<script type="text/javascript">
		        	// listener for media change events
			        	function onMediaBegin(event) {
			            	var BCLcurrentVideoID;
				            var BCLcurrentVideoNAME;
				            BCLcurrentVideoID = BCLvideoPlayer.getCurrentVideo().id;
				            BCLcurrentVideoNAME = BCLvideoPlayer.getCurrentVideo().displayName;
				            switch (event.type) {
				                case "mediaBegin":
				                    var currentVideoLength = "0";
				                    currentVideoLength = BCLvideoPlayer.getCurrentVideo().length;
				                    if (currentVideoLength != "0") currentVideoLength = currentVideoLength / 1000;
				                    if (typeof _gaq != "undefined") _gaq.push(['_trackEvent', location.pathname, event.type + " - " + currentVideoLength, BCLcurrentVideoNAME + " - " + BCLcurrentVideoID]);
				                    break;
				                case "mediaPlay":
				                    _gaq.push(['_trackEvent', location.pathname, event.type + " - " + event.position, BCLcurrentVideoNAME + " - " + BCLcurrentVideoID]);
				                    break;
				                case "mediaStop":
				                    _gaq.push(['_trackEvent', location.pathname, event.type + " - " + event.position, BCLcurrentVideoNAME + " - " + BCLcurrentVideoID]);
				                    break;
				                case "mediaChange":
				                    _gaq.push(['_trackEvent', location.pathname, event.type + " - " + event.position, BCLcurrentVideoNAME + " - " + BCLcurrentVideoID]);
				                    break;
				                case "mediaComplete":
				                    _gaq.push(['_trackEvent', location.pathname, event.type + " - " + event.position, BCLcurrentVideoNAME + " - " + BCLcurrentVideoID]);
				                    break;
				                default:
				                    _gaq.push(['_trackEvent', location.pathname, event.type, BCLcurrentVideoNAME + " - " + BCLcurrentVideoID]);
			            	}
			        	}
		
		    		</script>
					<script>
				        customBC.createVideo("100%", "100%", "${hero.playerId}", "${hero.playerKey}", "${hero.videoPlayer}", "${hero.videoRandomId}");
				    </script>
				</div>

			</div>
		</div>
	</div>
</div>
