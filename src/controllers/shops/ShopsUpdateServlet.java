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
import models.validators.ShopValidetor;
import utils.DBUtil;

/**
 * Servlet implementation class ShopsUpdateServlet
 */
@WebServlet("/shops/update")
public class ShopsUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopsUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String) request.getParameter("_token");

     // 空チェック
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Shop s = em.find(Shop.class, (Integer) (request.getSession().getAttribute("shop_id")));

            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setDenwa(request.getParameter("denwa"));
            s.setAddress(request.getParameter("address"));
            s.setArea(Integer.parseInt(request.getParameter("area")));
            s.setInfo(request.getParameter("info"));

            List<String> errors = ShopValidetor.validate(s, true, true);
            if (errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("report", s);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shops/edit.jsp");
                rd.forward(request, response);

            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                // セッションスコープを除外
                request.getSession().removeAttribute("shop_id");

                response.sendRedirect(request.getContextPath() + "/shops/index");
            }

        }
    }
}
