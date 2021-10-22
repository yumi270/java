package board.app.sample.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.app.sample.bean.user.LoginUserRecordBean;
import board.app.sample.dao.LoginUserDao;


@WebServlet("/loginresult")
public class LoginResultServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            LoginUserRecordBean input = new LoginUserRecordBean();
            input.setUserId(request.getParameter("userid"));
            input.setPassword(request.getParameter("password"));

            if(input.loginConfirm()){
                // ログイン成功
                HttpSession session = request.getSession(true);
                LoginUserDao dao = new LoginUserDao();
                session.setAttribute("loginUserRecord", dao.getLoginUserRecordBean(input.getUserId()));
                response.sendRedirect(request.getContextPath() + "/board/thread/list");
                return;
            } else {
                // ログイン失敗
                request.setAttribute("loginUserRecord", input);
                request.setAttribute("errormessages", input.getErrorMessages());
                getServletContext().getRequestDispatcher("/view/login/login.jsp").forward(request, response);
            }            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}