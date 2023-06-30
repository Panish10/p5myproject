package com.panish.wicket.form.validator;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UsernameValidator implements IValidator<String> {

    List<String> existingUsernames = Arrays.asList("bigJack", "anonymous", "mrSmith", "panish");

    @Override
    public void validate(IValidatable<String> validatable) {
        String chosenUserName = validatable.getValue();

        if (existingUsernames.contains(chosenUserName)) {
            ValidationError error = new ValidationError(this);
            Random random = new Random();

            error.setVariable("suggestedUserName", validatable.getValue() + random.nextInt());
            validatable.error(error);
        }
    }
}
