<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="OrcasThemes">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>Live TV</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<!-- 自定义样式 -->
<link rel="stylesheet" href="css/screen.css">
<link rel="stylesheet" href="css/animation.css">
<link rel="stylesheet" href="css/font-awesome.css">
<!-- favicon -->
<link rel="stylesheet" href="css/header.css">
<!--[如果使用IE8]>
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen, projection">
    <![endif]-->
<link href="css/lity.css" rel="stylesheet">
</head>

<body>
	<form action="#" method="post">
		<!-- 主体 1 -->
		<div id="home1" class="container-fluid standard-bg">
			<!-- 头部横线 -->
			<div class="row header-top"></div>
			<!-- 菜单 -->
			<div class="row home-mega-menu ">
				<div class="col-md-12">
					<nav class="navbar navbar-default">
						<div class="navbar-header">
							<!-- 头部 开始-->
							<div class="topbar animated fadeInLeftBig"></div>
							<div class="navbar-wrapper">
								<div class="container">
									<div class="navbar navbar-default navbar-fixed-top"
										role="navigation" id="top-nav">
										<div class="container">
											<div class="navbar-header">
												<!-- Logo 开始 -->
												<!-- <a class="navbar-brand" href="#home"><img src="img/logo_pln.png" alt="logo"></a> -->
												<!-- #Logo 结束 -->
												<button type="button" class="navbar-toggle collapsed"
													data-toggle="collapse" data-target=".navbar-collapse">
													<span class="sr-only">切换导航</span> <span class="icon-bar"></span>
													<span class="icon-bar"></span> <span class="icon-bar"></span>
												</button>
											</div>
											<!-- 导航 开始 -->
											<div class="navbar-collapse  collapse">
												<ul class="nav navbar-nav navbar-left scroll">
													<li><a href="#">主&nbsp;&nbsp;页</a>
													</li>
													<li><a href="#CCTV">CCTV直播</a>
													</li>
													<li><a href="#weishi">卫视直播</a>
													</li>
													<li><a href="#HD">高清直播</a>
													</li>
													<li><a href="#">更多精彩</a>
													</li>
												</ul>
											</div>
											<!-- #导航 结束 -->
										</div>
									</div>
								</div>
							</div>
							<!-- #头部 结束 -->
						</div>
					</nav>
				</div>
			</div>

			<!-- 首页开始 -->
			<div class="row">
				<!--首页主要内容 -->
				<div class="col-lg-12 col-md-8">
					<section id="CCTV" id="home-main">
						<h2 class="">
							<i class="fa fa-television" aria-hidden="true"></i>&nbsp;&nbsp;
							CCTV&nbsp;直播
						</h2>
						<div class="row">
							<!-- 列表 -->
							<div class="col-lg-12 col-md-12 col-sm-12">
								<div class="row auto-clear">

									<!-- 视频分割线 -->
									<c:forEach var="gq" items="${ys }">

										<article class="col-lg-3 col-md-6 col-sm-4">
											<div class="post post-medium">
												<div class="thumbr">
													<a class="afterglow post-thumb" href="PcPlayServlet?id=${gq.c_contentid}" data-lity>
														<span class="play-btn-border" title="Play"> 
														<i class="fa fa-play-circle headline-round"
															aria-hidden="true"></i> </span>
														<div class="cactus-note ct-time font-size-1">
															正在播出：<span></span>
														</div> <img class="img-responsive"
														src="img/live_images/${gq.c_name}.png" alt="#"> </a>
												</div>
												<div class="infor">
													<h4>
														<a id="${gq.c_contentid}" class="title"> ${gq.c_name} </a>
													</h4>
												</div>
											</div>
										</article>
									</c:forEach>
								</div>
								<div class="clearfix spacer"></div>
							</div>
						</div>
					</section>

					<!-- 卫视直播 -->
					<section id="weishi" id="home-main">
						<h2 class="">
							<i class="fa fa-television" aria-hidden="true"></i>&nbsp;&nbsp;
							卫视&nbsp;直播
						</h2>
						<div class="row">
							<!-- 列表 -->
							<div class="col-lg-12 col-md-12 col-sm-12">
								<div class="row auto-clear">

									<!-- 视频分割线 -->
									<c:forEach var="gq" items="${ws }">
										<article class="col-lg-3 col-md-6 col-sm-4">
											<div class="post post-medium">
												<div class="thumbr">
													<a class="afterglow post-thumb" href="PcPlayServlet?id=${gq.c_contentid}" data-lity>
														<span class="play-btn-border" title="Play">
															<i class="fa fa-play-circle headline-round"
															aria-hidden="true"></i> </span>
														<div class="cactus-note ct-time font-size-1">
															正在播出：<span></span>
														</div> <img class="img-responsive"
														src="img/live_images/${gq.c_name}.png" alt="#"> </a>
												</div>
												<div class="infor">
													<h4>
														<a id="${gq.c_contentid}" class="title"> ${gq.c_name} </a>
													</h4>
												</div>
											</div>
										</article>
									</c:forEach>
								</div>
								<div class="clearfix spacer"></div>
							</div>
						</div>
					</section>
					
					<!-- 高清直播 -->
					<section id="HD" id="home-main">
						<h2 class="">
							<i class="fa fa-television" aria-hidden="true"></i>&nbsp;&nbsp;
							高清&nbsp;直播
						</h2>
						<div class="row">
							<!-- 列表 -->
							<div class="col-lg-12 col-md-12 col-sm-12">
								<div class="row auto-clear">

									<!-- 视频分割线 -->
									<c:forEach var="gq" items="${gq }">
										<article class="col-lg-3 col-md-6 col-sm-4">
											<div class="post post-medium">
												<div class="thumbr">
													<a class="afterglow post-thumb" href="PcPlayServlet?id=${gq.c_contentid}" data-lity>
														<span class="play-btn-border" title="Play">
															<i class="fa fa-play-circle headline-round"
															aria-hidden="true"></i> </span>
														<div class="cactus-note ct-time font-size-1">
															正在播出：<span></span>
														</div> <img class="img-responsive"
														src="img/live_images/${gq.c_name}.png" alt="#"> </a>
												</div>
												<div class="infor">
													<h4>
														<a id="${gq.c_contentid}" class="title"> ${gq.c_name} </a>
													</h4>
												</div>
											</div>
										</article>
									</c:forEach>
								</div>
								<div class="clearfix spacer"></div>
							</div>
						</div>
					</section>
				</div>
			</div>
		</div>

		<!-- 尾部  -->
		<footer>
			<!-- 尾部 开始 -->
			<div class="footer text-center spacer">
				<p class="wowload flipInX">以人为本，合作共赢，成为国内一流的专注教育行业网络信息技术服务企业。</p>
				Copyright 2017 <a href="#" title="Live TV"> 普阑尼
				</a> - Live TV
			</div>
			<!-- # 尾部 结束 -->
		</footer>
	</form>

	<!-- JAVA SCRIPT  文件引入 -->
	<script src="js/jquery-1.12.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/lity.js"></script>
	<script type="text/javascript">
		/* 	var msgTip = "${channelSrcs['${gq.name}']}"; 
		    alert(msgTip);  */
	/* 	$(function() {
			$("h4>a").click(function() {
				alert("点到我了！");
				var _vid = this.getAttribute("id");
				alert(_vid);
				window.location.href = "PcPlayServlet?id=" + _vid;
			});

		}); */


	</script>

</body>

</html>