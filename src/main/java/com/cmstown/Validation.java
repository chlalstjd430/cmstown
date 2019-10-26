package com.cmstown;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static String emailRegex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
    private static String pwRegex ="\\d{4}";

    public static boolean checkStringIsNull(String str){
        if(str == null || str.length() == 0 || str =="")
            return false;
        return true;
    }
    public static boolean isNull(Object obj){
        if(obj == null) return false;
        return true;
    }

    public static boolean isPossibleEmail(String email){
        if(!checkStringIsNull(email)) return false;

        Pattern p = Pattern.compile(emailRegex);
        Matcher m = p.matcher(email);
        if(!m.matches()) return false;

        return true;
    }

    public static boolean isPossiblePW(String pw){
        if(!checkStringIsNull(pw)) return false;

        Pattern p = Pattern.compile(pwRegex);
        Matcher m = p.matcher(pw);
        if(!m.matches()) return false;

        return true;
    }
}
