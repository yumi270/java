package board.app.sample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.app.sample.bean.user.LoginUserRecordBean;

// 管理者権限チェックを行うフィルター
@WebFilter("/user/*")
public class AdminCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httprequest = (HttpServletRequest) request;
        HttpServletResponse httpresponse = (HttpServletResponse) response;
        HttpSession session = httprequest.getSession(false);
        if(session != null) {
            LoginUserRecordBean loginUserRecordBean = (LoginUserRecordBean) session.getAttribute("loginUserRecord");
            if(loginUserRecordBean !=  null && "1".equals(loginUserRecordBean.getAdminFlag())){
                chain.doFilter(request, response);
            } else {
                request.setAttribute("errormessage", "アクセス権限がありません。");
                request.getRequestDispatcher("/view/common/error.jsp").forward(request, response);
            }
        } else {
            httpresponse.sendRedirect(httprequest.getContextPath() + "/loginerror");
        }
    }

    @Override
    public void destroy() {

    }

}
