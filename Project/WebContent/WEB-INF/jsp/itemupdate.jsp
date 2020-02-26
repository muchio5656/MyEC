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
  <div class="form-group col s6">
    <label>単価</label>
    <input type="text" class="form-control" name="price" value="${item.price}">
  </div>
          <div class="form-group col s6">
    <label>商品画像</label>
    <input type="file" name="fileName" value="${item.fileName}" >
  </div>
          <br>
          <!-- <div class="row">
  <div class="form-group col s6">
    <label for="exampleInputPassword1">売上数</label>
    <input type="text" class="form-control"  placeholder="売上数">
              </div></div> --></div>
           <div class="form-group col s4">
    <label>商品詳細</label>
    <input type="text" class="form-control" name="detail" value="${item.detail}">
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