<!-- userupdateresult.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="loginUserRecord" class="board.app.sample.bean.user.LoginUserRecordBean" scope="request" />
<html style="background-color:	#FFE4B5;">
<head>
<title>ユーザー更新結果</title>
</head>
<body>
<h1>ユーザー更新結果</h1>
<p><jsp:getProperty name="loginUserRecord" property="userName"/> を更新しました。</p>
<a href="<%=request.getContextPath() %>/user/list">ユーザーリスト</a>
</body>
</html>