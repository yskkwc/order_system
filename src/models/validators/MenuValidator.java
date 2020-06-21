package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Menu;

public class MenuValidator {
    public static List<String> validate(Menu m) {
        List<String> errors = new ArrayList<String>();

        String name_error = _validateName(m.getName());
        if (!name_error.equals("")) {
            errors.add(name_error);
        }

        String price_error = _validatePrice(m.getPrice());
        if (!price_error.equals("")) {
            errors.add(price_error);
        }
        return errors;
    }

    private static String _validateName(String name) {
        if (name == null || name.equals("")) {
            return "商品名を入力してください。";
        }

        return "";
    }

    private static String _validatePrice(Integer price) {
        if (price == null || price.equals("")) {
            return "お値段を設定してください。";
        }

        return "";
    }
}
