package board.app.sample.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.app.sample.bean.user.LoginUserRecordBean;
import board.app.sample.dao.LoginUserDao;

@WebServlet("/user/deleteresult")
public class UserDeleteResultServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userId = request.getParameter("userid");
            LoginUserDao dao = new LoginUserDao();
            LoginUserRecordBean record = dao.getLoginUserRecordBean(userId);

            int result = dao.deleteLoginUserInfo(userId);
            if(result == 1) {
                request.setAttribute("loginUserRecord", record);
                getServletContext().getRequestDispatcher("/view/user/userdeleteresult.jsp").forward(request, response);
            } else {
                request.setAttribute("errormessage", record.getUserName() + "を削除できませんでした。");
                getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
            }
        } catch(Exception e){
            e.printStackTrace();
            request.setAttribute("errormessage", e.getMessage());
            getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
        }
    }
}
