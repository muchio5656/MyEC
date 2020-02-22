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
                        <button type="button" class="btn btn-danger">更新</button></a>
                        <a href="ItemDelete?id=${item.id}">
                        <button type="button" class="btn btn-default">削除</button></a>
                    <td>
                </tr></c:forEach>
            </tbody>
        </table>
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