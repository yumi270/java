package board.app.sample.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.app.sample.bean.user.LoginUserRecordBean;
import board.app.sample.dao.LoginUserDao;

@WebServlet("/user/updateform")
public class UserUpdateFormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userId = request.getParameter("id");
            LoginUserDao dao = new LoginUserDao();
            LoginUserRecordBean record = dao.getLoginUserRecordBean(userId);
            request.setAttribute("loginUserRecord", record);
            getServletContext().getRequestDispatcher("/view/user/userupdateform.jsp").forward(request, response);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
