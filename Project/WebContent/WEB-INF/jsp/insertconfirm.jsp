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
	<nav class="navbar navbar-expand-lg bg-primary ">
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
				<li class="nav-item"><a class="nav-link btn warning" href="Car">
						<p>カートへ</p>
				</a></li>
					</ul>
			</div>
		</div>
	</nav>
	<br>
	<br>
	<br>

	<div class="container">
		<div align="center" class="alert alert-primary" role="alert">
			入力内容確認</div>
		<form action="InsertConfirm" method="post">
			<br>
			<br>
			<div class="row">
				<div class="form-group col s6">
					<label>Eメールアドレス</label> <input class="form-control"
						name="mailAddress" value="${user.mailAddress}" readonly>
				</div>
				<div class="form-group col s6">
					<label>名前</label> <input type="text" class="form-control"
						name="name" value="${user.name}" readonly>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="form-group col s6">
					<label for="exampleInputPassword1">住所</label> <input type="text"
						class="form-control" name="address" value="${user.address}"
						readonly>
				</div>
				<div class="form-group col s6">
					<label for="exampleInputPassword1">生年月日</label> <input
						class="form-control" name="birthDate" value="${StringBirthDate}"
						readonly> <input type="hidden" name="password"
						value="${user.password}">
				</div>
			</div>
			<br>
			<br>
			<div align="center">上記内容で登録してよろしいでしょうか？？</div>
			<div align="center" class="row">
				<div class="input-field col s6">
					<a href="UserInsert">
						<button type="button" class="btn btn-default">修正</button>
					</a>
					<button type="submit" class="btn btn-primary">登録</button>

				</div>
			</div>
		</form>
		<br>
		<br>
		<br>
		<br>
		<br>
	</div>
	<footer class="footer" data-background-color="black">
		<div class=" container ">
			<div>Made by Toshiki Munakata.</div>
		</div>
	</footer>
	 <script src="./assets/js/core/jquery.min.js" type="text/javascript"></script>
	<script src="./assets/js/core/popper.min.js" type="text/javascript"></script>
	<script src="./assets/js/core/bootstrap.min.js" type="text/javascript"></script>
	<!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
	<script src="./assets/js/now-ui-kit.js?v=1.3.0" type="text/javascript"></script>

</body>
</html>