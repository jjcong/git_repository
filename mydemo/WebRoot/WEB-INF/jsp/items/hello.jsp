<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello JS</title>
<script type="text/javascript"></script> 
	window.onload = function () {
	var btn = document.getElementById("btn");
	btn.onclick = function(){
		var h1 = document.getElementById("h1");
		h1.innerHTML = "Hello JS!!!";
	};
	};
</head>
<body>
	<button id="btn">点击这里</button>
	<h1 id="h1"></h1>
</body>
</html>