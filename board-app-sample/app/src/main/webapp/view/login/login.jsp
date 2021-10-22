<!-- login.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="loginUserRecord" class="board.app.sample.bean.user.LoginUserRecordBean" scope="request" />
<jsp:useBean id="errormessages" class="java.util.ArrayList" type="java.util.ArrayList<String>" scope="request" />
<html style="background-image: url('https://media.publit.io/file/Snow-background-night.png');">
<head>
<title>ログインフォーム</title>
</head>
<body style="text-align: center;"> 

<div style="background-color: rgba(229, 238, 247, 0.774);width: 300px;height: 250px; margin: auto;position: absolute;top: 200;left: 0;right: 0;">
<form  method="POST" action="<%=request.getContextPath() %>/loginresult">
<h1>ログイン</h1>
<table  border="1" align="center">
<tr><td>ユーザーID</td>
<td><input  type="text" name="userid" value="<jsp:getProperty name="loginUserRecord" property="userId"/>" /></td></tr>
<tr><td>パスワード</td>
<td><input   type="password" name="password" value="<jsp:getProperty name="loginUserRecord" property="password"/>" /></td></tr>
</table>
<br>
<input  type="submit" value="ログイン" style="background-color: #0059b3; color: aliceblue;"/>
</form>
</div>
<% if (errormessages.size() > 0) { %>
<div>
<% for(String message : errormessages) { %>
<p><%=message %></p>
<% } %>
</div>
<% } %>
</body>
</html>