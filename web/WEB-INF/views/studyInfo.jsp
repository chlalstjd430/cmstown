<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>cmsTown</title>
  <link href="/resources/css/studyInfo.css" rel="stylesheet">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />    <link href="/resources/css/main.css" rel="stylesheet" type="text/css">
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
  <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
  <!-- Plugin CSS -->
  <link href="/resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
  <!-- Theme CSS - Includes Bootstrap -->
  <link href="/resources/startbootstrap/css/creative.min.css" rel="stylesheet">
  <script src="/resources/js/adminStudy.js"></script>
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
          <c:set var = "allCount" value = "0" />
          <c:forEach var="category" begin="0" end="${categoryList.size()}" step="1" items="${categoryList}">
            <c:set var= "allCount" value="${allCount + category.count}"/>
          </c:forEach>
          <a class="nav-link js-scroll-trigger" href="/study">All(${allCount})</a>
        </li>
        <c:forEach var="category" begin="0" end="${categoryList.size()}" step="1" items="${categoryList}">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/study?category=${category.id}&page=1">${category.name}(${category.count})</a>
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
<c:choose>
  <c:when test="${info == null}">
    <div class="empty">
      <h3>삭제된 게시글 혹은 존재하지 않는 게시글입니다.</h3>
      <a href="/study">목록으로가기</a>
    </div>
  </c:when>
  <c:otherwise>


<section class="board page-section">
  <table class="board-table">
    <tr>
      <td class="board-title" colspan="3"><h2>[${info.categoryName}] ${info.title}</h2></td>
    </tr>
    <tr class="board-top">
      <td class="board-writer"><h5>${info.writer}</h5>${info.date}</td>
      <td class="board-date"></td>
      <td class="board-hit">조회수 ${info.hit}</td>
    </tr>
    <tr>
      <td>
        <c:choose>
          <c:when test="${category == null}">
            <a href="/study?page=${curPage}">목록</a>
          </c:when>
          <c:otherwise>
            <a href="/study?category=${category.id}&page=${curPage}">목록</a>
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
    <tr class="board-middle">
      <td class="board-content"  colspan="3">${info.content}</td>
    </tr>
  </table>
  <h3>댓글(0)</h3>
  <form class="reply-form">
    <input type="email" placeholder="이메일">
    <input type="password" placeholder="비밀번호(수정/삭제 시 사용)">
    <input type="submit" value="등록">
    <textarea placeholder="댓글을 입력해주세요." style="width: 100%;"></textarea>
  </form>
  <table class="reply-table">
    <tr>
      <td class="reply-profile" rowspan="3">이미지</td>
      <td class="reply-nick">익명</td>
      <td class="reply-remarks" rowspan="3"><a href="">삭제</a></td>
    </tr>
    <tr>
      <td class="reply-content">글 내용</td>
    </tr>
    <tr>
      <td class="reply-date">2019-09-14 18:52:31</td>
    </tr>

  </table>
</section>
  </c:otherwise>
</c:choose>


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
