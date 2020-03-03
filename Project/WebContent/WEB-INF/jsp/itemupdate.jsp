<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<title>商品更新</title>
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
  <h1>商品更新</h1>
          </div>
<c:if test="${errMsg != null}">
		<div align="center" class="alert alert-danger" role="alert">
			${errMsg}</div>
	</c:if>
      <div class="container">
      <form action="ItemUpdate" method="post" enctype="multipart/form-data"><br><br>
          <div class="row">
  <div class="form-group col s4">
    <label>アイテムID</label>
    <input class="form-control" name="id" value="${item.id}" readonly>
  </div>
          <div class="form-group col s4">
    <label>商品名</label>
    <input type="text" class="form-control" name="name"  value="${item.name}">
  </div>
          </div>
          <div class="row">
  <div class=" form-group col s6">
    <label>単価</label>
    <div class="tanka">
    <input type="text" class="form-control" name="price" value="${item.price}">
  </div></div>
          <div class="form-group col s6">
    <label>商品画像</label>
<div>
						<span class="btn btn-raised btn-round btn-default btn-file">
							<span class="fileinput-new">画像ファイルを選択してください</span>
							 <input type="file"
							name="fileName" />
						</span>
					</div>  </div>
          <br>
         </div>
           <div class="form-group col s4">
    <label>商品詳細</label>
    <input type="text" class="form-control" name="detail" value="${item.detail}">
  </div>
   <div class="form-group col s6">
					<label>アイテムカテゴリID</label>
					<select data-style="select-with-transition btn-primary btn-round"
						title="カテゴリー選択" data-size="7" name="categoryId">
						<option value="1" >ビール</option>
						<option value="2">ウィスキー</option>
						<option value="3">焼酎・日本酒</option>
						<option value="4">ワイン</option>
						<option value="5">その他お酒</option>
						<option value="6">酒以外</option>
					</select>
				</div>
          <br><br>
<div align="center" class="input-field col s6">

<button type="submit" class="btn btn-danger">更新</button>
          </div>
          </form>
      </div>
      <br><br><br><br><br><br><br><br>

      <div align="center" >
		<a href="Masterlist">
			<button type="button" class="btn btn-danger">機能一覧へ</button>
		</a><a href="Logout">
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