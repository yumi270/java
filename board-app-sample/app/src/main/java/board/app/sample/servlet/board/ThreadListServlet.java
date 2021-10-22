package board.app.sample.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.app.sample.dao.BoardThreadDao;

@WebServlet("/board/thread/list")
public class ThreadListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BoardThreadDao dao = new BoardThreadDao();
            request.setAttribute("boardThreadListBean", dao.getBoardThreadListBean());
            getServletContext().getRequestDispatcher("/view/board/threadlist.jsp").forward(request, response);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
