package board.app.sample.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.app.sample.bean.board.BoardThreadRecordBean;
import board.app.sample.dao.BoardThreadDao;

@WebServlet("/board/thread/entry")
public class ThreadEntryServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
         
            String threadTitle = request.getParameter("threadtitle");
            String threadText = request.getParameter("threadtext");
            String postUserName = request.getParameter("postusername");

            BoardThreadRecordBean record = new BoardThreadRecordBean();

            record.setThreadTitle(threadTitle);
            record.setThreadText(threadText);
            record.setPostUserName(postUserName);

            BoardThreadDao dao = new BoardThreadDao();
            if(!record.checkValue()){
                request.setAttribute("boardThreadRecordBean", record);
                request.setAttribute("boardThreadListBean", dao.getBoardThreadListBean());
                request.setAttribute("errormessages", record.getErrorMessages());
                getServletContext().getRequestDispatcher("/view/board/threadlist.jsp").forward(request, response);
                return;
            }
            
            int result = dao.addBoardThread(record);
            if(result == 1) {
                response.sendRedirect(request.getContextPath() + "/board/thread/list");
                return;
            } else {
                request.setAttribute("errormessage", "タイトル[" + threadTitle + "]を投稿できませんでした。");
                getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
            }
        } catch(Exception e){
            e.printStackTrace();
            request.setAttribute("errormessage", e.getMessage());
            getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
        }
    }
}