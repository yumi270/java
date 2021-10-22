<!-- loginerror.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="errormessage" class="java.lang.String" scope="request" />
<html style="background-color: 	#FFE4B5;">
<head>
<meta charset="UTF-8">
<title>ログインエラー</title>
</head>
<body>
<h1>ログインエラー</h1>
<p>ログインが必要です。</p>
<p><a href="<%=request.getContextPath() %>/login">ログイン</a>
</body>
</html>