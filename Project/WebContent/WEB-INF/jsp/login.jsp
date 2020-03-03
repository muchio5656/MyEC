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
		class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent "
		color-on-scroll="1">
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
					<li class="nav-item"><a class="nav-link btn warning"
						href="Car">
							<p>カートへ</p>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="section section-signup"
		style="background-image: url('assets/img/200.jpg'); background-size: cover; background-position: top center; min-height: 1000px;">
		<div class="container">
			<c:if test="${errMsg != null}">
				<div align="center" class="alert alert-danger" role="alert">
					${errMsg}</div>
			</c:if>
			<c:if test="${loginMessage != null}">
				<div align="center" class="alert alert-danger" role="alert">
					${loginMessage}</div>
			</c:if>
			<div class="row">
				<div class="card card-signup" data-background-color="black">
					<form class="form" method="post" action="Login">
						<div class="card-header text-center">
							<h3 class="card-title title-up">Login</h3>
						</div>
						<div class="card-body">
							<div class="input-group no-border">
								<div class="input-group-prepend">
									<span class="input-group-text"> </span>
								</div>
								<input type="text" name="mailAddress" class="form-control"
									placeholder="メールアドレス">
							</div>
							<div class="input-group no-border"></div>
							<div class="input-group no-border">
								<div class="input-group-prepend">
									<span class="input-group-text"> </span>
								</div>
								<input type="password" name="password" class="form-control"
									placeholder="パスワード">
							</div>
						</div>
						<div class="card-footer text-center">
							<button type="submit" class="btn  btn-round btn-lg">ログイン</button>
						</div>
					</form>
				</div>
			</div>
			<div class="col text-center">
				<a href="UserInsert" class="btn  btn-round btn-white btn-lg">新規登録</a>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br> <a href="MasterLogin"
					class="btn  btn-round btn-white btn-lg">管理者ページへ</a>
			</div>
		</div>
	</div>

	<footer class="footer" data-background-color="black">
		<div class=" container ">
			<div>Made by Toshiki Munakata.</div>
		</div>
	</footer>
</body>
</html>