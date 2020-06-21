package controllers.shops;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Order;
import utils.DBUtil;

/**
 * Servlet implementation class ShopsMenuDestroyServlet
 */
@WebServlet("/shops/menudestroy")
public class ShopsMenuDestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopsMenuDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            // セッションスコープからIDを取得して
            // 該当のIDの1件のみをデータベースから取得
            Order o = em.find(Order.class, (Integer)(request.getSession().getAttribute("order_id")));

            em.getTransaction().begin();
            em.remove(o);       // データ削除
            em.getTransaction().commit();

            request.getSession().setAttribute("flush", "受注データを削除しました。");

            em.close();

            request.getSession().removeAttribute("order_id");

            response.sendRedirect(request.getContextPath() + "/");
        }
}
}