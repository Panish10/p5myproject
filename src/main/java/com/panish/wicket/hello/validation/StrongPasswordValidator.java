package com.panish.wicket.hello.validation;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import java.util.regex.Pattern;

public class StrongPasswordValidator implements IValidator<String> {

    private final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    private final Pattern pattern;

    public StrongPasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    @Override
    public void validate(IValidatable<String> validatable) {

        //get input from attached component
        final String password = validatable.getValue();

        // validate password
        if (pattern.matcher(password).matches() == false) {

            //Message from key "StrongPasswordValidator.not-strong-password"
            error(validatable, "StrongPasswordValidator.not-strong-password");
        }
    }

    private void error(IValidatable<String> validatable, String errorKey) {
        ValidationError error = new ValidationError();
        error.addMessageKey(getClass().getSimpleName() + "." + errorKey);
        validatable.error(error);
    }
}
