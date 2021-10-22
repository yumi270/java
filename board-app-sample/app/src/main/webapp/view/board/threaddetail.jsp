<!-- threaddetail.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="board.app.sample.bean.user.*"%>
<%@ page import="board.app.sample.bean.board.*"%>
<jsp:useBean id="loginUserRecord" class="board.app.sample.bean.user.LoginUserRecordBean" scope="session" />
<jsp:useBean id="boardThreadRecordBean" class="board.app.sample.bean.board.BoardThreadRecordBean" scope="request" />
<jsp:useBean id="boardCommentRecordBean" class="board.app.sample.bean.board.BoardCommentRecordBean" scope="request" />
<jsp:useBean id="boardCommentListBean" class="board.app.sample.bean.board.BoardCommentListBean" scope="request" />
<jsp:useBean id="errormessages" class="java.util.ArrayList" type="java.util.ArrayList<String>" scope="request" />
<html style="background-image: url(http://img.yao51.com/jiankangtuku/uesuuwsrx.jpeg);width: 600px;margin: auto;position: absolute;top: 10;left: 0;right: 0;">
<head>
<meta charset="UTF-8">
<title>スレッド詳細</title>
</head>
<body style="background-color: rgb(248, 201, 71);width: 800;">
<h1 style="text-align: center;">スレッド詳細</h1>
<div style="padding-left:600px">利用者名:<jsp:getProperty name="loginUserRecord" property="userName"/></div>
<div>
<table border="1">
<tr>
  <td><jsp:getProperty name="boardThreadRecordBean" property="threadTitle"/></td>
  <td><jsp:getProperty name="boardThreadRecordBean" property="postUserName"/></td>
  <td><jsp:getProperty name="boardThreadRecordBean" property="postDateTime"/></td>
</tr>
<tr><td colspan="3"><jsp:getProperty name="boardThreadRecordBean" property="threadText" /></td></tr>
</table>
</div>
<div>
<table border="1">
<%
    ArrayList<BoardCommentRecordBean> list = boardCommentListBean.getBoardCommentList();
    for(int i = 0; i < list.size(); i++ ) { 
        BoardCommentRecordBean record = list.get(i);
%>

<tr>
<td><%=i + 1 %></td>
<td><%=record.getThreadComment() %></td>
<td><%=record.getPostUserName() %></td>
<td><%=record.getPostDateTime() %></td>
</tr>

<%
    }
%>
</table>
</div>
<div>
<form method="POST" action="<%=request.getContextPath() %>/board/thread/commententry">
<table>
<tr><td>コメント</td></tr>
<tr><td><textarea name="threadcomment" rows="10" cols="100"><jsp:getProperty name="boardCommentRecordBean" property="threadComment"/></textarea></td></tr>
</table>
<input type="hidden" name="threadid" value="<jsp:getProperty name="boardThreadRecordBean" property="threadId"/>" />
<input type="hidden" name="postusername" value="<jsp:getProperty name="loginUserRecord" property="userName"/>" />
<input type="submit" value="コメントする" />
</form>

</div>
<% if (errormessages.size() > 0) { %>
<div>
<% for(String message : errormessages) { %>
<p><%=message %></p>
<% } %>
</div>
<% } %>
<a href="<%=request.getContextPath() %>/board/thread/list">一覧へ</a>
</body>
</html>