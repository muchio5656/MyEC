<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<title>商品登録確認</title>
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

</head>
<body>

	<div class="alert alert-danger" role="alert">
		<h1>商品登録確認</h1>

	</div>

	<div class="container">
		<form action="ItemInsertConfirm" method="post">
			<br>
			<br>
			<div class="row">
				<div class="form-group col s6">
					<label>商品名</label> <input class="form-control" name="name" value="${item.name}"
						readonly>
				</div>
				<div class="form-group col s6">
					<label>単価</label> <input class="form-control" name="price" value="${item.price}"
						readonly>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="form-group col s6">
					<label>商品詳細</label> <input class="form-control"
					name="detail"	value="${item.detail}" readonly>
				</div>
				<div class="form-group col s6">
					<label>商品画像</label> <input class="form-control" value="${item.fileName}" name="fileName"
						readonly>
				</div>

				<input type="hidden" value="${item.itemCategoryId}" name="itemCategoryId">

			</div>
			<br>
			<br>

			<div align="center" class="input-field col s6">
				<div align="center">上記内容で登録してよろしいでしょうか？？</div>
				<button type="submit" class="btn btn-danger">登録</button>
			</div>
		</form>

		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>

	</div>

	 <div align="center" >
		<a href="Masterlist">
			<button type="button" class="btn btn-danger">機能一覧へ</button>
		</a><a href="Logout">
			<button type="button" class="btn btn-default">ログアウト</button>
		</a>
	</div>


	<footer class="footer" data-background-color="black">
		<div class=" container ">
			<div>Made by Toshiki Munakata.</div>
		</div>
	</footer>
	<!--   Core JS Files   -->
	<script src="assets/js/core/jquery.min.js" type="text/javascript"></script>
	<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
	<script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
	<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
	<script src="assets/js/plugins/bootstrap-switch.js"></script>
	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script src="assets/js/plugins/nouislider.min.js"
		type="text/javascript"></script>
	<!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker -->
	<script src="../assets/js/plugins/bootstrap-datepicker.js"
		type="text/javascript"></script>
	<!--  Google Maps Plugin    -->
	<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
	<!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
	<script src="assets/js/now-ui-kit.js?v=1.2.0" type="text/javascript"></script>
</body>
</html>