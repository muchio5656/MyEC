<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="./assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Topページ
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
  <!-- CSS Files -->
  <link href="./assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="./assets/css/now-ui-kit.css?v=1.3.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="./assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="index-page sidebar-collapse">
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent " color-on-scroll="400">
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
              <a class="dropdown-item" href="#">ウィスキー</a>
                <a class="dropdown-item" href="#">日本酒・焼酎</a>
                <a class="dropdown-item" href="#">ワイン</a>
                <a class="dropdown-item" href="#">その他お酒</a>
            </div>

          </li>
          <li class="nav-item">
            <a class="nav-link btn btn-black" href="UserData">
              <p>${userInfo.name}さん</p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link btn btn-black" href="logout.html">
              <p>Log out</p>
            </a>
          </li>

          <li class="nav-item">
              <form action="search.html" method="#">
            <input class="form-control" type="text" placeholder="キーワードで探す">
              </form>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- End Navbar -->
    <div class="page-header clear-filter" >
      <div class="page-header-image" data-parallax="true" style="background-image:url('./assets/img/305.jpg');">
      </div>
      <div class="container">
        <div class="content-center brand">
          <img class="n-logo" src="./assets/img/ic_sentiment_very_satisfied_48px.png" alt="">
          <h1 class="h1-seo">Favoul</h1>
          <h3>This is a magical site that makes you want to drink</h3>
            <h5>〜酒が飲みたくなる魔法のサイト〜</h5>
        </div>

      </div>
    </div>
    <div class="main">
      <div class="section section-images">

      </div>
         <div class="container">
        <div class="title">
      <div class="alert alert-primary" role="alert">
  売り上げランキング
            </div></div><br><br>
      <div class="card" style="width: 20rem;margin: 22px">
          <a href="itemDitaile.html">
  <img class="card-img-top" src="assets/img/1000.jpg" alt="Top1">
          </a>
  <div class="card-body">
                <h3>1位</h3>
       <a href="itemDitaile.html">
    <h4 class="card-title">アイテム名</h4>
      </a>
    <p class="card-text">アイテム詳細 example text to build on the card title and make up the bulk of the card's content.</p>
      <div align="right"><p>○○○円</p>
      <a href="car.html" class="btn btn-primary">カートに入れる</a></div>
  </div>
</div><div class="card" style="width: 20rem;margin: 22px">
              <a href="itemDitaile.html">
  <img class="card-img-top" src="assets/img/1001.jpg" alt="Top2">
             </a>
  <div class="card-body">
          <h3>2位</h3>
       <a href="itemDitaile.html">
    <h4 class="card-title">アイテム名</h4>
      </a>
    <p class="card-text">アイテム詳細 example text to build on the card title and make up the bulk of the card's content.</p>
       <div align="right"><p>○○○円</p>
      <a href="car.html" class="btn btn-primary">カートに入れる</a></div>
  </div>
</div><div class="card" style="width: 20rem;margin: 22px">
              <a href="itemDitaile.html">
  <img class="card-img-top" src="assets/img/1002.jpg" alt="Top3">
             </a>
  <div class="card-body">
                <h3>3位</h3>
       <a href="itemDitaile.html">
    <h4 class="card-title">アイテム名</h4>
      </a>
    <p class="card-text">アイテム詳細 example text to build on the card title and make up the bulk of the card's content.</p>
       <div align="right"><p>○○○円</p>
      <a href="car.html" class="btn btn-primary">カートに入れる</a></div>
  </div>
</div>
        </div>
        <br><br><br><br><br><br>
        <div class="container">
            <div class="alert alert-primary" role="alert">
  今日のおつまみ
            </div><br><br>
            <a href="food.html">
    <div class="card mb-4">
  <img class="card-img-top" src="assets/img/600.jpg" alt="Card image cap">
  <div class="card-body">
    <h4 class="card-title">料理名</h4>
  </div>
</div>
            </a>
        </div>
        <br><br><br><br><br><br><br><br>
         <div class="container">
            <div class="alert alert-primary" role="alert">
  今日のウンチク
            </div><br><br>
             <a href="category.html">
        <div class="card bg-dark text-white">
  <img class="card-img" src="assets/img/1004.jpg" alt="Card image">
  <div class="card-img-overlay">
    <h4 class="card-title">ウンチクタイトル</h4>
    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longeraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaatop and yousxxccvrvvvffbf
        aax.</p>
  </div>
</div>
             </a>
        </div>


      <div class="section" id="carousel">
        <div class="container">
          <div class="title">
           <div class="alert alert-primary" role="alert">
  美しい酒器
</div><br><br>
          </div>
            <a href="itemDitaile.html">
          <div class="row justify-content-center">
            <div class="col-lg-8 col-md-12">
              <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                  <div class="carousel-item active">
                    <img class="d-block" src="assets/img/104.jpg" alt="First slide">
                    <div class="carousel-caption d-none d-md-block">
                      <h5>酒器１</h5>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img class="d-block" src="assets/img/101.jpg" alt="Second slide">
                    <div class="carousel-caption d-none d-md-block">
                      <h5>酒器２</h5>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img class="d-block" src="assets/img/102.jpg" alt="Third slide">
                    <div class="carousel-caption d-none d-md-block">
                      <h5>酒器３</h5>
                    </div>
                  </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                  <i class="now-ui-icons arrows-1_minimal-left"></i>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                  <i class="now-ui-icons arrows-1_minimal-right"></i>
                </a>
              </div>
            </div>
          </div>
            </a>
        </div>
      </div>





    </div>


    <footer class="footer" data-background-color="black">
      <div class=" container ">

        <div >Made by Toshiki Munakata.

        </div>
      </div>
    </footer>

  <!--   Core JS Files   -->
  <script src="./assets/js/core/jquery.min.js" type="text/javascript"></script>
  <script src="./assets/js/core/popper.min.js" type="text/javascript"></script>
  <script src="./assets/js/core/bootstrap.min.js" type="text/javascript"></script>
  <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
  <script src="./assets/js/plugins/bootstrap-switch.js"></script>
  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="./assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
  <!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker -->
  <script src="./assets/js/plugins/bootstrap-datepicker.js" type="text/javascript"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
  <script src="./assets/js/now-ui-kit.js?v=1.3.0" type="text/javascript"></script>
  <script>
    $(document).ready(function() {
      // the body of this function is in assets/js/now-ui-kit.js
      nowuiKit.initSliders();
    });

    function scrollToDownload() {

      if ($('.section-download').length != 0) {
        $("html, body").animate({
          scrollTop: $('.section-download').offset().top
        }, 1000);
      }
    }
  </script</body>

</html>