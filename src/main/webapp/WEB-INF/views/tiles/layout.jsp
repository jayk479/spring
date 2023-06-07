<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Site</title>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	<hr>
	<main>
		<tiles:insertAttribute name="content" />
		<!-- tiles.xml파일에 등록된 name이랑 같아야 됨ㅇㅇ -->
	</main>
	<hr>
	<footer>
		<div style="text-align: center;">
			<h1>예담직업전문학교</h1>
		</div>
	</footer>
</body>
</html>