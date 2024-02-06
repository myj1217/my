package com.springex.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CheckboxFormatter implements Formatter<Boolean> {
    @Override
    // Locale : 현재 지역에 맞게 형식을 식별함
    public Boolean parse(String text, Locale locale) throws ParseException {
        if (text == null) {
            return false;
        }
        // on 문자열과 일치하면 true
        return text.equals("on");
    }
    @Override
    public String print(Boolean object, Locale locale) {
        return object.toString();
    }
}
