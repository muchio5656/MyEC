<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<title>管理者用機能一覧</title>
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
  <h1>管理者専用機能一覧</h1>
    </div>
      <br>
    <div class="alert alert-primary" role="alert">
  <a href="UserList" class="alert-link">ユーザリスト</a>　　　　　　ユーザ情報の確認、ユーザの削除が行えます。
</div>
<div class="alert alert-success" role="alert">
  <a href="ItemList" class="alert-link">商品リスト</a>　　　　　　　商品詳細：単価：売上数の確認、更新、削除が行えます。
</div>
<div class="alert alert-info" role="alert">
  <a href="ItemInsert" class="alert-link">商品登録</a>　　　　　　　　商品の新規登録が行えます。
</div>
      <div align="center">
          <a href="Logout">
          <button type="button" class="btn btn-default">ログアウト</button>
          </a>
      </div>


 <footer class="footer" data-background-color="black">
      <div class=" container ">
      <div >Made by Toshiki Munakata.
      </div>
      </div>
      </footer>
  </body>
</html>