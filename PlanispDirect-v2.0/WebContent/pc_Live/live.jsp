<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head style="margin: 4px;">
<title>视频播放中${channel.name }</title>
<meta charset=utf-8 />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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

#content,#video {
	float: left;
}
</style>
<link rel="stylesheet" href="css/bootstrap.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">
<script src="js/jquery-1.12.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="js/video-js.min.css" rel="stylesheet">
<script src="js/video.min.js"></script>
<script src="js/videojs-contrib-hls.min.js"></script>
<script src="js/videojs-ie8.min.js"></script>
<script type="text/javascript"></script>
<style type="text/css">
#event {
	width: 250px;
	height: 530px;
	float: left;
}
</style>
</head>
<body>
	<div id="event">
		<div class="panel-group" id="accordion2">
			<div class="panel-heading">
				<strong style="font-size: 35px;">${name }</strong>
			</div>
			<div class="panel panel-default">
				<div id="eventlist" class="panel-body">
					<ul class="nav nav-pills nav-stacked">
						<c:forEach var="event" items="${events}">
							<div id="${event.start_time}" style="background-color:#FFFFFF;"
								class="_loop">
								<li id="one" style="margin-top: 14px;"><a></a>${event.start_time}
								</li>
								<li id="two"><a>${event.title}</a></li>
								<!-- <li id="three">回看</li> -->
							</div>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div style="float: right;">
	<video id="video" class="video-js vjs-default-skin" controls="false"
		preload="auto" autoplay="autoplay" width="700px" height="638"
		data-setup='{}' style="margin-top: 2px;">
	</video>
	<ul id="content" style="display: none;">
	</ul>
	</div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var loc = location.href;
							var n1 = loc.length; //地址的总长度
							//var n2 = loc.indexOf("?"); //取得?号的位置
							//  vvvv.html ? CCTV1 = rtmp://play-test.galaxyclouds.cn/live/CCTV8
							//var name = decodeURI(loc.substr(n2 + 1, 5)); //?号后面5的内容
							var n3 = loc.indexOf("="); //取得=号的位置
							var name = decodeURI(loc.substr(n3 + 1, n1 - n3)); //=号后面的内容
							alert(name);

							var player = videojs("video");

							function flashChecker() {
								var hasFlash = 0;
								var flashVersion = 0; //flash版本
								if (document.all) {
									var swf = new ActiveXObject(
											'ShockwaveFlash.ShockwaveFlash');
									if (swf) {
										hasFlash = 1;
										VSwf = swf.GetVariable("$version");
										flashVersion = parseInt(VSwf.split(" ")[1]
												.split(",")[0]);
									}
								} else {
									if (navigator.plugins
											&& navigator.plugins.length > 0) {
										var swf = navigator.plugins["Shockwave Flash"];
										if (swf) {
											hasFlash = 1;
											var words = swf.description
													.split(" ");
											for ( var i = 0; i < words.length; ++i) {
												if (!isNaN(parseInt(words[i]))) {
													flashVersion = parseInt(words[i]);
													break;
												}
											}
										}
									}
								}
								return {
									f : hasFlash,
									v : flashVersion
								};
							}

							function init2(content) {
								var html = '';
								for ( var i = 0; i < content.length; i++) {
									var li = document.createElement('li');
									li.id = "playlist_" + i;
									li.src = content[i];
									var text = document
											.createTextNode(content[i].name);
									li.appendChild(text);
									document.getElementById("content")
											.appendChild(li);
								}
								document.getElementById("content").onclick = function(
										ev) {
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
								for ( var i = 0; i < content.length; i++) {
									var li = document.createElement('li');
									li.src = content[i];
									li.index = i;
									li.id = "playlist_" + i;
									li.onclick = function() {
										window.sessionStorage.setItem("index",
												this.index);
										window.location.reload(true);
									}
									var text = document
											.createTextNode(content[i].name);
									li.appendChild(text);
									document.getElementById("content")
											.appendChild(li);
								}
								var index = window.sessionStorage
										.getItem("index") || 0;
								var id = "playlist_" + index;
								document.getElementById(id).style.background = "#ccc";
								changeSource(content[index]);
							}

							function changeSource(src) {
								flashInfo = flashChecker();
								var realsrc = src;
								if (!flashInfo.f) {
									realsrc.src = src.src.replace(/^rtmp/,
											"http");
									realsrc.src = realsrc.src.replace(/$/,
											".m3u8");
									realsrc.type = "application/x-mpegURL";
								}
								player.src(realsrc);
								player.load();
								player.play();
							}

							var content = [ {
								"name" : name,
								"src" : "${src}",
								"type" : "rtmp/flv"
							} ];

							init(content);
						});
	</script>
	<script type="text/javascript">
		var hour = new Date().getHours();
		var min = new Date().getMinutes();

		$(document).ready(function() {
		});
		var count = 0;
		var divs = document.getElementById("eventlist").getElementsByTagName(
				"div");
		for ( var index = 0; index < divs.length - 1; index++) {
			var timelist = divs.item(index).id;
			var arr = timelist.split(":");
			var h = parseInt(arr[0]);
			var m = parseInt(arr[1]);
			if (hour > h || hour == h && min >= m) {
				count = index;
			} else {
				break;
			}
		}
		var _nowEvent = document.getElementById(divs.item(count).id);
		var ls = _nowEvent.getElementsByTagName("li");
		ls.item(0).innerHTML = "当前正在播放节目:";
		//ls.item(1).
		//_nowEvent.removeChild(ls.item(2));
		//_nowEvent.style.backgroundColor = "red";
		_nowEvent.style.fontSize = "18px";
		_nowEvent.style.color = "#000";
		_nowEvent.style.fontWeight = "bold";

		for ( var index = count + 1; index < divs.length; index++) {
			var next = document.getElementById(divs.item(index).id);
			//var ls = next.getElementsByTagName("li");
			//next.removeChild(ls.item(2));
			next.style.color = "#A0A0A0";
		}
		window.scroll(0, _nowEvent.offsetTop - divs.item(2).offsetTop);
		var c = count;
		var _li = document.createElement("li");
		_li.setAttribute("class", "three")
		_li.innerHTML = "回看";
		function timeListenner() {
			hour = new Date().getHours();
			min = new Date().getMinutes();
			var time = divs.item(c + 1).id;
			var arr = time.split(":");
			var h = parseInt(arr[0]);
			var m = parseInt(arr[1]);
			if (hour > h || hour == h && min >= m) {
				var _oldEvent = document.getElementById(divs.item(c).id);
				//_oldEvent.appendChild(_li);
				_oldEvent.getElementsByTagName("li").item(0).innerHTML = divs
						.item(c).id;
				_oldEvent.style.backgroundColor = "#FFF";
				_oldEvent.style.color = "#000";
				var _newEvent = document.getElementById(divs.item(++c).id);
				var lst = _newEvent.getElementsByTagName("li");
				lst.item(0).innerHTML = "正在播放";
				//_newEvent.removeChild(ls.item(2));
				_newEvent.style.backgroundColor = "#6764A8";
				_newEvent.style.color = "#FFF";
			}
		}
		setInterval(timeListenner, 1000);
	</script>
</body>

</html>