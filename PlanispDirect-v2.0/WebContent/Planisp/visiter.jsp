<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>video</title>
   <style type="text/css">
        #content{
            width: 400px;
            height: 576px;
            overflow-y: scroll;
            margin-right: 50px;
        }
        #content li{
            list-style: none;
            line-height: 30px;
            text-align: center;
        }
        #content li:hover{
            background-color: #ccc;
            cursor: pointer;
        }
        #content,#video{
            float: left;
        }
    </style>
    <link href="video-js.min.css" rel="stylesheet">
    <script src="video.min.js"></script>
</head>
<body>
<video id="video" class="video-js vjs-default-skin" controls="false" preload="auto" autoplay="autoplay" width="720" height="576" data-setup='{}'>
</video>
<script type="text/javascript">
	var _name = "<%=request.getAttribute("name")%>" ;
	var _src = "<%=request.getAttribute("src")%>";
	var src = {"name":_name,"src":_src,"type":"application/x-mpegURL"} ;
	    var player = videojs("video");

    function flashChecker() {
        var hasFlash = 0;
        var flashVersion = 0; //flash版本
        if (document.all) {
            var swf = new ActiveXObject('ShockwaveFlash.ShockwaveFlash');
            if (swf) {
                hasFlash = 1;
                VSwf = swf.GetVariable("$version");
                flashVersion = parseInt(VSwf.split(" ")[1].split(",")[0]);
            }
        } else {
            if (navigator.plugins && navigator.plugins.length > 0) {
                var swf = navigator.plugins["Shockwave Flash"];
                if (swf) {
                    hasFlash = 1;
                    var words = swf.description.split(" ");
                    for (var i = 0; i < words.length; ++i) {
                        if (! isNaN(parseInt(words[i]))) {
                            flashVersion = parseInt(words[i]);
                            break;
                        }
                    }
                }
            }
        }
        return { f: hasFlash, v: flashVersion };
    }
    function init(src) {
        flashInfo = flashChecker();
        var realsrc = src;
        if( flashInfo.f){
            realsrc.src = src.src.replace("http","rtmp");
            realsrc.src = realsrc.src.replace(".m3u8","");
            alert( realsrc.src+";"+realsrc.type);
            realsrc.type = "application/x-mpegURL";
        }
        player.src(realsrc);
        player.load();
        player.play();
    }
    init(src);
</script>
</body>
</html>