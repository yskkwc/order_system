package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Admin;

public class AdminValidator {
    public static List<String> validate(Admin a, Boolean password_check_flag) {
        List<String> errors = new ArrayList<String>();

        String name_error = _validateName(a.getName());
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String password_error = _validatePassword(a.getPassword(), password_check_flag);
        if(!password_error.equals("")) {
            errors.add(password_error);
        }

        return errors;
    }

    // 名前の入力チェック
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
}
