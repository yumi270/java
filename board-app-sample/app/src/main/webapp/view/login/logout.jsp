<!-- logout.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="errormessage" class="java.lang.String" scope="request" />
<html style="background-color: 	#FFE4B5;">
<head>
<meta charset="UTF-8">
<title>ログアウト画面</title>
</head>
<body>
<h1>ログアウト画面</h1>
<div>ログアウトしました</div>
<p><%=errormessage %>
<p><a href="<%=request.getContextPath() %>/login">ログイン</a>
</body>
</html>