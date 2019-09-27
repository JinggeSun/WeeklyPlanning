package com.sun.restFulApi.validator;

import com.sun.restFulApi.entity.Book;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","NotNull","书名不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"author","NotNull","作者不能为空");
    }
}
