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

// ログインチェックを行うフィルター
@WebFilter(urlPatterns={"/user/*", "/board/*"})
public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httprequest = (HttpServletRequest) request;
        HttpServletResponse httpresponse = (HttpServletResponse) response;
        HttpSession session = httprequest.getSession(false);
        boolean isLoggedIn = session != null && ((LoginUserRecordBean) session.getAttribute("loginUserRecord")) != null;

        if(isLoggedIn) {
            chain.doFilter(request, response);
        } else {
            httpresponse.sendRedirect(httprequest.getContextPath() + "/loginerror");
        }
    }

    @Override
    public void destroy() {

    }

}
