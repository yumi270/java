<!-- userdeleteresult.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="loginUserRecord" class="board.app.sample.bean.user.LoginUserRecordBean" scope="request" />
<html style="background-color: 	#FFE4B5;">
<head>
<title>ユーザー削除結果</title>
</head>
<body>
<h1>ユーザー削除結果</h1>
<p><jsp:getProperty name="loginUserRecord" property="userId"/> を削除しました。</p>
<a href="<%=request.getContextPath() %>/user/list">ユーザーリスト</a>
</body>
</html>