package board.app.sample.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.app.sample.dao.LoginUserDao;


@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            LoginUserDao dao = new LoginUserDao();
            request.setAttribute("loginUserListBean", dao.getLoginUserListBean());
            getServletContext().getRequestDispatcher("/view/user/userlist.jsp").forward(request, response);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
