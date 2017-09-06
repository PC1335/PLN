<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    　　　　<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    　　　　<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.js"></script>
    　　　　<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=0.8, maximum-scale=1.0, user-scalable=no charset=utf-8"/>
    <link rel="stylesheet" href="css/style.css">
	<!--[if IE]>
		<script src="http://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<![endif]-->
</head>
<style type="text/css">

  *{
        font-size: 20px;
    }

    a{
        text-decoration:none;
    }

   img{ height: 100px;
        width: 100px;
        }
    #title{display: none; }

    #bt{
        margin-left: 40%;
        margin-top: -65px;
        color:white ;
        font-size:24px;
        font-family: "黑体";
        width: auto;
    }
    #list{
        background-color:white;
        margin-top: -70px;
        width: 440px;
        height: 50px;
        background-color:#F2F2F2;
    }

    p{

        width: 415px;
        height: 100px;
        background-color:white;

    }
    p a{
        font-size: 23px;
		left: 10px;
		position: relative;
		top: -10px;
    }
	p label{
		font-weight:400;
		font-size: 14px;
		position: relative;
		top:-45px;
		left:120px;
		text-overflow:ellipsis;
		width: 220px;
		white-space:nowrap;
		overflow:hidden;
	}

    .div1{
        background-color: #F2F2F2;
		margin-top: 15px;
    }
    .div{
        background-color:#444197;
        padding-top:80px;
        margin-top: -20px;
        width: 440px;
    }
    #div2{
        margin-top: -70px;
        margin-left: 10px;
    }
    #list li{
    	margin:auto;
    	text-align:center;
    	margin-top:auto;
        width: 110px;
        height:50px;
    }
	#at{
		float: right;
		margin-right:10px;
		position: relative;
		top:-100px;
	}
	div p{
		width: 415px;
	}
	
</style>
<body onload="message()">

	<div id="wrapper" class="div">
        <div id="bt">
            直  播
        </div>
        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                    </a>
                </li>
                <li>
                    <a href="MainServlet">主页</a>
                </li>
                <li>
                    <a href="MainServlet"> 直播</a>
                </li>


            </ul>
        </nav>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper" class="div1">
          <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas" id="bt1">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
          </button>
            <ul class="nav nav-tabs" id="list">
	            <li class="active" ><a id="ys" href="#home" data-toggle="tab">央视</a></li>
	            <li><a id="ws" href="#profile" data-toggle="tab">卫视</a></li>
	            <li><a id="ts" href="#hot" data-toggle="tab">特色</a></li>
	            <li><a id="hd" href="#settings" data-toggle="tab">高清</a></li>
	                　　</ul>
            　<div class="tab-content" id="div2">
            　　　　<div class="tab-pane active" id="home">
            　　　　		<c:forEach var="gq" items="${ys }">
					          	<p id="${gq.c_contentid}">
									<img src="image/${gq.c_name}.png">
									<a style="text-decoration:none" >
										${gq.c_name}</a>
										
									<label>正在播出：</label>
									<img id="at" src="images/TR.png">
					            </p>
					          </c:forEach>
            　　　　</div>
            　　　　<div class="tab-pane" id="profile">
            　　			<c:forEach var="gq" items="${ws }">
					          	<p id="${gq.c_contentid}">
									<img src="image/${gq.c_name}.png">
									<a style="text-decoration:none" >
										${gq.c_name}</a>
										
									<label>正在播出：</label>
									<img id="at" src="images/TR.png">
					            </p>
					          </c:forEach>
            　　　　</div>
            　　　　<div class="tab-pane" id="hot">
            　		<!-- 	<c:forEach var="gq" items="${ts }">
					          	<p id="${gq.c_id}">
									<img src="image/${gq.c_id}.png">
									<a style="text-decoration:none" >
										${gq.c_name}</a>
										
									<label>正在播出：${gq.c_nowEvent}</label>
									<img id="at" src="images/TR.png">
					            </p>
					          </c:forEach> -->
            　　　　</div>
            　　　　<div class="tab-pane"  style="margin-top: 28px;" id="settings">
	          			<c:forEach var="gq" items="${gq }">
					          	<p id="${gq.c_contentid}">
									<img src="image/${gq.c_name}.png">
									<a style="text-decoration:none" >
										${gq.c_name}</a>
										
									<label>正在播出：</label>
									<img id="at" src="images/TR.png">
					            </p>
					          </c:forEach>
            　　　　</div>

            　　</div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

	<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
	<script type="text/javascript">
		$(document).ready(function () {
		  var trigger = $('.hamburger'),
		      overlay = $('.overlay'),
		     isClosed = false;

		    trigger.click(function () {
		      hamburger_cross();
		    });
			function message(){
				alert("${fn:length(list)} ");
			}
		    function hamburger_cross() {

		      if (isClosed == true) {
		        overlay.hide();
		        trigger.removeClass('is-open');
		        trigger.addClass('is-closed');
		        isClosed = false;
		      } else {
		        overlay.show();
		        trigger.removeClass('is-closed');
		        trigger.addClass('is-open');
		        isClosed = true;
		      }
		  }

		  $('[data-toggle="offcanvas"]').click(function () {
		        $('#wrapper').toggleClass('toggled');
		  });
		});
		
		$(function(){ 
			$("li a").click(function(){
				
			});
			$("p").mousedown(function(){  
				this.style.backgroundColor="#444197";
				this.style.color="#FFF";
				$("p a").style.color="#FFF";
			});
			$("p").mouseup(function(){  
				this.style.color="#000";
				this.style.backgroundColor="#FFFFFF";
				var _name = this.getAttribute("id");
				try{
					window.location.href="PlayServlet?id="+_name;
				}catch(e){
					alert(e.message);
				}
			});  
		}); 
		
	</script>
</body>
</html>