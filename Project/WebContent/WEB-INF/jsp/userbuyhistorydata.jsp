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
							href="UserData">
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
				</ul>
			</div>
		</div>
	</nav><br><br><br>

      <div class="container">
     <div align="center" class="alert alert-primary" role="alert">
  購入詳細
            </div>
      <table class="table table-striped">
            <thead>
                <tr>
                    <th>   </th>
                    <th>購入日時</th>
                    <th>配送方法</th>
                     <th>購入金額</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                    <th>2020/01/01</th>
                    <th>通常配送</th>
                     <th>1000円</th>
                </tr>


            </tbody>

        </table>

          <br><br><br><br><br>
      <table class="table table-striped">
            <thead>
                <tr>
                    <th>   </th>
                    <th>商品名</th>
                    <th>単価</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                    <th>角瓶</th>
                    <th>1400円</th>
                </tr>
                <tr>
                    <td></td>
                    <th>通常配送</th>
                    <th>〇円</th>

                </tr>


            </tbody>

        </table>


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