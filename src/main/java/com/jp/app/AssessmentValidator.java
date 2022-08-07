package com.jp.app;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.validation.Validation.buildDefaultValidatorFactory;

public class AssessmentValidator {
    Validator validator;
    Logger logger;

    public AssessmentValidator (){
        this.validator = buildDefaultValidatorFactory().getValidator();
        logger = Logger.getLogger("My Logger");
    }

    public <T> boolean validate(T bean) {
        Set<ConstraintViolation<T>> infoViolations = validator.validate((T)bean, InfoLevel.class);
        infoViolations.forEach(i -> System.out.println("INFO:" + i.getMessage()));

        Set<ConstraintViolation<T>> errorViolations = validator.validate((T)bean, ErrorLevel.class);
        errorViolations.forEach(i -> {
            System.out.println("error:" + i.getMessage());
            logger.log(Level.SEVERE, i.getMessage());
            i.getPropertyPath().forEach(j -> System.out.println(j.getName()));
        });
        return errorViolations.isEmpty();
    }
}
