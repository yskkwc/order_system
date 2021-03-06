package controllers.admin;

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
 * Servlet implementation class AdminIndexServlet
 */
@WebServlet("/admin/index")
public class AdminIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        int page = 1;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(NumberFormatException e) { }
        List<Shop> shops = em.createNamedQuery("getAllShops", Shop.class)
                                     .setFirstResult(15 * (page - 1))
                                     .setMaxResults(15)
                                     .getResultList();

        long shops_count = (long)em.createNamedQuery("getShopsCount", Long.class)
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
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/admin/index.jsp");
        rd.forward(request, response);
    }


}
