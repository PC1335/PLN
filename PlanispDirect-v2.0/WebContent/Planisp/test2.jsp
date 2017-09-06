<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
　　　<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    　　　　<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.js"></script>
    　　　　<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=0.8, maximum-scale=1.0, user-scalable=no charset=utf-8"/>
    <link rel="stylesheet" href="css/vidoe.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8" />
    <title>${channel.name }</title>
    <style type="text/css">
    	img{
    		margin-top:-10px;
    		float: left;
    	}
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
        #content{
            float: left;
        }
        #video{
        	background-color:black;
        	width:420px;
        	height:280px;
        }
        #top{
        	color:#F2F2F2;
        	left:0px;
        	width:440px;
        	top:20px;
        	text-align: center;
        	position:fixed;
        }
        ._loop{
			margin-top:10px;
			padding: 10px;
			width:420px;
			height:45px;
			margin-left:10px;
			border-bottom:1px solid #CCC;
			font-family: "黑体";
			font-weight: 700;
		}
	#lin {
		 height:1px;
		 width:440px;
		 background:#CCCCCC;
		 overflow:hidden;
	}
	#bt{
		font-size:24px;
        color:white ;
        font-family: "黑体";
        height: 10%;
    }
    #bt label{
    	margin-left: -20%;
    }
    #eventlist{
    	margin-top: 60%;
    }
     .div{
        background-color:#444197;
        padding-top:10px;
        margin-top: -20px;
        width: 440px;
        height: 64px;
    }
    .vjs-default-skin .vjs-big-play-button {left:40%;top:40%;}
	label{
		font-size:24px;
		margin-left: 20%;
        color:white ;
        margin-top:5px;
        font-family: "黑体";
        width: auto;
        font-weight:normal;
	} 
    </style>

</head>

<body style="background-color: #F2F2F2" onload="getMessage()">
<div id="top">
<div id="wrapper" class="div">
        <div id="bt">
      <img src="imagesl/_back.png" onClick="javascript :history.back(1);" border="0">
      	 <label>${name}</label>
        </div>
 
	</div>

<video id="video"  src="${src }" controls="false"  data-setup='{}' preload="auto"  />

<div id="lin"></div>
<div id="eventlist">
 	<c:forEach var="event" items="${events}">
		<div id="${event.start_time}" style="background-color:#FFFFFF;" class="_loop">
			<li id="one">${event.start_time}</li>
			<li id="two">${event.title}</li>
			<!-- <li id="three">回看</li> -->
		</div>
	</c:forEach> 
</div>
	<script type="text/javascript">
		var hour = new Date().getHours();
		var min = new Date().getMinutes();
		$(document).ready(function () {
		});
		var count=0;
		var divs = document.getElementById("eventlist").getElementsByTagName("div");
		for (var index = 0; index  < divs.length-1; index ++) {
			var timelist = divs.item(index).id;
			var arr = timelist.split(":");
			var h = parseInt(arr[0]);
			var m = parseInt(arr[1]);
			if(hour>h||hour==h&&min>=m){
				count=index;
			}else{
				break;
			}
		}
		var _nowEvent = document.getElementById(divs.item(count).id);
		var ls = _nowEvent.getElementsByTagName("li");
		ls.item(0).innerHTML="正在播放";
		//_nowEvent.removeChild(ls.item(2));
		_nowEvent.style.backgroundColor="#6764A8";
		_nowEvent.style.color="#FFF";
		for (var index = count+1; index  < divs.length; index ++) {
			var next = document.getElementById(divs.item(index).id);
			//var ls = next.getElementsByTagName("li");
			//next.removeChild(ls.item(2));
			next.style.color="#A0A0A0";
		}
		window.scroll(0,_nowEvent.offsetTop-divs.item(2).offsetTop);
		var c = count;
		var _li = document.createElement("li");
		_li.setAttribute("class", "three")
		_li.innerHTML = "回看";
		function timeListenner(){
			hour = new Date().getHours();
			min = new Date().getMinutes();
			var time = divs.item(c+1).id;
			var arr = time.split(":");
			var h = parseInt(arr[0]);
			var m = parseInt(arr[1]);
			if(hour>h||hour==h&&min>=m){
				var _oldEvent = document.getElementById(divs.item(c).id);
				//_oldEvent.appendChild(_li);
				_oldEvent.getElementsByTagName("li").item(0).innerHTML=divs.item(c).id;
				_oldEvent.style.backgroundColor="#FFF";
				_oldEvent.style.color="#000";
				var _newEvent = document.getElementById(divs.item(++c).id);
				var lst = _newEvent.getElementsByTagName("li");
				lst.item(0).innerHTML="正在播放";
				//_newEvent.removeChild(ls.item(2));
				_newEvent.style.backgroundColor="#6764A8";
				_newEvent.style.color="#FFF";
			}
		}
		setInterval(timeListenner,1000);
	</script>
</body>
</html>