var BCLplayer;
var BCLexperienceModule;
var BCLvideoPlayer;
var BCLcurrentVideo;
var $overlayContent;
var $playButton;
var BCLplayers = [];
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

    BCLplayers.push(BCLplayer);

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
    var mediaEvent = brightcove.api.events.MediaEvent;

    // add a listener for media change events
    BCLvideoPlayer.addEventListener(mediaEvent.BEGIN, function (event) {
        onMediaBegin(event, BCLvideoPlayer)
    });
    BCLvideoPlayer.addEventListener(mediaEvent.COMPLETE, function (event) {
        onMediaStop(event, BCLvideoPlayer)
    });
//    BCLvideoPlayer.addEventListener(mediaEvent.CHANGE, function(event){ onMediaBegin(event, BCLvideoPlayer) });
//    BCLvideoPlayer.addEventListener(mediaEvent.ERROR, function(event){ onMediaBegin(event, BCLvideoPlayer) });
    BCLvideoPlayer.addEventListener(mediaEvent.PLAY, function (event) {
        onMediaPlay(event, BCLvideoPlayer)
    });
    BCLvideoPlayer.addEventListener(mediaEvent.STOP, function (event) {
        onMediaStop(event, BCLvideoPlayer)
    });

    $(window).resize(function () {
        $(".BrightcoveExperience").each(function () {
            adjustHeightAndWidth(this);
        });
    });

    $(".BrightcoveExperience").each(function () {
        setUpOverlay(this);
    });
}

onMediaBegin = function (event, BCLvideoPlayer) {
    //console.log('begin');
}

onMediaPlay = function (event, BCLvideoPlayer) {

    var id = event.target.experience.id;
    var videoPlayerHolder = brightcove.api.getExperience(id);
    var videoPlayer = videoPlayerHolder.getModule(brightcove.api.modules.APIModules.VIDEO_PLAYER);
    var videoPlayerIDValue = id.replace("myExperience_", "");

    $('#' + videoPlayerIDValue).parents(".video-container-table").find('.l-table-container').remove();

    //console.log ("Player " + id + " playing");

    for (var i = 0; i < BCLplayers.length; i++) {
        if (BCLplayers[i].id != id) {
            var player = brightcove.api.getExperience(BCLplayers[i].id);
            var videoPlayer = player.getModule(brightcove.api.modules.APIModules.VIDEO_PLAYER);
            videoPlayer.pause(true);
        }
    }
}

// show the paused overlay when the video is stopped
onMediaStop = function (event, BCLvideoPlayer) {
    var overlayContent = '<div class="l-table-container"><div class="l-table"><div class="l-table-cell-centered"><img class="video-play-icon bclPlayButton paused" src="/etc/designs/tourismaustralia/clientlibs/img/icons/video_play_large.png" alt="" /></div></div></div>';
    var id = event.target.experience.id;
    var videoPlayerHolder = brightcove.api.getExperience(id);
    var videoPlayer = videoPlayerHolder.getModule(brightcove.api.modules.APIModules.VIDEO_PLAYER);
    var videoPlayerIDValue = id.replace("myExperience_", "");

    createOverlayContent($('#' + videoPlayerIDValue), videoPlayer);
    //console.log('stop');
}

createOverlayContent = function (target, videoPlayer) {
    var overlayContent = '<div class="l-table-container"><div class="l-table"><div class="l-table-cell-centered"><img class="video-play-icon" src="/etc/designs/tourismaustralia/clientlibs/img/icons/video_play_large.png" alt="" /></div></div></div>';

    target.parents(".video-container-table").append(overlayContent);

    $playButton = target.parents(".video-container-table").find(".l-table-container");

    $playButton.on("click", function (evt) {
        videoPlayer.play();
    });
}

setUpOverlay = function (experienceObject) {
    var $this = $(experienceObject);
    var id = $this.attr("id");
    var videoPlayerHolder = brightcove.api.getExperience(id);
    var videoPlayer = videoPlayerHolder.getModule(brightcove.api.modules.APIModules.VIDEO_PLAYER);

    createOverlayContent($this, videoPlayer);
};

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