<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>cmstown::admin</title>
    <link rel="shortcut icon" type="image⁄x-icon" href="/resources/img/icon.png">
    <link href="/resources/css/adminStudy.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
    <link href="/maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />    <link href="/resources/css/main.css" rel="stylesheet" type="text/css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
    <!-- Plugin CSS -->
    <link href="/resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
    <!-- Theme CSS - Includes Bootstrap -->
    <link href="/resources/startbootstrap/css/creative.min.css" rel="stylesheet">
    <script src="/resources/js/redirect.js"></script>
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
            <a class="nav-link js-scroll-trigger" href="/admin">admin</a>
          </li>
          <li class="nav-item">
            <c:set var = "allCount" value = "0" />
            <c:forEach var="category" begin="0" end="${categoryList.size()}" step="1" items="${categoryList}">
              <c:set var= "allCount" value="${allCount + category.count}"/>
            </c:forEach>
            <a class="nav-link js-scroll-trigger" href="/admin/board">All(${allCount})</a>
          </li>
          <c:forEach var="category" begin="0" end="${categoryList.size()}" step="1" items="${categoryList}">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="/admin/board?category=${category.id}&page=1">${category.name}(${category.count})</a>
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
        <h1>게시판 관리</h1>
      </div>
    </div>
  </section>

  <section class="board page-section">
    <div class="board-table">
      <table>
        <tr>
          <td class="board-main-title">
            <h2>${category.name}(${category.count})</h2>
          </td>
        </tr>
        <c:forEach var="list" begin="0" end="${boardList.size()}" step="1" items="${boardList}">
          <tr class="board-title" onclick="location.href='/study/info?category=${category.name}&no=${list.id}&page=${pagination.curPage}'">
            <td>
              <h3>[${list.categoryName}]</h3>
              <h3>${list.title}</h3>
              조회수 ${list.hit} &nbsp;&nbsp;&nbsp; 작성일자 ${list.date}
            </td>
          </tr>
          <tr class="btn-tr">
            <td><span class="btn-click" onclick="deleteArticle(${list.id})">삭제</span> | <span class="btn-click" onclick="location.href='/admin/modify?no=${list.id}'">수정</span></td>
          </tr>
        </c:forEach>
      </table>
    </div>

    <div class="page-number">
      <c:if test="${pagination.curPage == 1}">
        <i class="fas fa-angle-left"></i>
      </c:if>
      <c:if test="${pagination.curPage != 1}">
        <c:choose>
          <c:when test="${category.id == null}">
            <i class="fas fa-angle-left" style="cursor: pointer" onclick="location.href='/admin/board?page=${pagination.curPage - 1}'"></i>
          </c:when>
          <c:otherwise>
            <i class="fas fa-angle-left" style="cursor: pointer" onclick="location.href='/admin/board?category=${category.id}&page=${pagination.curPage - 1}'"></i>
          </c:otherwise>
        </c:choose>
      </c:if>

      <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
        <c:if test="${pagination.curPage == i}">
          <span style="font-weight: bold">&nbsp;${i}&nbsp;</span>
        </c:if>
        <c:if test="${pagination.curPage != i}">
          <c:choose>
            <c:when test="${category.id == null}">
              <i class="fas fa-angle-left" style="cursor: pointer" onclick="location.href='/study/page=${pagination.curPage - 1}'"></i>
            </c:when>
            <c:otherwise>
              <i class="fas fa-angle-left" style="cursor: pointer" onclick="location.href='/study/category=${category.id}?page=${pagination.curPage - 1}'"></i>
            </c:otherwise>
          </c:choose>
        </c:if>
      </c:forEach>
      <c:if test="${pagination.curPage == pagination.endPage}">
        <i class="fas fa-angle-right"></i>
      </c:if>
      <c:if test="${pagination.curPage != pagination.endPage}">
        <c:choose>
          <c:when test="${category.id == null}">
            <i class="fas fa-angle-left" style="cursor: pointer" onclick="location.href='/study/page=${pagination.curPage - 1}'"></i>
          </c:when>
          <c:otherwise>
            <i class="fas fa-angle-left" style="cursor: pointer" onclick="location.href='/study/category=${category.id}?page=${pagination.curPage - 1}'"></i>
          </c:otherwise>
        </c:choose>
      </c:if>
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
