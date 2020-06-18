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
import utils.DBUtil;

/**
 * Servlet implementation class OrdersIndexServlet
 */
@WebServlet("/orders/index")
public class OrdersIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer number = Integer.parseInt(request.getParameter("number"));

        Integer id = Integer.parseInt(request.getParameter("checkbox"));

        EntityManager em = DBUtil.createEntityManager();
        Menu m = em.find(Menu.class, id);

        request.setAttribute("number", number);
        request.setAttribute("menu", m);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/orders/confirm.jsp");
        rd.forward(request, response);
    }

}
