<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<title>ログインページ</title>
<!--     Fonts and icons     -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"
	rel="stylesheet" />
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css"
	rel="stylesheet">
<!-- CSS Files -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/css/now-ui-kit.css?v=1.2.0" rel="stylesheet" />
</head>
<body>
	<nav
		class="navbar navbar-expand-lg bg-primary ">
		<div class="container">
			<div class="navbar-translate">
				<a class="navbar-brand" href="Top" rel="tooltip" title="Topページへ"
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
							<a class="dropdown-item" href="Category">ビール</a> <a
								class="dropdown-item" href="category.html">ウィスキー</a> <a
								class="dropdown-item" href="category.html">日本酒・焼酎</a> <a
								class="dropdown-item" href="category.html">ワイン</a> <a
								class="dropdown-item" href="category.html">その他お酒</a>
						</div></li>
						<c:if test="${userInfo.name!= null}">
					<li class="nav-item"><a class="nav-link btn btn-black"
						href="UserData">
							<p>${userInfo.name}さん</p>
					</a></li></c:if>


					<li class="nav-item"><a class="nav-link btn btn-black"
						href="Logout">
							<p>Log out</p>
					</a></li>
					<form action="Search" method="post">
						<li class="nav-item"><input class="form-control" type="text"
							name="search" placeholder="キーワードで探す"></li>
					</form>
				</ul>
			</div>
		</div>
	</nav>

     <div class="container">
            <div class="alert alert-primary" role="alert">
  商品詳細
            </div><br><br>

    <div class="card mb-4">
  <img class="card-img-top" src="assets/img/1000.jpg" alt="Card image cap">
  <div class="card-body">
    <h1 class="card-title">サントリー角瓶</h1>
    <p class="card-text">商品紹介
■国内NO.1ウイスキーのサントリー「角瓶」とは

「日本人の舌に合う日本のウイスキーをつくりたい」。

1937年、壽屋(現サントリー)創業者の鳥井信治郎が十数年かけて完成させたウイスキーが「角瓶」です。

その繊細な味わいは日本人の味覚を満足させ、当時の人々の心を豊かにしました。その後70年以上にわたって日本の食卓で愛され続け、2014年には過去最高販売数量を更新(※1)。国内NO.1ウイスキー(※2)となりました。

※2 サントリー出



原材料・成分
モルト、グレーン</p>

      <div align="right"><h2>○○○円</h2>
      <a href="car.html" class="btn btn-primary btn-lg">カートに入れる</a></div>
  </div>
</div>
        </div>





      <footer class="footer" data-background-color="black">
      <div class=" container ">
      <div >Made by Toshiki Munakata.
      </div>
      </div>
      </footer>
    <!--   Core JS Files   -->
    <script src="assets/js/core/jquery.min.js" type="text/javascript"></script>
    <script src="assets/js/core/popper.min.js" type="text/javascript"></script>
    <script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
    <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
    <script src="assets/js/plugins/bootstrap-switch.js"></script>
    <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
    <script src="assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
    <!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker --><script src="../assets/js/plugins/bootstrap-datepicker.js" type="text/javascript"></script>
    <!--  Google Maps Plugin    -->
    <script  src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
    <!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
    <script src="assets/js/now-ui-kit.js?v=1.2.0" type="text/javascript"></script>
  </body>
</html>