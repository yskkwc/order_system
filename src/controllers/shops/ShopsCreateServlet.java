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
import utils.EncryptUtil;

/**
 * Servlet implementation class ShopsCreateServlet
 */
@WebServlet("/shops/create")
public class ShopsCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopsCreateServlet() {
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

            Shop s = new Shop();

            s.setName(request.getParameter("name"));
            s.setPassword(
                    EncryptUtil.getPasswordEncrypt(
                            request.getParameter("password"),
                            (String)this.getServletContext().getAttribute("salt")
                            )
                    );
            s.setEmail(request.getParameter("email"));
            s.setDenwa(request.getParameter("denwa"));
            s.setAddress(request.getParameter("address"));
            s.setArea(Integer.parseInt(request.getParameter("area")));

          //値をsetした変数rをバリデーション に通す
            List<String> errors = ShopValidetor.validate(s, true, true);
            // エラーが検出されればDB閉じて値はs="shop",エラー情報はerrors="errors"
            // getId()は"_token"にしてnew.jspに返す
            if (errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("shop", s);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shops/new.jsp");
                rd.forward(request, response);
            } else {
                // DBの処理を進める
                em.getTransaction().begin();
                em.persist(s);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                // リダイヤル index.jspへ。
                response.sendRedirect(request.getContextPath() + "/shops/index");
            }
        }
    }
}