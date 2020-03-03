<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="./assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="./assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Topページ</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<!-- CSS Files -->
<link href="./assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="./assets/css/now-ui-kit.css?v=1.3.0" rel="stylesheet" />
<link href="./assets/demo/list2.css" rel="stylesheet" />
<link href="./assets/demo/demo.css" rel="stylesheet" />
</head>
<body class="index-page sidebar-collapse">
	<!-- Navbar -->
	<nav
		class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent "
		color-on-scroll="400">
		<div class="container">
			<div class="navbar-translate">
				<a class="navbar-brand" href="Top" rel="tooltip"
					data-placement="bottom"> Favoul </a>
				<button class="navbar-toggler navbar-toggler" type="button"
					data-toggle="collapse" data-target="#navigation"
					aria-controls="navigation-index" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-bar top-bar"></span> <span
						class="navbar-toggler-bar middle-bar"></span> <span
						class="navbar-toggler-bar bottom-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse justify-content-end"
				id="navigation" data-nav-image="./assets/img/blurred-image-1.jpg">
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a href="#"
						class="nav-link dropdown-toggle" id="navbarDropdownMenuLink1"
						data-toggle="dropdown"> <i class="now-ui-icons design_app"></i>
							<p>カテゴリで探す</p>
					</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownMenuLink1">
							<a class="dropdown-item" href="Category?id=1">ビール</a> <a
								class="dropdown-item" href="Category?id=2">ウィスキー</a> <a
								class="dropdown-item" href="Category?id=3">日本酒・焼酎</a> <a
								class="dropdown-item" href="Category?id=4">ワイン</a> <a
								class="dropdown-item" href="Category?id=5">その他お酒</a>


						</div></li>
					<c:if test="${userInfo==null}">
						<li class="nav-item"><a class="nav-link btn btn-black"
							href="Login">
								<p>Login</p>
						</a></li>
					</c:if>
					<c:if test="${userInfo!= null}">
						<li class="nav-item"><a class="nav-link btn btn-black"
							href="UserData?id=${userInfo.id}">
								<p>${userInfo.name}さん</p>
						</a></li>
						<li class="nav-item"><a class="nav-link btn btn-black"
							href="Logout">
								<p>Log out</p>
						</a></li>
					</c:if>

					<li class="nav-item">
						<form action="Search">
							<input class="form-control" type="text" placeholder="キーワードで探す"
								name="search_word">
						</form>
					</li>
					<li class="nav-item"><a class="nav-link btn warning"
						href="Car">
							<p>カートへ</p>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->
	<div class="page-header clear-filter">
		<div class="page-header-image" data-parallax="true"
			style="background-image: url('./assets/img/305.jpg');"></div>
		<div class="container">
			<div class="content-center brand">
				<img class="n-logo"
					src="./assets/img/ic_sentiment_very_satisfied_48px.png" alt="">
				<h1 class="h1-seo">Favoul</h1>
				<h3>This is a magical site that makes you want to drink</h3>
				<h5>〜酒が飲みたくなる魔法のサイト〜</h5>
			</div>

		</div>
	</div>
	<div class="main">
		<div class="section section-images">
			<div class="row top-item">

				<div class="col-2">
					<img src="assets/img/NQBApId8hoSqtCZ1582656572_1582656577.png">
				</div>
				<div class="col-2">
					<img src="assets/img/sake1.png">
				</div>
				<div class="col-2">
					<img src="assets/img/1002.jpg">
				</div>
				<div class="col-2">
					<img src="assets/img/NQBApId8hoSqtCZ1582656572_1582656577.png">
				</div>
				<div class="col-2">
					<img src="assets/img/sake1.png">
				</div>
				<div class="col-2">
					<img src="assets/img/1002.jpg">
				</div>

			</div>
		</div>
		<div class="container">
			<div class="title">
				<div class="alert alert-primary" role="alert">売り上げランキング</div>
			</div>
			<br> <br>
			<div class="row">
				<div class="col-4">
					<div class="rank">1位</div>
				</div>
				<div class="col-4">
					<div class="rank">2位</div>
				</div>
				<div class="col-4">
					<div class="therd">3位</div>
				</div>
			</div>
			<c:forEach var="item" items="${itemRanking}">
				<div class="card" style="width: 20rem; margin: 22px">
					<a href="ItemDetail?id=${item.id}"> <img class="card_img_top"
						src="assets/img/${item.fileName}">
					</a>
					<div class="card-body">
						<a href="ItemDetail?id=${item.id}">
							<h4 class="card_title">${item.name}</h4>
						</a>
						<p class="card_text">${item.detail}</p>
						<div align="right">
							<p>${item.formatPrice}円</p>
							<a href="ItemAdd?id=${item.id}" class="btn btn-primary">カートに入れる</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
		<br> <br> <br> <br> <br> <br>
		<c:forEach begin="0" end="0" var="f" items="${food}">
			<div class="container">
				<div class="alert alert-primary" role="alert">今日のおつまみ</div>
				<br> <br> <a href="Food?foodId=${f.foodId}">
					<div class="card mb-4">
						<img class="card-img-top" src="assets/img/${f.foodFile}"
							alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">${f.foodName}</h5>

						</div>
					</div>
				</a>
			</div>
		</c:forEach>
		<br> <br> <br> <br> <br> <br> <br>
		<br>
		<div class="container">
			<div class="alert alert-primary" role="alert">今日のウンチク</div>
			<br> <br> <a href="Category?id=${trivia.itemCategoryid}">
				<div class="card bg-dark text-white">
					<img class="card-img" src="assets/img/bg8.jpg">
					<div class="card-img-overlay">
						<h1 class="card-title">${trivia.name}</h1>
						<br> <br>
						<p class="card-text">
							<font size="5">${trivia.detail}</font>
						</p>
					</div>
				</div>
			</a>
		</div>


		<div class="section" id="carousel">
			<div class="container">
				<div class="title">
					<div class="alert alert-primary" role="alert">美しい酒器</div>
					<br> <br>
				</div>
				<a href="ItemDitaile">
					<div class="row justify-content-center">
						<div class="col-lg-8 col-md-12">
							<div id="carouselExampleIndicators" class="carousel slide"
								data-ride="carousel">
								<ol class="carousel-indicators">
									<li data-target="#carouselExampleIndicators" data-slide-to="0"
										class="active"></li>
									<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
									<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
								</ol>
								<div class="carousel-inner" role="listbox">
									<div class="carousel-item active">
										<img class="d-block" src="assets/img/104.jpg"
											alt="First slide">
										<div class="carousel-caption d-none d-md-block">
											<h5>酒器１</h5>
										</div>
									</div>
									<div class="carousel-item">
										<img class="d-block" src="assets/img/101.jpg"
											alt="Second slide">
										<div class="carousel-caption d-none d-md-block">
											<h5>酒器２</h5>
										</div>
									</div>
									<div class="carousel-item">
										<img class="d-block" src="assets/img/102.jpg"
											alt="Third slide">
										<div class="carousel-caption d-none d-md-block">
											<h5>酒器３</h5>
										</div>
									</div>
								</div>
								<a class="carousel-control-prev"
									href="#carouselExampleIndicators" role="button"
									data-slide="prev"> <i
									class="now-ui-icons arrows-1_minimal-left"></i>
								</a> <a class="carousel-control-next"
									href="#carouselExampleIndicators" role="button"
									data-slide="next"> <i
									class="now-ui-icons arrows-1_minimal-right"></i>
								</a>
							</div>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>
	<footer class="footer" data-background-color="black">
		<div class=" container ">
			<div>Made by Toshiki Munakata.</div>
		</div>
	</footer>
	<!--   Core JS Files   -->
	<script src="./assets/js/core/jquery.min.js" type="text/javascript"></script>
	<script src="./assets/js/core/popper.min.js" type="text/javascript"></script>
	<script src="./assets/js/core/bootstrap.min.js" type="text/javascript"></script>
	<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
	<script src="./assets/js/plugins/bootstrap-switch.js"></script>
	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script src="./assets/js/plugins/nouislider.min.js"
		type="text/javascript"></script>
	<!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker -->
	<script src="./assets/js/plugins/bootstrap-datepicker.js"
		type="text/javascript"></script>
	<!--  Google Maps Plugin    -->
	<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
	<!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
	<script src="./assets/js/now-ui-kit.js?v=1.3.0" type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			// the body of this function is in assets/js/now-ui-kit.js
			nowuiKit.initSliders();
		});

		function scrollToDownload() {

			if ($('.section-download').length != 0) {
				$("html, body").animate({
					scrollTop : $('.section-download').offset().top
				}, 1000);
			}
		}
	</script>
</body>

</html>
