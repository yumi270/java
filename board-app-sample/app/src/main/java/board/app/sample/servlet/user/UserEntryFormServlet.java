package board.app.sample.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/entryform")
public class UserEntryFormServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            getServletContext().getRequestDispatcher("/view/user/userentryform.jsp").forward(request, response);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
