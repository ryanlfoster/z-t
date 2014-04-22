<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.brightcove.Brightcove" %>

<c:set var="brightcove" value="<%=new Brightcove(slingRequest) %>"/>

<div class="video-large-container">
    <div class="row l-center-1200">
        <div class="col-xs-12">
            <div class="video-position">
                <div class="video-container">
                    <div class="video-container-table">
                        <div class="placeholder">
                            <div class="cq-dd-brightcovevideo" style="overflow-x: hidden;overflow-y: hidden;text-align: center;width: 100%;text-align:center;">
                                <div id="${brightcove.videoRandomId}"></div>

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
                                    customBC.createVideo("100%", "100%", "${brightcove.playerId}", "${brightcove.playerKey}", "${brightcove.videoPlayer}", "${brightcove.videoRandomId}");
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
                <c:if test="${not empty brightcove.title || not empty brightcove.description}">
                    <div class="video-copy-large-container">
                        <c:if test="${not empty brightcove.title}">
                            <span class="video-title-large-video type-h4">${brightcove.title}</span>
                        </c:if>

                        <c:if test="${not empty brightcove.description}">
                            <span class="video-text-large">${brightcove.description}</span>
                        </c:if>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>