<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head style="margin: 4px;">
<title>视频播放中${channel.c_name }</title>
<meta charset=utf-8 />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">
<script src="js/jquery-1.12.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="js/video-js.min.css" rel="stylesheet">


<style type="text/css">
#event {
	width: 250px;
	height: 530px;
	float: right;
}

body {
	background-color: #FFF;
}

.m {
	width: 700px;
	height: 600;
	left: 0px;
	top:0px;
    position:fixed;
      max-width:600px;
}
.panel-heading{
	left: 700px;
	width: 250px;
	background-color: #337;
    position:fixed;
}
ul div{
	width: 245px;
	margin-left: -13px;
	margin-bottom:3px;
	background-color: #EEE;
}
div li {
	margin-left: 10px;img
}
#eventlist{
	margin-top: 30px;
}
.my-video{
	
}
</style>
</head>
<body>
	<div class="m" style="float: left;">
		<video id="my-video" class="video-js" style="background-color:#2C3540;" controls preload="auto"
			width="700" height="394">
			<source
				src="${src}"
				type="application/x-mpegURL">
		</video>
	</div>
	<div id="event">
		<div class="panel-group" id="accordion2">
			<div class="panel-heading">
				<strong style="font-size: 35px;color: #FFF">${name }</strong>
			</div>
			<div class="panel panel-default">
				<div id="eventlist" class="panel-body">
					<ul id="eventlist" class="nav nav-pills nav-stacked">
						<c:forEach var="event" items="${events}">
							<div id="${event.s_contentid}"
								class="_loop">
								<li id="one" style="margin-top: 14px;">${event.s_starttime}
								</li>
								<li id="two"><a>${event.s_name}</a></li>
							</div>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="js/video.min.js"></script>
	<script type="text/javascript" src="js/videojs-contrib-hls.min.js"></script>
	<script src="js/videojs-ie8.min.js"></script>
	<script type="text/javascript">
		var myPlayer = videojs('my-video');
		var hour = new Date().getHours();
		var min = new Date().getMinutes();
		videojs("my-video").ready(function() {
			var myPlayer = this;
			myPlayer.play();
		});
	</script>


	<script type="text/javascript">
		var hour = new Date().getHours();
		var min = new Date().getMinutes();

		$(document).ready(function() {
			var count = 0;
			var divs = document.getElementById("eventlist").getElementsByTagName("div");
			for ( var index = 0; index < divs.length - 1; index++) {
				var timelist = divs.item(index).getElementsByTagName("li").item(0).innerHTML;
				var arr = timelist.split(":");
				var h = parseInt(arr[0]);
				var m = parseInt(arr[1]);
				if (hour > h || hour == h && min >= m) {
					count = index;
				} else {
					break;
				}
			}
			alert(divs.item(count).id);
			var _nowEvent = document.getElementById(divs.item(count).id);
			_nowEvent.style.backgroundColor="#A0A0A0";
			var ls = _nowEvent.getElementsByTagName("li");
			ls.item(0).innerHTML = "正在播放:";
			window.scroll(0, _nowEvent.offsetTop - divs.item(2).offsetTop);
		});
		function sleep(millis){
			var njf1 = njen(this,arguments,"millis");
			nj:while(1) {
				try{
					switch(njf1.cp) { 
						case 0:njf1._notifier=NjsRuntime.createNotifier();
							setTimeout(njf1._notifier,njf1._millis);
							njf1.cp = 1;njf1._notifier.wait(njf1);
							return;
						case 1:break nj; 
						}
					} catch(ex) { 
						if(!njf1.except(ex,1)) return; 
					}
				} 
			njf1.pf();
		} 

/**		for ( var index = count + 1; index < divs.length; index++) {
			var next = document.getElementById(divs.item(index).id);
			next.style.color = "#A0A0A0";
		}
		window.scroll(0, _nowEvent.offsetTop - divs.item(2).offsetTop);
		var c = count;
		function timeListenner() {
			hour = new Date().getHours();
			min = new Date().getMinutes();
			var time = divs.item(c + 1).id;
			var lst = divs.item(c + 1).getElementsByTagName("li");
			var time = lst.item(0).innerHTML;
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
				lst.item(0).innerHTML = "正在播放";
				//_newEvent.removeChild(ls.item(2));
				_newEvent.style.backgroundColor = "#6764A8";
				_newEvent.style.color = "#FFF";
			}
		}
		setInterval(timeListenner, 1000);**/
	</script>
</body>

</html>