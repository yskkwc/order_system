package controllers.toppage;

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
 * Servlet implementation class ShopperTopIndex
 */
@WebServlet("/index.html")
public class ShopperTopIndex extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopperTopIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     // DBに接続
        EntityManager em = DBUtil.createEntityManager();

        // "login_employee"を取り出す(LoginServletでセットしたやつ)
        Shop login_shop = (Shop) request.getSession().getAttribute("login_shop");

        int page;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            page = 1;
        }
        List<Shop> shops = em.createNamedQuery("getMyAllShops", Shop.class)
                .setParameter("shop", login_shop)
                .setFirstResult(15 * (page - 1))
                .setMaxResults(15)
                .getResultList();

        long shops_count = (long) em.createNamedQuery("getMyShopsCount", Long.class)
                .setParameter("shop", login_shop)
                .getSingleResult();

        em.close();

        //"getMyAllReports" (Report rのEmployeeとDBのemployeeのr.id DESCが==)
        request.setAttribute("shops", shops);
        request.setAttribute("shops_count", shops_count);
        request.setAttribute("page", page);

        if (request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/toppage/shopindex.jsp");
        rd.forward(request, response);
    }
}
