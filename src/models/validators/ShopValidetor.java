package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Shop;

public class ShopValidetor {
    public static List<String> validate(Shop s, Boolean name_duplicate_check_flag, Boolean password_check_flag) {
        List<String> errors = new ArrayList<String>();

        String name_error = _validateName(s.getName());
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
    private static String _validateName(String name) {
        if(name == null || name.equals("")) {
            return "「お店の登録名」を入力してください。";
            }
        return "";
        }

    // パスワードの必須入力チェック
    private static String _validatePassword(String password, Boolean password_check_flag) {
        // パスワードを変更する場合のみ実行
        if(password_check_flag && (password == null || password.equals(""))) {
            return "「パスワード」を入力してください。";
        }
        return "";
    }

    private static String _validateEmail(String email) {
        if (email == null || email.equals("")) {
            return "「メールアドレス」を入力してください。";
        }

        return "";
    }

    private static String _validateDenwa(String denwa) {
        if (denwa == null || denwa.equals("")) {
            return "「電話番号」を入力してください。";
        }

        return "";
    }

    private static String _validateAddress(String address) {
        if (address == null || address.equals("")) {
            return "「住所」を入力してください。";
        }

        return "";
    }

    private static String _validateArea(Integer area) {
        if (area == 0 || area.equals("")) {
            /* option value = 0 */
            return "「近い地域を選択してください」を押して近い地域を選んで下さい。";
        }

        return "";
    }

    // infoは空欄OKにしている（nullable = true)
}
