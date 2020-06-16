package controllers.orders;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Menu;
import models.Shop;
import utils.DBUtil;

/**
 * Servlet implementation class OrdersMenuServlet
 */
@WebServlet("/orders/menu")
public class OrdersMenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            EntityManager em = DBUtil.createEntityManager();

            Shop s = em.find(Shop.class, Integer.parseInt(request.getParameter("id")));

            int page;
            try{
                page = Integer.parseInt(request.getParameter("page"));
            } catch(Exception e) {
                page = 1;
            }
            List<Menu> menus = em.createNamedQuery("getOrderMenus", Menu.class)
                                      .setParameter("shop", s.getId())
                                      .setFirstResult(15 * (page - 1))
                                      .setMaxResults(15)
                                      .getResultList();

            long menus_count = (long)em.createNamedQuery("getOrdersCount", Long.class)
                                        .setParameter("shop", s.getId())
                                        .getSingleResult();

            em.close();

            //"getMyAllMenus" (Menu sのshopとDBのshopのm.id DESCが==)
            request.setAttribute("menus", menus);
            request.setAttribute("menus_count", menus_count);
            request.setAttribute("page", page);

            if(request.getSession().getAttribute("flush") != null) {
                request.setAttribute("flush", request.getSession().getAttribute("flush"));
                request.getSession().removeAttribute("flush");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/orders/menuindex.jsp");
            rd.forward(request, response);
        }
    }