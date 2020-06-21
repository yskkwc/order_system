package filters;

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

import models.Shop;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String context_path = ((HttpServletRequest) request).getContextPath();
        String servlet_path = ((HttpServletRequest) request).getServletPath();

        // CSSフォルダ内は認証処理から除外する
        if (!servlet_path.matches("/css.*") && !servlet_path.matches("/orders.*")) {
            HttpSession session = ((HttpServletRequest) request).getSession();

            // セッションスコープに保存されたlogin_shopを取得
            Shop s = (Shop) session.getAttribute("login_shop");

            if (!servlet_path.equals("/login") && !servlet_path.equals("/shops/new")
                    && !servlet_path.equals("/shops/create")) {

                if (s == null) {
                    ((HttpServletResponse) response).sendRedirect(context_path + "/login");

                    return;
                }

            } else {

                if (s != null) {
                    ((HttpServletResponse) response).sendRedirect(context_path + "/menus/index");

                    return;
                }

            }

        }

        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}