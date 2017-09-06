<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset=utf-8 />
    <title>播放中</title>
    <style type="text/css">
    #content {
        width: 400px;
        height: 576px;
        overflow-y: scroll;
        margin-right: 50px;
    }

    #content li {
        list-style: none;
        line-height: 30px;
        text-align: center;
    }

    #content li:hover {
        background-color: #ccc;
        cursor: pointer;
    }

    #content,
    #video {
        float: left;
    }
    </style>
    <link href="js/video-js.min.css" rel="stylesheet">
    <script src="js/video.min.js"></script>
    <script src="js/videojs-contrib-hls.min.js"></script>
    <script src="js/videojs-ie8.min.js"></script>
    <script type="text/javascript" ></script>
</head>

<body>
    <video id="video" class="video-js vjs-default-skin" controls="false" preload="auto" autoplay="autoplay" width="950" height="520" data-setup='{}'>
    </video>
    <ul id="content" style="display: none;">
    </ul>
    <script>
    var loc = location.href;
    var n1 = loc.length; //地址的总长度
    var n2 = loc.indexOf("?"); //取得?号的位置
    //  vvvv.html ? CCTV1 = rtmp://play-test.galaxyclouds.cn/live/CCTV8
    var name = decodeURI(loc.substr(n2 + 1, 5)); //?号后面5的内容
    var n3 = loc.indexOf("="); //取得=号的位置
    var src = decodeURI(loc.substr(n3 + 1, n1 - n3)); //=号后面的内容
    //alert(name);
    //alert(n1);
    //alert(aa);
    //confirm("msg",name);
    //alert(src);
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
                        if (!isNaN(parseInt(words[i]))) {
                            flashVersion = parseInt(words[i]);
                            break;
                        }
                    }
                }
            }
        }
        return { f: hasFlash, v: flashVersion };
    }

    function init2(content) {
        var html = '';
        for (var i = 0; i < content.length; i++) {
            var li = document.createElement('li');
            li.id = "playlist_" + i;
            li.src = content[i];
            var text = document.createTextNode(content[i].name);
            li.appendChild(text);
            document.getElementById("content").appendChild(li);
        }
        document.getElementById("content").onclick = function(ev) {
            var e = ev || event
            var x = e.target || e.srcElement
            if (x.nodeName == 'LI') {
                changeSource(x.src);
            }
        }
        changeSource(content[0]);
    }

    function init(content) {
        var html = '';
        for (var i = 0; i < content.length; i++) {
            var li = document.createElement('li');
            li.src = content[i];
            li.index = i;
            li.id = "playlist_" + i;
            li.onclick = function() {
                window.sessionStorage.setItem("index", this.index);
                window.location.reload(true);
            }
            var text = document.createTextNode(content[i].name);
            li.appendChild(text);
            document.getElementById("content").appendChild(li);
        }
        var index = window.sessionStorage.getItem("index") || 0;
        var id = "playlist_" + index;
        document.getElementById(id).style.background = "#ccc";
        changeSource(content[index]);
    }

    function changeSource(src) {
        flashInfo = flashChecker();
        var realsrc = src;
        if (!flashInfo.f) {
            realsrc.src = src.src.replace(/^rtmp/, "http");
            realsrc.src = realsrc.src.replace(/$/, ".m3u8");
            realsrc.type = "application/x-mpegURL";
        }
        player.src(realsrc);
        player.load();
        player.play();
    }

    var content = [{ "name":"CCTV1" , "src": "rtmp://play-test.galaxyclouds.cn/live/CCTV1", "type": "rtmp/flv" }
    ];


    /*
    var content = [{"name":"上海第一财经","src":"rtmp://play-test.galaxyclouds.cn/live/CBN","type":"rtmp/flv"} ,
    {"name":"上海艺术频道","src":"rtmp://play-test.galaxyclouds.cn/live/SHYSPD","type":"rtmp/flv"} ,
    {"name":"上海生活时尚","src":"rtmp://play-test.galaxyclouds.cn/live/SHSHSH","type":"rtmp/flv"} ,
    {"name":"上海新闻综合","src":"rtmp://play-test.galaxyclouds.cn/live/SHXWZH","type":"rtmp/flv"} ,
    {"name":"新娱乐","src":"rtmp://play-test.galaxyclouds.cn/live/XYL","type":"rtmp/flv"} ,
    {"name":"上海体育频道","src":"rtmp://play-test.galaxyclouds.cn/live/SHTYPD","type":"rtmp/flv"} ,
    {"name":"上海哈哈少儿","src":"rtmp://play-test.galaxyclouds.cn/live/SHHHSE","type":"rtmp/flv"} ,
    {"name":"上海国际频道","src":"rtmp://play-test.galaxyclouds.cn/live/SHGJPD","type":"rtmp/flv"} ,
    {"name":"上海纪实频道","src":"rtmp://play-test.galaxyclouds.cn/live/SHJSPD","type":"rtmp/flv"} ,
    {"name":"娱乐高清","src":"rtmp://play-test.galaxyclouds.cn/live/YLGQ","type":"rtmp/flv"} ,
    {"name":"电视剧高清","src":"rtmp://play-test.galaxyclouds.cn/live/DSJGQ","type":"rtmp/flv"} ,
    {"name":"欢笑剧场高清","src":"rtmp://play-test.galaxyclouds.cn/live/HXJCGQ","type":"rtmp/flv"} ,
    {"name":"全纪实高清","src":"rtmp://play-test.galaxyclouds.cn/live/QJSGQ","type":"rtmp/flv"} ,
    {"name":"魅力音乐高清","src":"rtmp://play-test.galaxyclouds.cn/live/MLYYGQ","type":"rtmp/flv"} ,
    {"name":"新视觉高清","src":"rtmp://play-test.galaxyclouds.cn/live/XSJGQ","type":"rtmp/flv"} ,
    {"name":"都市剧场高清","src":"rtmp://play-test.galaxyclouds.cn/live/DSJCGQ","type":"rtmp/flv"} ,
    {"name":"动漫秀场高清","src":"rtmp://play-test.galaxyclouds.cn/live/DMXCGQ","type":"rtmp/flv"} ,
    {"name":"生活时尚高清","src":"rtmp://play-test.galaxyclouds.cn/live/SHSHGQ","type":"rtmp/flv"} ,
    {"name":"幸福彩高清","src":"rtmp://play-test.galaxyclouds.cn/live/XFCGQ","type":"rtmp/flv"} ,
    {"name":"游戏风云高清","src":"rtmp://play-test.galaxyclouds.cn/live/YXFYGQ","type":"rtmp/flv"} ];
    */

    init(content);
    </script>
</body>

</html>