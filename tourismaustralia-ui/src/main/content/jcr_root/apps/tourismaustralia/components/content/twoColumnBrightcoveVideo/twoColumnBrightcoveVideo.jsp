<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.brightcove.Brightcove" %>
<%@ page import="com.australia.www.components.content.twoColumnBrighcoveVideo.TwoColumnBrightcoveVideo" %>

<c:set var="twoColumnBrightcoveVideo" value="<%=new TwoColumnBrightcoveVideo(slingRequest) %>"/>

<div class="cq-dd-brightcovevideo"
     style="overflow-x: hidden;overflow-y: hidden;text-align: center;width: 100%;text-align:center;">
    <div id="${twoColumnBrightcoveVideo.videoRandomId}">

    </div>


    <cq:includeClientLib js="ta-brightcove"/>

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
        customBC.createVideo("100%", "100%", "${twoColumnBrightcoveVideo.playerId}", "${twoColumnBrightcoveVideo.playerKey}", "${twoColumnBrightcoveVideo.videoPlayer}", "${twoColumnBrightcoveVideo.videoRandomId}");
    </script>
</div>

<c:if test="${not empty twoColumnBrightcoveVideo.title}">
    ${twoColumnBrightcoveVideo.title}
</c:if>

<c:if test="${not empty twoColumnBrightcoveVideo.description}">
    ${twoColumnBrightcoveVideo.description}
</c:if>

<c:if test="${not empty twoColumnBrightcoveVideo.link}">
    <a href="${twoColumnBrightcoveVideo.link}" class="map-pin-btn" ${twoColumnBrightcoveVideo.linkIsExternal == true ? 'target="_blank"': ''}>View more videos</a>
</c:if>
