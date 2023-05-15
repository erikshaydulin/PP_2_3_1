package web.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import web.model.User;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
