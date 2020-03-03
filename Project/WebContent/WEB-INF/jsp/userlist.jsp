<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<title>ユーザ情報一覧</title>
<!--     Fonts and icons     -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"
	rel="stylesheet" />
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css"
	rel="stylesheet">
<!-- CSS Files -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/css/now-ui-kit.css?v=1.2.0" rel="stylesheet" />
<link href="./assets/demo/list.css" rel="stylesheet" />
</head>
<body>
	<div class="alert alert-danger" role="alert">
		<h1>ユーザリスト</h1>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ユーザID</th>
				<th>ユーザ名</th>
				<th>Eメールアドレス</th>
				<th>住所</th>
				<th>生年月日</th>
				<th>登録日</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.mailAddress}</td>
					<td>${user.address}</td>
					<td>${user.birthDate}</td>
					<td>${user.createDate}</td>
					<td><a href="UserDelete?id=${user.id}">
							<button type="button" class="btn btn-default">削除</button>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div align="center">
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
</body>
</html>