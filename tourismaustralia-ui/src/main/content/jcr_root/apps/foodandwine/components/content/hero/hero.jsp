<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.hero.Hero" %>

<c:set var="hero" value="<%=new Hero(slingRequest) %>"/>
 
 <!-- test background for testing, whow the transparent menu respons -->
<div class='faw-hero-home faw-bg-full-container faw-hero-home make-black'>
    <div class="faw-hero-home-bg fullwidth-bg">
        <div class="responsive-image" data-picture="" data-alt="${hero.imageAltTag}" >
            <div data-src="${hero.imagePath}.adapt.1663.low.jpg" data-media="(min-width: 1px)"></div>
            <div data-src="${hero.imagePath}.adapt.1663.medium.jpg" data-media="(min-width: 481px)"></div>
            <div data-src="${hero.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 769px)"></div>
            <div data-src="${hero.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
            <noscript>
                <img src='${hero.imagePath}.adapt.1663.high.jpg' alt='${hero.imageAltTag}'>
            </noscript>
        </div>
        <!--[if (lt IE 9) & (!IEMobile)]>
            <img src='{hero.imagePath}.adapt.1663.high.jpg' alt='${hero.imageAltTag}'>
        <![endif]-->
    </div>
    <div class="faw-hero-home-container">
<div class="icon-logo-withlines-container">
    <hr class="icon-logo-withlines-hr">
    <span href="#" class="icon-logo-withlines-logo btn-restaurant-australia-logo icon-font-logo"></span>
    <hr class="icon-logo-withlines-hr">
</div>
        <h1>${hero.title}</h1>
        <hr class="faw-hero-home-hr">
<div class='calltoaction calltoactionvideo'>
    <div class="calltoaction-title-container is-mobile">
        <div class="calltoaction-type-sml1">${hero.smallText} ${hero.largeText}</div>
    </div>
    <div class="calltoaction-title-container is-desktop">
        <div class="calltoaction-type-sml1">${hero.smallText}</div>
         <div class="calltoaction-type-lrg">${hero.largeText}</div>
    </div>
    <div class="head-divider-inner">
        <hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small"></hr>
        <a href="#" class="faw-video-teaser-icon btn-round-video icon-font-video-play" data-video-button="home-video"></a>
        <hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small"></hr>
    </div>
</div>
    </div>
<div class="faw-video-teaser-wrapper l-position-normal">
    <div class="faw-register-teaser">
        <hr class="headerlockup-hr-mobile"/>
        <div class="headerlockup">
            <div class="headerlockup-type-sml1">${hero.aboveButtonText}</div>
            <hr class="headerlockup-hr"/>
        </div>
        <p>
            <a href="${hero.buttonLink}" class="btn-secondary btn-transparent btn-small">${hero.buttonText}</a>
        </p>
        <p class='faw-register-teaser-subline'>${hero.belowButtonText}</p>
    </div>
</div>
    <!-- video container -->
<div id='home-video' class="video-container">
    <a class="video-close-btn icon-font-cross" href="#"></a>
    <div class="video-table" style="width:80%;">
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