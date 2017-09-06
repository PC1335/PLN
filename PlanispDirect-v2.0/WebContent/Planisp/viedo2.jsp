<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
　　　<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <link rel="stylesheet" href="css/vidoe.css">
    <link rel="stylesheet" href="vidoe-js.css">
	<script src="video.js"></script>
	<script src="video.min.js"></script>
	<script src="videojs-contrib-hls.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset=utf-8 />
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
        #top{
        	left:0px;
        	width:440px;
        	top:20px;
        	text-align: center;
        	position:fixed;
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
     .div{
        background-color:#444197;
        padding-top:10px;
        margin-top: -20px;
        width: 440px;
        height: 64px;
    }
	label{
		font-size:24px;
		margin-left: 20%;
        color:white ;
        margin-top:5px;
        font-family: "黑体";
        width: auto;
        font-weight:normal;
	} 
	#video{
		color: black;
		background-color: black;
	}
    </style>

</head>

<body style="background-color: #F2F2F2" onload="getMessage()">
<div id="top">
<div id="wrapper" class="div">
        <div id="bt">
      <img src="imagesl/_back.png" onClick="javascript :history.back(1);" border="0"></a>
      	 <label>${name}</label>
        </div>
 
	</div>
<video id="video" class="video-js vjs-default-skin" src="${src }" controls="false" preload="auto" autoplay="autoplay" width="720" height="576" data-setup='{}'>
</video><br/><!--class="video-js vjs-default-skin"  data-setup='{}' preload="auto" autoplay="autoplay"-->
</div>
	<script type="text/javascript">
		$(document).ready(function () {
			var player = videojs("video");
		});
	</script>
</body>
</html>