package com.example.lab1;

public class UserUtils {

    public static boolean isDigit (String str) {

        if(str == null)
            return false;

        boolean isInt = false;

        for(char c : str.toCharArray()) {

            if(c == '.')
                continue;

            isInt = Character.isDigit(c);

            if(!isInt)
                break;
        }

        return isInt;
    }
}
