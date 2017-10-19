<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json交互的测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
//请求json，输出json
function requestJson(){
	$.ajax({
		type:'post', 
		url:'${pageContext.request.contextPath }/requestJson.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串,商品信息
		data:'{"name":"手机","price":999}',
		success:function(data){//返回json结果
			alert(data.name);
		}
	});
}

//请求key/value，输出是json
function responseJson(){
	$.ajax({
		type:'post', 
		url:'${pageContext.request.contextPath }/responseJson.action',
		//数据格式是json串,商品信息
		//不需要指定contentType
		data:'name=电脑&price=888',
		success:function(data){//返回json结果
			alert(data.name);
		}
	});
}

</script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求json，输出json"/>
<input type="button" onclick="responseJson()" value="请求key/value，输出json"/>
</body>
</html>