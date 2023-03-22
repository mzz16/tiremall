<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/admin/master.css" />
<script src="https://code.jquery.com/jquery-3.6.3.js"
	integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/css/admin/board/event_board.css">
<link rel="stylesheet" href="resources/css/admin/board/event_modal.css">
<script src="resources/js/admin/admin.js"></script>
</head>
</head>
<body>
	<div id="header">
	<div id="mainMenuba">
		<nav id="mainMenu">
			 <div class="index_logo">
              <a href="/home">
                <img src="resources/web/logo.png" style="height: 50px" />
              </a>
            </div>
			<div id="menuTitle1" onclick="location.href='admin.order.go'">주문 관리</div>
			<div id="menuTitle2" onclick="location.href='admin.tire.go'">타이어상품 관리</div>
			<div id="menuTitle3" onclick="location.href='admin.car.go'">차종 관리</div>
			<div id="menuTitle4" onclick="location.href='admin.auth.go'">회원 관리</div>
			<div id="menuTitle5" onclick="location.href='admin.rental.go'">렌탈 관리</div>
			<div id="menuTitle6" onclick="location.href='admin.store.go'">장착점 관리</div>
			<div id="menuTitle7" onclick="location.href='admin.notice.go'">게시판 관리</div>
		</nav>
		
	</div>
	<div>
		<jsp:include page="${subMenuPage }"></jsp:include>
	</div>
	</div>
	<!--위 내용이 나올때는 top 120px  -->
	
	<div id="adminContent">
		<jsp:include page="${contentPage }"></jsp:include>
	</div>
    <script src="resources/js/admin/board/event_board.js"></script>
</body>
</html>