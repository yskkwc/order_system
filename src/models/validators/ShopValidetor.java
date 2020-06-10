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

        String email_error = _validateEmail(s.getEmail());
        if(!email_error.equals("")) {
            errors.add(email_error);
        }

        String denwa_error = _validateDenwa(s.getDenwa());
        if(!denwa_error.equals("")) {
            errors.add(denwa_error);
        }

        String address_error = _validateAddress(s.getAddress());
        if(!address_error.equals("")) {
            errors.add(address_error);
        }

        String area_error = _validateArea(s.getArea());
        if(!area_error.equals("")) {
            errors.add(area_error);
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

    private static String _validateEmail(String email) {
        if (email == null || email.equals("")) {
            return "メールアドレスを入力してください。";
        }

        return "";
    }

    private static String _validateDenwa(Integer denwa) {
        if (denwa == null || denwa.equals("")) {
            return "電話番号を入力してください。";
        }

        return "";
    }

    private static String _validateAddress(String address) {
        if (address == null || address.equals("")) {
            return "住所を入力してください。";
        }

        return "";
    }

    private static String _validateArea(Integer area) {
        if (area == 0 || area.equals("")) {
            /* option value = 0 */
            return "近い地域を入力してください。";
        }

        return "";
    }

    // infoは空欄OKにしている（nullable = true)
}
