<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<title>管理者ログイン</title>
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
	<div class="section section-signup"
		style="background-image: url('assets/img/102.jpg'); background-size: cover; background-position: top center; min-height: 1000px;">
		<div class="container">
			<div class="row">
				<div class="card card-signup" data-background-color="black">
					<form class="form" method="post" action="MasterLogin">
						<div class="card-header text-center">
							<h3 class="card-title title-up">管理者ログイン</h3>
						</div>
						<div class="card-body">
							<div class="input-group no-border">
								<div class="input-group-prepend">
									<span class="input-group-text"> </span>
								</div>
								<input type="text" class="form-control" name="mailAddress"
									placeholder="メールアドレス">
							</div>
							<div class="input-group no-border"></div>
							<div class="input-group no-border">
								<div class="input-group-prepend">
									<span class="input-group-text"> </span>
								</div>
								<input type="text" class="form-control" name="password"
									placeholder="パスワード">
							</div>
						</div>
						<div class="card-footer text-center">
							<button class="btn  btn-round btn-lg">Go</button>
						</div>
					</form>
				</div>
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