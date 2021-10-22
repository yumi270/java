<!-- threadlist.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="board.app.sample.bean.user.*"%>
<%@ page import="board.app.sample.bean.board.*"%>

<jsp:useBean id="loginUserRecord" class="board.app.sample.bean.user.LoginUserRecordBean" scope="session" />
<jsp:useBean id="boardThreadListBean" class="board.app.sample.bean.board.BoardThreadListBean" scope="request" />
<jsp:useBean id="boardThreadRecordBean" class="board.app.sample.bean.board.BoardThreadRecordBean" scope="request" />
<jsp:useBean id="errormessages" class="java.util.ArrayList" type="java.util.ArrayList<String>" scope="request" />
<html style="background-image: url(http://img.yao51.com/jiankangtuku/uesuuwsrx.jpeg);width: 600px;margin: auto;position: absolute;top: 10;left: 0;right: 0;">
<head>
<meta charset="UTF-8">
<title>スレッド一覧</title>
</head>
<body >
<h1>スレッド一覧</h1>
<div style="padding-left:400px">利用者名:<jsp:getProperty name="loginUserRecord" property="userName"/></div>
<% if("1".equals(loginUserRecord.getAdminFlag())) {%>
<div style="padding-left:400px"><a href="<%=request.getContextPath() %>/user/list">ユーザー管理</a></div>
<% } %>
<div>
<table border="1" >
<br>
<br>
<br>
<tr><th>タイトル</th><th>投稿者</th><th>投稿日時</th></tr>

<%
    ArrayList<BoardThreadRecordBean> list = boardThreadListBean.getBoardThreadList();
    for(int i = 0; i < list.size(); i++ ) { 
        BoardThreadRecordBean record = list.get(i);
%>

<tr>
<td><a href="<%=request.getContextPath() %>/board/thread/detail?id=<%=record.getThreadId() %>"><%=record.getThreadTitle() %></a></td>
<td><%=record.getPostUserName() %></td>
<td><%=record.getPostDateTime() %></td>
</tr>

<%
    }
%>
</table>
</div>

<div >
<br>
★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
<form method="POST" action="<%=request.getContextPath() %>/board/thread/entry">
<table >
<tr><td>タイトル</td></tr>
<tr><td><input type="text" name="threadtitle" value="<jsp:getProperty name="boardThreadRecordBean" property="threadTitle"/>" /></td></tr>
<tr><td>本文</td></tr>
<tr><td><textarea name="threadtext" rows="10" cols="100"><jsp:getProperty name="boardThreadRecordBean" property="threadText"/></textarea></td></tr>
</table>
<input type="hidden" name="postusername" value="<jsp:getProperty name="loginUserRecord" property="userName"/>" />
<br style="text-align: right;">
<input  type="submit" value="新規投稿" style="background-color: rgb(255, 153, 0); color: aliceblue; "/>
</br>
</form>
</div>

<% if (errormessages.size() > 0) { %>
<div>
<% for(String message : errormessages) { %>
<p><%=message %></p>
<% } %>
</div>
<% } %>
<a href="<%=request.getContextPath() %>/login">ログアウト</a>
</body>
</html>