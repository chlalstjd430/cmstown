<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>cmsTown</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />    <link href="/resources/css/main.css" rel="stylesheet" type="text/css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
    <!-- Plugin CSS -->
    <link href="/resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
    <!-- Theme CSS - Includes Bootstrap -->
    <link href="/resources/startbootstrap/css/creative.min.css" rel="stylesheet">
  </head>
  <body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="/main">CMS TWON</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto my-2 my-lg-0">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/main#about">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/main#skills">Skills</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/projects">Projects</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/study">Study</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/main#contact">Contact</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Masthead -->
  <header class="masthead">
    <div class="container h-100">
      <div class="row h-100 align-items-center justify-content-center text-center">
        <div class="col-lg-10 align-self-end">
          <h1 class="text-uppercase text-white font-weight-bold">개발자 민성이의 홈페이지</h1>
          <hr class="divider my-4">
        </div>
        <div class="col-lg-8 align-self-baseline">
          <p class="text-white-75 font-weight-light mb-5">코딩을 좋아하는 평범한 대학생의 홈페이지입니다:D</p>
          <a class="btn btn-light btn-xl js-scroll-trigger" href="#about">About Me</a>
        </div>
        <div class="bottom-img text-center col-lg-12">
          <img src="/resources/img/scroll-down.gif">
        </div>
      </div>
    </div>
  </header>

  <!-- About Section -->
  <section class="page-section bg-dark" id="about">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-8 text-center">
          <h2 class="text-white mt-0">About Me</h2>
          <hr class="divider light my-4">
          <p class="text-white-50 mb-4">간단한 자기소개 내용넣기</p>
          <p class="text-white-50 mb-4">- 1995년 4월 30일</p>
          <p class="text-white-50 mb-4">- 전주한일고등학교 졸업</p>
          <p class="text-white-50 mb-4">- 숭실대학교 글로벌미디어학부</p>
          <p class="text-white-50 mb-4">- 렉토피아 JAVA 전문가 과정 17기 수료</p>
          <a class="btn btn-light btn-xl js-scroll-trigger" href="/projects">Projects</a>
        </div>
      </div>
    </div>
  </section>

  <!-- Services Section -->
  <section class="page-section" id="skills">
    <div class="container">
      <h1 class="text-center mt-0">Skills</h1>
      <hr class="divider my-4">
      <h3 class="text-center mt-0">Programming Language</h3>
      <div class="row">
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/c.png">
            <h3 class="h4 mb-2">C</h3>
<%--            <p class="text-muted mb-0">상급</p>--%>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/c++.png">
            <h3 class="h4 mb-2">C++</h3>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/java.png">
            <h3 class="h4 mb-2">JAVA</h3>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/html.png">
            <h3 class="h4 mb-2">HTML</h3>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/css.png">
            <h3 class="h4 mb-2">CSS</h3>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/js.png">
            <h3 class="h4 mb-2">JAVA SCRIPT</h3>
          </div>
        </div>
      </div>


      <hr class="divider my-4">
      <h3 class="text-center mt-0">FrameWork</h3>
      <div class="row">
        <div class="col-lg-6 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/spring.png">
            <h3 class="h4 mb-2">Spring</h3>
          </div>
        </div>
        <div class="col-lg-6 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/mybatis.png">
            <h3 class="h4 mb-2">Mybatis</h3>
          </div>
        </div>
      </div>

      <hr class="divider my-4">
      <h3 class="text-center mt-0">DataBase</h3>
      <div class="row">
        <div class="col-lg-6 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/mysql.png">
            <h3 class="h4 mb-2">MySQL</h3>
          </div>
        </div>
        <div class="col-lg-6 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/oracle.png">
            <h3 class="h4 mb-2">ORACLE</h3>
          </div>
        </div>
      </div>

      <hr class="divider my-4">
      <h3 class="text-center mt-0">IDE</h3>
      <div class="row">
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/intellij.png">
            <h3 class="h4 mb-2">IntelliJ</h3>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/eclipse.png">
            <h3 class="h4 mb-2">Eclipse</h3>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/android.png">
            <h3 class="h4 mb-2">Android Studio </h3>
          </div>
        </div>
        <div class="col-lg-6 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/sql%20developer.png">
            <h3 class="h4 mb-2">SQL Developer</h3>
          </div>
        </div>
        <div class="col-lg-6 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/workbench.png">
            <h3 class="h4 mb-2">Workbench</h3>
          </div>
        </div>
      </div>

      <hr class="divider my-4">
      <h3 class="text-center mt-0">ETC</h3>
      <div class="row">
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/staruml.png">
            <h3 class="h4 mb-2">starUML</h3>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/visualparadigm.png">
            <h3 class="h4 mb-2">Visual Paradigm</h3>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/atom.png">
            <h3 class="h4 mb-2">Atom</h3>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/github.png">
            <h3 class="h4 mb-2">Github</h3>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/git.png">
            <h3 class="h4 mb-2">Git</h3>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 text-center">
          <div class="mt-5">
            <img src="/resources/img/tortoise.png">
            <h3 class="h4 mb-2">TortoiseSVN</h3>
          </div>
        </div>
      </div>

    </div>
  </section>

  <!-- Contact Section -->
  <section class="page-section bg-dark" id="contact">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-8 text-center">
          <h1  class="mt-0 text-white">Contact</h1>
          <hr class="divider my-4">
<%--          <p class="text-muted mb-5">소중한 연락을 기다리겠습니다.</p>--%>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-4 ml-auto text-center mb-5 mb-lg-0">
          <i class="fas text-white fa-phone-square "style="font-size: 100px;"></i>
          <div class="text-white ">010-8757-1048</div>
        </div>
        <div class="col-lg-4 mr-auto text-center">
          <i class="fas text-white fa-envelope-square" style="font-size: 100px;"></i>
          <!-- Make sure to change the email address in anchor text AND the link below! -->
          <p class="d-block text-white ">cms3136@gmail.com</p>
        </div>
      </div>
    </div>

  </section>

  <!-- Footer -->
  <footer class="bg-light py-5">
    <div class="container">
      <div class="small text-center text-muted">Copyright &copy; 2019 - Choi Min Seong</div>
    </div>
  </footer>


  <!-- Bootstrap core JavaScript -->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="/resources/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="/resources/startbootstrap/js/creative.min.js"></script>

  </body>
</html>
