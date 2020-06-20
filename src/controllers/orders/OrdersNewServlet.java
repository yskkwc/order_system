package controllers.orders;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Menu;
import models.Order;
import utils.DBUtil;

/**
 * Servlet implementation class OrdersNewServlet
 */
@WebServlet("/orders/new")
public class OrdersNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Menu m = em.find(Menu.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("menu", m);

        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("order", new Order());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/orders/new.jsp");
        rd.forward(request, response);
    }

}