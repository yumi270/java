package board.app.sample.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.app.sample.bean.board.BoardCommentRecordBean;
import board.app.sample.dao.BoardCommentDao;
import board.app.sample.dao.BoardThreadDao;

@WebServlet("/board/thread/commententry")
public class ThreadCommentEntryServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int threadId = Integer.parseInt(request.getParameter("threadid"));
            String threadComment = request.getParameter("threadcomment");
            String postUserName = request.getParameter("postusername");

            BoardCommentRecordBean record = new BoardCommentRecordBean();
            record.setThreadId(threadId);
            record.setThreadComment(threadComment);
            record.setPostUserName(postUserName);

            BoardCommentDao commentDao = new BoardCommentDao();
            if(!record.checkValue()){
                BoardThreadDao threadDao = new BoardThreadDao();
                request.setAttribute("boardThreadRecordBean", threadDao.getBoardThreadRecordBean(threadId));
                request.setAttribute("boardCommentListBean", commentDao.getBoardCommentListBean(threadId));
                request.setAttribute("errormessages", record.getErrorMessages());
                getServletContext().getRequestDispatcher("/view/board/threaddetail.jsp").forward(request, response);
                return;
            }
            
            int result = commentDao.addBoardComment(record);
            if(result == 1) {
                response.sendRedirect(request.getContextPath() + "/board/thread/detail?id=" + threadId);
                return;
            } else {
                request.setAttribute("errormessage", "コメント[" + threadComment + "]を投稿できませんでした。");
                getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
            }
        } catch(Exception e){
            e.printStackTrace();
            request.setAttribute("errormessage", e.getMessage());
            getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
        }
    }
}