<!doctype html>
<html lang="ja">
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
      
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>カート詳細</title>
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
      <nav class="navbar navbar-expand-lg bg-primary">
    <div class="container">
      <div class="navbar-translate">
        <a class="navbar-brand" href="top.html" rel="tooltip" title="Designed by Invision. Coded by Creative Tim" data-placement="bottom" target="_blank">
          Favoul
        </a>
        <button class="navbar-toggler navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-bar top-bar"></span>
          <span class="navbar-toggler-bar middle-bar"></span>
          <span class="navbar-toggler-bar bottom-bar"></span>
        </button>
      </div>
      <div class="collapse navbar-collapse justify-content-end" id="navigation" data-nav-image="./assets/img/blurred-image-1.jpg">
        <ul class="navbar-nav">
          
          <li class="nav-item dropdown">
           
              <a href="#" class="nav-link dropdown-toggle" id="navbarDropdownMenuLink1" data-toggle="dropdown">
              <i class="now-ui-icons design_app"></i>
              <p>カテゴリで探す</p>
            </a>
              
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink1">
              <a class="dropdown-item" href="category.html">ビール</a>
              <a class="dropdown-item" href="category.html">ウィスキー</a>
                <a class="dropdown-item" href="category.html">日本酒・焼酎</a>
                <a class="dropdown-item" href="category.html">ワイン</a>
                <a class="dropdown-item" href="category.html">その他お酒</a>
            </div>
              
          </li>
          <li class="nav-item">
            <a class="nav-link btn btn-black" href="logout.html" target="_blank">
              <p>Log out</p>
            </a>
          </li>
          <form action="search.html" method="post">
          <li class="nav-item">
            <input class="form-control" type="text"  name="search" placeholder="キーワードで探す">
          </li>
            </form>
        </ul>
      </div>
    </div>
  </nav>

      
      
      
       <div class="container">
      <div align="center" class="alert alert-primary" role="alert">配送方法を決めてください
           </div>
           <form action="buyconfirm.html" method="#">
 
    <div align="center"　class="col-5 ml-3">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th></th>
                    <th>商品名</th>
                    <th>単価</th>
                    <th>小計</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th></th>
                    <td>角瓶</td>
                    <th>1000円</th>
                    <th>1000円</th>
                </tr>
                <tr>
                    <th></th>
                    <td>ジムビーム</td>
                    <th>1000円</th>
                    <th>1000円</th>

                </tr>
                <tr>
                    <th></th>
                    <td>メーカーズ</td>
                    <th>1000円</th>
                    <th>1000円</th>
                    
                </tr>
                <tr>
                <td></td>
                    <th></th>
                    <th><!-- Example split danger button -->
<div class="btn-group">
  <button type="button" class="btn btn-defult">配送方法</button>
  <button type="button" class="btn btn-defult dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="#">通常配送</a>
    <a class="dropdown-item" href="#">特急配送</a>
    <a class="dropdown-item" href="#">日付指定配送</a>
  </div>
</div></th>
                    <th>000円</th>
                </tr>
              <tr>
                    <th></th>
                    <td></td>
                    <th>指定お届け日</th>
                    <th><input type="date" class="form-control"></th>
                </tr>
            </tbody>
        </table>
        <button class="btn btn-primary">確認画面へ</button>
               </div></form>
      </div>

      <footer class="footer" data-background-color="black">
      <div class=" container ">
        
        <div >Made by Toshiki Munakata.
          
        </div>
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