package controllers.orders;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Menu;
import models.Order;
import models.Shop;
import models.validators.OrderValidator;
import utils.DBUtil;

/**
 * Servlet implementation class OrdersCreateServlet
 */
@WebServlet("/orders/create")
public class OrdersCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

        Order o = new Order();

        o.setShop((Shop) request.getSession().getAttribute("shop_id"));
        o.setMenu((Menu) request.getSession().getAttribute("menu_id"));

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        o.setOrder_date(currentTime);

        o.setNumber(Integer.parseInt(request.getParameter("number")));
        o.setName(request.getParameter("name"));
        o.setAddress(request.getParameter("address"));
        o.setDenwa(request.getParameter("denwa"));

        List<String> errors = OrderValidator.validate(o);
        if(errors.size() > 0){
            em.close();

            request.setAttribute("_token", request.getSession().getId());
            request.setAttribute("order", o);
            request.setAttribute("errors", errors);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/orders/new.jsp");
            rd.forward(request, response);
        } else {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            em.close();

            request.getSession().removeAttribute("shop_id");
            request.getSession().removeAttribute("menu_id");
            request.getSession().setAttribute("flush", "注文を受付ました。");

            response.sendRedirect(request.getContextPath() + "/orders/shop");
            }
        }
    }

}

