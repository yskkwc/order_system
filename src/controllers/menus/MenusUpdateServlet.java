package controllers.menus;

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
import models.validators.MenuValidator;
import utils.DBUtil;

/**
 * Servlet implementation class MenusUpdateServlet
 */
@WebServlet("/menus/update")
public class MenusUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenusUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     // edit.jspで参照してる_form.jsp内の"_token"
        String _token = (String) request.getParameter("_token");

        // 空チェック
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            // DBへ"id"をInt型にして送り、この"id"の情報をupdateservletで受けて、mにしまう
            Menu m = em.find(Menu.class, (Integer) (request.getSession().getAttribute("menu_id")));

            m.setName(request.getParameter("name"));
            m.setPrice(Integer.parseInt(request.getParameter("price")));
            m.setContent(request.getParameter("content"));

            //値をsetした変数rをバリデーション に通す
            List<String> errors = MenuValidator.validate(m);
            if (errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("report", m);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/menus/edit.jsp");
                rd.forward(request, response);

            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                // セッションスコープを除外
                request.getSession().removeAttribute("menu_id");

                response.sendRedirect(request.getContextPath() + "/");
            }

        }
    }
}