package board.app.sample.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginerror")
public class LoginErrorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            getServletContext().getRequestDispatcher("/view/login/loginerror.jsp").forward(request, response);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

