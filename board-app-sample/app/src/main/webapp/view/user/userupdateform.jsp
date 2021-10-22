<!-- userupdateform.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="loginUserRecord" class="board.app.sample.bean.user.LoginUserRecordBean" scope="request" />
<jsp:useBean id="errormessages" class="java.util.ArrayList" type="java.util.ArrayList<String>" scope="request" />
<html style="background-image: url(http://img.yao51.com/jiankangtuku/uesuuwsrx.jpeg);margin: auto;position: absolute;top: 10;left: 0;right: 0;">
<head>
<title>ログインユーザー更新フォーム</title>
</head>
<body style="text-align: center;">
<h1>ログインユーザー更新フォーム</h1>
<div text-align="center">
<form method="POST" action="<%=request.getContextPath() %>/user/updateresult">
<table border="1" align= "center">
<tr><td>ユーザーID</td><td><jsp:getProperty name="loginUserRecord" property="userId"/></td></tr>
<tr><td>ユーザー名</td><td><input type="text" name="username" value="<jsp:getProperty name="loginUserRecord" property="userName"/>" /></td></tr>
<tr><td>パスワード</td><td><input type="text" name="password" value="<jsp:getProperty name="loginUserRecord" property="password"/>" /></td></tr>
<tr><td>メールアドレス</td><td><input type="text" name="email" value="<jsp:getProperty name="loginUserRecord" property="email"/>" /></td></tr>
<tr>
  <td>権限</td>
  <td>
    <input type="radio" name="adminflag" value="1" <% if ( "1".equals(loginUserRecord.getAdminFlag()) ) { %> checked <% } %>>管理者</input>
    <input type="radio" name="adminflag" value="0" <% if ( !"1".equals(loginUserRecord.getAdminFlag()) ) { %> checked <% } %>>一般</input>
  </td>
</tr>
</table>
<input type="hidden" name="userid" value="<jsp:getProperty name="loginUserRecord" property="userId"/>" />
<input type="submit" value="更新" />
</form>
</div>
<% if (errormessages.size() > 0) { %>
<div>
<% for(String message : errormessages) { %>
<p><%=message %></p>
<% } %>
</div>
<% } %>
<a href="<%=request.getContextPath() %>/user/list">キャンセル</a>
</body>
</html>