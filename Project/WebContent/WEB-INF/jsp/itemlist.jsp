<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<title>商品一覧</title>
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

</head>
<body>

	<div class="alert alert-danger" role="alert">
		<h1>商品リスト一覧</h1>

	</div>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>アイテムID</th>
				<th>商品名</th>
				<th>カテゴリー名</th>
				<th>単価</th>
				<th>画像ファイル</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${itemData}">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.itemCategoryName}</td>
					<td>${item.price}</td>
					<td>${item.fileName}</td>
					<td><a href="ItemUpdate?id=${item.id}">
							<button type="button" class="btn btn-danger">更新</button>
					</a> <a href="ItemDelete?id=${item.id}">
							<button type="button" class="btn btn-default">削除</button>
					</a>
					<td>
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