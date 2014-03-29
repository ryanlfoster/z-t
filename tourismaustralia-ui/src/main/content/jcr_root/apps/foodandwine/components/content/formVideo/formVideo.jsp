<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.formvideo.FormVideo" %>

<c:set var="video" value="<%=new FormVideo(slingRequest) %>" />
		        
<div class="hint-icon-wrapper">
	<div class="hint-icon">
		<hr>
		<h5 class="hint-icon-label hint-icon-label-left">${video.textBeforePlayButton}</h5>
		<a href="#" class="btn-white-black hint-icon-icon icon-font-listing is-active form-video-button" data-video-button="video-holder-${video.videoRandomId}"></a>
		<h5 class="hint-icon-label hint-icon-label-right">${video.textAfterPlayButton}</h5>
		<div class="cleardiv"></div>
		<hr>
	</div>
</div>

<!-- video container -->


<div id='video-holder-${video.videoRandomId}' class="video-container">
    <a class="video-close-btn icon-font-cross" href="#"></a>
    <div class="video-table">
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
</div>