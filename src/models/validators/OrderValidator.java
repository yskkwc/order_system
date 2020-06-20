package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Order;

public class OrderValidator {
    public static List<String> validate(Order o) {
        List<String> errors = new ArrayList<String>();

        String number_error = _validateNumber(o.getNumber());
        if(!number_error.equals("") && number_error != "0") {
            errors.add(number_error);
        }

        String name_error = _validateName(o.getName());
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String address_error = _validateAddress(o.getAddress());
        if(!address_error.equals("")) {
            errors.add(address_error);
        }

        String denwa_error = _validateDenwa(o.getDenwa());
        if(!denwa_error.equals("")) {
            errors.add(denwa_error);
        }
        return errors;
    }

    private static String _validateNumber(Integer number) {
        if (number == 0 || number.equals("")) {
            /* 個数が = 0 */
            return "個数を選択してください";
        }

        return "";
    }

    private static String _validateName(String name) {
        if(name == null || name.equals("")) {
            return "お名前を入力してください。";
            }

        return "";
    }

    private static String _validateAddress(String address) {
        if(address == null || address.equals("")) {
            return "おところを入力してください。";
            }

        return "";
    }

    private static String _validateDenwa(String denwa) {
        if(denwa == null || denwa.equals("")) {
            return "お電話番号を入力してください。";
            }

        return "";
    }
}
