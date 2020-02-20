<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>アイテムリスト：管理者専用</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />

    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">

    <!-- CSS Files -->
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../assets/css/now-ui-kit.css?v=1.2.0" rel="stylesheet" />

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="../assets/demo/demo.css" rel="stylesheet" />
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
                    <th>単価</th>
                    <th>売上数</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>1</th>
                    <td>角瓶</td>
                    <th>1000円</th>
                    <th>100個</th>
                    <th><a href="itemDelete.html">
                        <button type="button" class="btn btn-default">削除</button></a></th>
                    <th><a href="itemUpdate.html"><button type="button" class="btn btn-primary">更新</button>
                        </a></th>

                </tr>
                <tr>
                    <th>2</th>
                    <td>ハイネケン</td>
                    <th>1000円</th>
                    <th>100個</th>
               　　　<th><button type="button" class="btn btn-default">削除</button></th>
                    <th><button type="button" class="btn btn-primary">更新</button></th>


                </tr>
                <tr>
                    <th>3</th>
                    <td>メーカーズ</td>
                    <th>1000円</th>
                    <th>100個</th>
                    <th><button type="button" class="btn btn-default">削除</button></th>
                    <th><button type="button" class="btn btn-primary">更新</button></th>

                </tr>
                <tr>
                <td></td>
                    <th></th>
                    <th><!-- Example split danger button -->
<div class="btn-group">

  <div class="dropdown-menu">
    <a class="dropdown-item" href="#">Action</a>
    <a class="dropdown-item" href="#">Another action</a>
    <a class="dropdown-item" href="#">Something else here</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="#">Separated link</a>
  </div>
</div></th>
                </tr>
                <tr>
            </tbody>

        </table>
      <div align="center">
          <button type="button" class="btn btn-default">ログアウト</button></div>



      <footer class="footer" data-background-color="black">
      <div class=" container ">

        <div >Made by Toshiki Munakata.</div>
      </div>
    </footer>








    <!--   Core JS Files   -->
    <script src="../assets/js/core/jquery.min.js" type="text/javascript"></script>
    <script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
    <script src="../assets/js/core/bootstrap.min.js" type="text/javascript"></script>

    <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
    <script src="../assets/js/plugins/bootstrap-switch.js"></script>

    <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
    <script src="../assets/js/plugins/nouislider.min.js" type="text/javascript"></script>

    <!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker --><script src="../assets/js/plugins/bootstrap-datepicker.js" type="text/javascript"></script>

    <!--  Google Maps Plugin    -->
    <script  src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>


    <!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
    <script src="../assets/js/now-ui-kit.js?v=1.2.0" type="text/javascript"></script>
  </body>
</html>