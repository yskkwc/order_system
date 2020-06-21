package controllers.shops;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Shop;
import utils.DBUtil;

/**
 * Servlet implementation class ShopsIndexServlet
 */
@WebServlet("/shops/index")
public class ShopsIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopsIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Shop login_shop = (Shop) request.getSession().getAttribute("login_shop");

        if (login_shop == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
            rd.forward(request, response);

        } else {

            int page = 1;
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException e) {
            }
            List<Shop> shops = em.createNamedQuery("getMyAllShops", Shop.class)
                    .setParameter("id", login_shop.getId())
                    .setFirstResult(15 * (page - 1))
                    .setMaxResults(15)
                    .getResultList();

            long shops_count = (long) em.createNamedQuery("getMyShopsCount", Long.class)
                    .setParameter("id", login_shop.getId())
                    .getSingleResult();

            em.close();

            //index.jspに上で取得したデータを送る
            request.setAttribute("shops", shops);
            request.setAttribute("shops_count", shops_count);
            request.setAttribute("page", page);

            //フラッシュメッセージ
            if (request.getSession().getAttribute("flush") != null) {
                request.setAttribute("flush", request.getSession().getAttribute("flush"));
                request.getSession().removeAttribute("flush");
            }

            //送り先の指定(リクエストスコープは受け/取る、一回まで)
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shops/index.jsp");
            rd.forward(request, response);
        }
    }
}