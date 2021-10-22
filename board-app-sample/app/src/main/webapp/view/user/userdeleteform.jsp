<!-- userdeleteform.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="loginUserRecord" class="board.app.sample.bean.user.LoginUserRecordBean" scope="request" />
<html style="background-color: 	#FFE4B5;">
<head>
<title>ユーザー削除フォーム</title>
</head>
<body>
<h1>ユーザー削除フォーム</h1>
<form method="POST" action="<%=request.getContextPath() %>/user/deleteresult">
<div text-align="center">
ユーザーID:<jsp:getProperty name="loginUserRecord" property="userId"/>を削除します。<br>
よろしいですか？
</div>
<input type="hidden" name= "userid" value="<jsp:getProperty name="loginUserRecord" property="userId"/>"/>
<input type="submit" value="削除"/>
</form>
<a href="<%=request.getContextPath() %>/user/list">キャンセル</a>
</body>
</html>