<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>cmsTown</title>
    <link href="/resources/css/studyWrite.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />    <link href="/resources/css/main.css" rel="stylesheet" type="text/css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
    <!-- Plugin CSS -->
    <link href="/resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
    <!-- Theme CSS - Includes Bootstrap -->
    <link href="/resources/startbootstrap/css/creative.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
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
            <a class="nav-link js-scroll-trigger" href="/main">HOME</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/study">All</a>
          </li>
          <c:forEach var="category" begin="0" end="${categoryList.size()}" step="1" items="${categoryList}">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="/study?category=${category.id}">${category.name}(${category.count})</a>
            </li>
          </c:forEach>
        </ul>
      </div>
    </div>
  </nav>

  <%-- Study --%>
  <section class="page-section bg-dark" id="projects">
    <div class="container">
      <div class="row text-white justify-content-center">
        <h1>STUDY BOARD</h1>
      </div>
      <div class="row text-white justify-content-center">
        <p>개인적인 학습공간입니다, 피드백은 언제든지 환영합니다:D</p>
      </div>
    </div>
  </section>


  <%-- 작성판 --%>
  <section class="board page-section">
    <form class="board-form" action="/study/postArticle.do" method="post" id="insertBoardFrm" enctype="multipart/form-data">


      카테고리
      <select name="category" id="category">
        <option value="none" selected="selected">카테고리를 선택해주세요.</option>
        <c:forEach var="category" begin="0" end="${categoryList.size()}" step="1" items="${categoryList}">
          <option value="${category.id}">${category.name}</option>
        </c:forEach>
      </select>

      <input type="text" name="title" id="title" placeholder="제목을 입력해주세요." style="width: 100%; margin: 10px 0;" >
      <textarea name="editor" id="editor" style="width: 100%; height: 700px;"></textarea>
      <input type="button" id="insertBoard" value="등록" />
    </form>
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
  <script src="/resources/js/studyWrite.js"></script>
  </body>
</html>
