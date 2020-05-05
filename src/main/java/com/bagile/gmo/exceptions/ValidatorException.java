package com.bagile.gmo.exceptions;

import com.bagile.gmo.util.Search;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by adadi on 1/18/2016.
 */
public class ValidatorException extends Exception implements Serializable {
    @JsonIgnore
    private List<Validator> validators;
    @JsonIgnore
    private ConstraintViolationException constraintViolationException;


    public ValidatorException() {
        super();
        validators = new ArrayList<>();
    }

    public ConstraintViolationException getConstraintViolationException() {
        return constraintViolationException;
    }

    public void setConstraintViolationException(ConstraintViolationException constraintViolationException) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, NoSuchFieldException {
        this.constraintViolationException = constraintViolationException;
        reset();
    }

    public void reset() throws NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException, InvocationTargetException, ClassNotFoundException {
        Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
        validators.clear();
        for (ConstraintViolation<?> constraintViolation : constraintViolations
                ) {
            String path = constraintViolation.getRootBeanClass().getSimpleName();
            path = path.substring(path.lastIndexOf('.') + 4);
            Path propertyPath = constraintViolation.getPropertyPath();

            String field = propertyPath.iterator().next().getName() + "";
            field = Search.getFieldDto(path, field);
            Validator validator = new Validator();
            validator.setField(field);
            validator.setMessage(constraintViolation.getMessage());
            validator.setPath(path);
            validators.add(validator);
        }
    }


    public ValidatorException(ConstraintViolationException e) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, NoSuchFieldException {
        super();
        constraintViolationException = e;
        validators = new ArrayList<>();
        reset();
    }

    @Override
    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Validator validator : validators) {
            stringBuffer.append(validator.toString());
        }
        return stringBuffer.toString();
    }
}
