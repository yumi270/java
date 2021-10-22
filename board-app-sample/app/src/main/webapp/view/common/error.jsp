<!-- error.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="errormessage" class="java.lang.String" scope="request" />
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>エラー</title>
</head>
<body>
<h1>エラー画面</h1>
<p><%=errormessage %>
<p><a href="<%=request.getContextPath() %>/user/list">ユーザーリストへ戻る</a>
</body>
</html>