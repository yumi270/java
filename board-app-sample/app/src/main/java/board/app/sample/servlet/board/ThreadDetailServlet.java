package board.app.sample.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.app.sample.dao.BoardCommentDao;
import board.app.sample.dao.BoardThreadDao;

@WebServlet("/board/thread/detail")
public class ThreadDetailServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            BoardThreadDao threadDao = new BoardThreadDao();
            BoardCommentDao commentDao = new BoardCommentDao();
            request.setAttribute("boardThreadRecordBean", threadDao.getBoardThreadRecordBean(id));
            request.setAttribute("boardCommentListBean", commentDao.getBoardCommentListBean(id));
            getServletContext().getRequestDispatcher("/view/board/threaddetail.jsp").forward(request, response);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

