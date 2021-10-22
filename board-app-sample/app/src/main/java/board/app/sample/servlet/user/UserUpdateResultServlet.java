package board.app.sample.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.app.sample.bean.user.LoginUserRecordBean;
import board.app.sample.dao.LoginUserDao;

@WebServlet("/user/updateresult")
public class UserUpdateResultServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userId = request.getParameter("userid");
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String adminFlag = request.getParameter("adminflag");

            LoginUserRecordBean record = new LoginUserRecordBean();
            record.setUserId(userId);
            record.setUserName(userName);
            record.setPassword(password);
            record.setEmail(email);
            record.setAdminFlag(adminFlag);

            if(!record.checkValue()){
                request.setAttribute("loginUserRecord", record);
                request.setAttribute("errormessages", record.getErrorMessages());
                getServletContext().getRequestDispatcher("/view/user/userupdateform.jsp").forward(request, response);
                return;
            }

            LoginUserDao dao = new LoginUserDao();
            int result = dao.updateLoginUserInfo(record);
            if(result == 1) {
                request.setAttribute("loginUserRecord", record);
                getServletContext().getRequestDispatcher("/view/user/userupdateresult.jsp").forward(request, response);
            } else {
                request.setAttribute("errormessage", record.getUserName() + "を更新できませんでした。");
                getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
            }
        } catch(Exception e){
            e.printStackTrace();
            request.setAttribute("errormessage", e.getMessage());
            getServletContext().getRequestDispatcher("/view/common/error.jsp").forward(request, response);
        }
    }
}