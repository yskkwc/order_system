package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Shop;
import utils.DBUtil;

public class ShopValidetor {
    public static List<String> validate(Shop s, Boolean name_duplicate_check_flag, Boolean password_check_flag) {
        List<String> errors = new ArrayList<String>();

        String name_error = _validateName(s.getName(), name_duplicate_check_flag);
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String password_error = _validatePassword(s.getPassword(), password_check_flag);
        if(!password_error.equals("")) {
            errors.add(password_error);
        }
        return errors;
    }

    // 店舗名の入力チェック
    private static String _validateName(String name, Boolean name_duplicate_check_flag) {
        if(name == null || name.equals("")) {
            return "「お店の登録名」を入力してください。";
        }
        if(name_duplicate_check_flag) {
            EntityManager em = DBUtil.createEntityManager();
            long employees_count = (long)em.createNamedQuery("checkRegisteredName", Long.class)
                                           .setParameter("name", name)
                                             .getSingleResult();
            em.close();
            if(employees_count > 0) {
                return "入力された「お店の登録名」が既に存在しています。";
            }
        }
        return "";
    }

    // パスワードの必須入力チェック
    private static String _validatePassword(String password, Boolean password_check_flag) {
        // パスワードを変更する場合のみ実行
        if(password_check_flag && (password == null || password.equals(""))) {
            return "パスワードを入力してください。";
        }
        return "";
    }
}
