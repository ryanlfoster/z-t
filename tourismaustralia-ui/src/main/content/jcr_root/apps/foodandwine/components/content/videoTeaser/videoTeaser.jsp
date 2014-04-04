<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.videoteaser.VideoTeaser" %>

<c:set var="video" value="<%=new VideoTeaser(slingRequest) %>" />

<div class="faw-video-teaser-wrapper faw-video-teaser-with-bg-wrapper fullwidth-bg">
	
		<div class="responsive-image l-position-absolute" data-picture="" data-alt="${video.imageAltTag}">
			<div data-src="${video.imagePath}.adapt.1663.low.jpg" data-media="(min-width: 1px)"></div>
			<div data-src="${video.imagePath}.adapt.1663.medium.jpg" data-media="(min-width: 481px)"></div>
			<div data-src="${video.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 769px)"></div>
			<div data-src="${video.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			<noscript>
				<img src='${video.imagePath}.adapt.1663.high.jpg'>
			</noscript>
		</div>
		<!--[if (lt IE 9) & (!IEMobile)]>
            <img src='${video.imagePath}.adapt.1663.high.jpg' alt=''>
        <![endif]-->
	
	<div class="faw-video-teaser faw-video-teaser-with-bg">
		<h5 class="faw-video-teaser-label is-mobile">${video.textBeforePlayButton} ${video.textAfterPlayButton}</h5>
		<h5 class="faw-video-teaser-label is-desktop">${video.textBeforePlayButton}</h5>
		<a href="#" class="faw-video-teaser-icon btn-round-video icon-font-video-play" data-video-button="video-holder-${video.videoRandomId}"></a>
		<h5 class="faw-video-teaser-label is-desktop">${video.textAfterPlayButton}</h5>
	</div>
</div>

<!-- video container -->


<div id='video-holder-${video.videoRandomId}' class="video-container">
    <a class="video-close-btn icon-font-cross" href="#"></a>
    <div class="video-table" style="width:80%">
        <div class="video-table-cell">
            <div class="cq-dd-brightcovevideo"
					style="overflow-x: hidden; overflow-y: hidden; text-align: center; width: 100%; text-align: center;">
					<div id="${video.videoRandomId}"></div>
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
				        customBC.createVideo("100%", "100%", "${video.playerId}", "${video.playerKey}", "${video.videoPlayer}", "${video.videoRandomId}");
				    </script>
				</div>
        </div>
    </div>
</div>