var BCLplayer;
var BCLexperienceModule;
var BCLvideoPlayer;
var BCLcurrentVideo;
//listener for player error
function onPlayerError(event) {
    /* */
}

//listener for when player is loaded
function onPlayerLoaded(id) {
    // newLog();
//  log("EVENT: onPlayerLoaded");
    BCLplayer = brightcove.api.getExperience(id);
    BCLexperienceModule = BCLplayer.getModule(brightcove.api.modules.APIModules.EXPERIENCE);

    var videoPlayerHolder = brightcove.api.getExperience(id);
    var videoPlayer = videoPlayerHolder.getModule(brightcove.api.modules.APIModules.VIDEO_PLAYER);
    var experienceModule = videoPlayerHolder.getModule(brightcove.api.modules.APIModules.EXPERIENCE);
    setPlayerSize(experienceModule, videoPlayer, $('#' + id).parent().width(), $('#' + id));
}

//listener for when player is ready
function onPlayerReady(event) {
    // log("EVENT: onPlayerReady");

    // get a reference to the video player module
    var BCLvideoPlayer = event.target.experience.getModule(brightcove.api.modules.APIModules.VIDEO_PLAYER);

    // add a listener for media change events
    BCLvideoPlayer.addEventListener(brightcove.api.events.MediaEvent.BEGIN, onMediaBegin);
    BCLvideoPlayer.addEventListener(brightcove.api.events.MediaEvent.COMPLETE, onMediaBegin);
    BCLvideoPlayer.addEventListener(brightcove.api.events.MediaEvent.CHANGE, onMediaBegin);
    BCLvideoPlayer.addEventListener(brightcove.api.events.MediaEvent.ERROR, onMediaBegin);
    BCLvideoPlayer.addEventListener(brightcove.api.events.MediaEvent.PLAY, onMediaBegin);
    BCLvideoPlayer.addEventListener(brightcove.api.events.MediaEvent.STOP, onMediaBegin);

    $(window).resize(function () {
        $(".BrightcoveExperience").each(function () {
            adjustHeightAndWidth(this);
        });
    });
}

function adjustHeightAndWidth(experienceObject) {
    var $this = $(experienceObject);
    var id = $this.attr("id");
    var videoPlayerHolder = brightcove.api.getExperience(id);
    var videoPlayer = videoPlayerHolder.getModule(brightcove.api.modules.APIModules.VIDEO_PLAYER);
    var experienceModule = videoPlayerHolder.getModule(brightcove.api.modules.APIModules.EXPERIENCE);
    setPlayerSize(experienceModule, videoPlayer, $this.parent().width(), $this);
}

function setPlayerSize(experienceModule, videoPlayer, width, div) {
    var aspectRatio = 16 / 9;
    var newHeight = width / aspectRatio;
    experienceModule.setSize(width, newHeight);
    div.height(newHeight + "px");
}

if (customBC == undefined) {
    var customBC = {};
    customBC.createElement = function (el) {
        if (document.createElementNS) {
            return document.createElementNS('http://www.w3.org/1999/xhtml', el);
        } else {
            return document.createElement(el);
        }
    };
    customBC.createVideo = function (width, height, playerID, playerKey, videoPlayer, VideoRandomID, link) {
        var innerhtml = '<object id="myExperience_' + VideoRandomID + '" class="BrightcoveExperience">';
        innerhtml += '<param name="bgcolor" value="#FFFFFF" />';
        innerhtml += '<param name="width" value="' + width + '" />';
        innerhtml += '<param name="height" value="' + height + '" />';
        innerhtml += '<param name="playerID" value="' + playerID + '" />';
        innerhtml += '<param name="playerKey" value="' + playerKey + '" />';
        innerhtml += '<param name="isVid" value="true" />';
        innerhtml += '<param name="isUI" value="true" />';
        innerhtml += '<param name="dynamicStreaming" value="true" />';
        innerhtml += '<param name="linkBaseURL" value="' + link + '" />';
        innerhtml += '<param name="@videoPlayer" value="' + videoPlayer + '" />';
        if (window.location.protocol == 'https:') innerhtml += '<param name="secureConnections" value="true" /> ';
        innerhtml += '<param name="templateLoadHandler" value="onPlayerLoaded" />';
        innerhtml += '<param name="templateReadyHandler" value="onPlayerReady" />';
        innerhtml += '<param name="templateErrorHandler" value="onPlayerError" />';
        innerhtml += '<param name="includeAPI" value="true" /> ';
        innerhtml += '<param name="wmode" value="transparent" />';
        innerhtml += '</object>';
        var objID = document.getElementById(VideoRandomID);
        objID.innerHTML = innerhtml;

        var apiInclude = customBC.createElement('script');
        apiInclude.type = "text/javascript";
        apiInclude.src = "//admin.brightcove.com/js/BrightcoveExperiences.js";
        objID.parentNode.appendChild(apiInclude);

        apiInclude = customBC.createElement('script');
        apiInclude.type = "text/javascript";
        apiInclude.src = "//files.brightcove.com/bc-mapi.js";
        objID.parentNode.appendChild(apiInclude);

        apiInclude = customBC.createElement('script');
        apiInclude.type = "text/javascript";
        apiInclude.text = "window.onload = function() {brightcove.createExperiences();};";
        objID.parentNode.appendChild(apiInclude);
    };
}
BCL = {};
BCL.resizePlayer = function (newWidth) {
    var $BCLcontainingBlock = $('#BCLcontainingBlock');
    $BCLcontainingBlock.width($('#BCLbodyContent').width() * newWidth);
    BCL.experienceModule.setSize($BCLcontainingBlock.width(), $BCLcontainingBlock.height());
    BCL.currentPlayerWidth = newWidth;
}