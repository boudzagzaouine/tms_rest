package com.bagile.gmo.exceptions;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adadi on 1/25/2016.
 */
public class UniqueException extends Exception {
    private List<Validator> validators;

    UniqueException() {
        validators = new ArrayList<>();
    }

    public void addUnique(Validator validator) {
        validators.add(validator);
    }

    public int size() {
        return validators.size();
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
